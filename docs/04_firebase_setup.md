# 04 — Firebase Setup Guide

## Step 1: Create Firebase Project
1. Go to https://console.firebase.google.com
2. Click "Add Project" → Name: `BalodSeva`
3. Disable Google Analytics (not needed for V1)
4. Click "Create Project"

## Step 2: Add Android App
1. In Firebase console → Add app → Android
2. Android package name: `com.local.balodseva`
3. App nickname: `BalodSeva`
4. Download `google-services.json`
5. Place it in: `app/google-services.json`

## Step 3: Enable Phone Auth
1. Firebase Console → Authentication → Sign-in method
2. Enable "Phone" provider
3. For testing, add test phone numbers:
   - Phone: `+91 9000000001`, OTP: `123456`
   - Phone: `+91 9000000002`, OTP: `123456`

## Step 4: Setup Firestore
1. Firebase Console → Firestore Database → Create Database
2. Start in **Test mode** (for development)
3. Region: `asia-south1` (Mumbai — closest to Chhattisgarh)

## Step 5: Security Rules (Production)
```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    match /workers/{workerId} {
      allow read: if true;
      allow create: if request.auth != null;
      allow update, delete: if request.auth != null 
                            && request.auth.uid == workerId;
    }
    match /categories/{catId} {
      allow read: if true;
      allow write: if false;
    }
    match /reviews/{reviewId} {
      allow read: if true;
      allow create: if request.auth != null;
      allow update, delete: if false;
    }
  }
}
```

## Step 6: Firebase Storage Rules
```javascript
rules_version = '2';
service firebase.storage {
  match /b/{bucket}/o {
    match /worker-photos/{workerId}/{fileName} {
      allow read: if true;
      allow write: if request.auth != null 
                   && request.auth.uid == workerId
                   && request.resource.size < 5 * 1024 * 1024
                   && request.resource.contentType.matches('image/.*');
    }
  }
}
```

## Step 7: Seed Initial Data (Firestore)
Run this in Firestore console or use the seed script:

### categories collection
```json
{
  "plumber": {
    "name": "Plumber", "nameHindi": "प्लंबर",
    "color": "#7C4DFF", "order": 1,
    "description": "नल, पाइप, टंकी आदि की मरम्मत",
    "iconName": "ic_plumber"
  },
  "electrician": {
    "name": "Electrician", "nameHindi": "इलेक्ट्रीशियन",
    "color": "#FF6D00", "order": 2,
    "description": "बिजली फिटिंग, वायरिंग, पंखा, लाइट",
    "iconName": "ic_electrician"
  },
  "mason": {
    "name": "Mason", "nameHindi": "मिस्त्री",
    "color": "#00897B", "order": 3,
    "description": "दीवार, प्लास्टर, टाइल्स का काम",
    "iconName": "ic_mason"
  },
  "contractor": {
    "name": "Contractor", "nameHindi": "ठेकेदार",
    "color": "#F57F17", "order": 4,
    "description": "निर्माण कार्य, मकान, बिल्डिंग",
    "iconName": "ic_contractor"
  },
  "mechanic": {
    "name": "Mechanic", "nameHindi": "मैकेनिक",
    "color": "#1565C0", "order": 5,
    "description": "बाइक, कार, स्कूटर की सर्विसिंग",
    "iconName": "ic_mechanic"
  }
}
```

## Gradle Dependencies Required
```kotlin
// In app/build.gradle.kts
implementation(platform("com.google.firebase:firebase-bom:33.1.0"))
implementation("com.google.firebase:firebase-auth-ktx")
implementation("com.google.firebase:firebase-firestore-ktx")
implementation("com.google.firebase:firebase-storage-ktx")

// In root build.gradle.kts plugins
id("com.google.gms.google-services") version "4.4.2" apply false

// In app/build.gradle.kts plugins
id("com.google.gms.google-services")
```

## google-services.json Placeholder
> ⚠️ Place your real `google-services.json` downloaded from Firebase Console at:
> `BalodSeva/app/google-services.json`
> This file is gitignored and must NOT be committed to version control.
