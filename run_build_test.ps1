param(
    [switch]$AutoAll,
    [switch]$ScrcpyOnly
)

# AgentShell Build & Test Automation Script
# Optimized PowerShell script for efficient device selection and deployment

$ApkPath = "app\build\outputs\apk\debug\app-debug.apk"
$PackageName = "com.local.balodseva"
$MainActivity = ".ui.auth.LoginActivity"

function Get-FirstDevice {
    $out = adb devices
    $devices = @()
    foreach ($line in $out) {
        # Matches the serial number in "serial\tdevice"
        if ($line -match "^\s*(\S+)\s+device\s*$") {
            $devices += $Matches[1]
        }
    }
    if ($devices.Count -eq 0) {
        Write-Host " [!] No devices detected via ADB." -ForegroundColor Red
        Write-Host " Make sure USB Debugging is enabled."
        exit 1
    }
    return $devices[0]
}

function Run-Scrcpy {
    param($Device)
    Write-Host "`n[TASK] Launching scrcpy for $Device..." -ForegroundColor Blue
    # Run scrcpy and wait for it to exit
    scrcpy -s $Device
}

function Build-And-Deploy {
    param($Device)
    Write-Host "`n[TASK] Starting Build Pipeline..." -ForegroundColor Blue
    .\gradlew.bat assembleDebug
    if ($LASTEXITCODE -eq 0) {
        Write-Host "`n[TASK] Deploying to $Device..." -ForegroundColor Blue
        adb -s $Device install -r $ApkPath
        Write-Host "[TASK] Launching $PackageName..." -ForegroundColor Blue
        adb -s $Device shell am start -n "$PackageName/$MainActivity"
        Write-Host "`n[SUCCESS] Build & Deployment Complete!" -ForegroundColor Green
        return $true
    } else {
        Write-Host "`n[!] Build Failed." -ForegroundColor Red
        return $false
    }
}

# Main Script Execution

$currentDevice = Get-FirstDevice
Write-Host "Auto-detected device: $currentDevice" -ForegroundColor Green

if ($AutoAll) {
    if (Build-And-Deploy -Device $currentDevice) {
        Run-Scrcpy -Device $currentDevice
    }
    exit 0
}

if ($ScrcpyOnly) {
    Run-Scrcpy -Device $currentDevice
    exit 0
}

# TUI Loop
while ($true) {
    Write-Host "==========================================" -ForegroundColor Yellow
    Write-Host "   AgentShell: ACTION MENU" -ForegroundColor Yellow
    Write-Host "==========================================" -ForegroundColor Yellow
    Write-Host " Device: $currentDevice" -ForegroundColor Cyan
    Write-Host ""
    Write-Host " 1) Open scrcpy only"
    Write-Host " 2) Build, deploy, and open scrcpy (Auto All)"
    Write-Host " Q) Quit"
    Write-Host "==========================================" -ForegroundColor Yellow

    $choice = Read-Host " Select Action"

    if ($choice -eq "q" -or $choice -eq "Q") { 
        exit 0 
    }
    elseif ($choice -eq "1") {
        Run-Scrcpy -Device $currentDevice
        exit 0
    }
    elseif ($choice -eq "2") {
        if (Build-And-Deploy -Device $currentDevice) {
            Run-Scrcpy -Device $currentDevice
        }
        exit 0
    }
    else {
        Clear-Host
        Write-Host "Invalid choice, please try again." -ForegroundColor Red
    }
}
