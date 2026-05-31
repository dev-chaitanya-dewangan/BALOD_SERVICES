package com.local.balodseva.ui.auth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.local.balodseva.MainActivity
import com.local.balodseva.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var verificationId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: Check if user is already logged in (FirebaseAuth.getInstance().currentUser != null)
        // If logged in, navigate to MainActivity directly:
        // navigateToMain()

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnSendOtp.setOnClickListener {
            val phone = binding.etPhone.text.toString().trim()
            if (phone.length == 10) {
                sendOtp(phone)
            } else {
                Toast.makeText(this, "कृपया सही मोबाइल नंबर दर्ज करें", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnVerifyOtp.setOnClickListener {
            val otp = binding.etOtp.text.toString().trim()
            if (otp.length == 6) {
                verifyOtp(otp)
            } else {
                Toast.makeText(this, "कृपया सही OTP दर्ज करें", Toast.LENGTH_SHORT).show()
            }
        }
        
        binding.tvResendOtp.setOnClickListener {
            // Resend OTP logic
            Toast.makeText(this, "OTP दोबारा भेजा गया", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendOtp(phoneNumber: String) {
        showLoading(true)
        
        // MOCK LOGIC for V1 (Until Firebase is fully linked)
        // TODO: Replace with PhoneAuthProvider.verifyPhoneNumber
        binding.root.postDelayed({
            showLoading(false)
            binding.layoutPhone.visibility = View.GONE
            binding.layoutOtp.visibility = View.VISIBLE
            Toast.makeText(this, "OTP भेज दिया गया है (Testing: Use any 6 digits)", Toast.LENGTH_LONG).show()
        }, 1500)
    }

    private fun verifyOtp(otp: String) {
        showLoading(true)
        
        // MOCK LOGIC for V1 (Until Firebase is fully linked)
        // TODO: Replace with PhoneAuthProvider.getCredential and signInWithCredential
        binding.root.postDelayed({
            showLoading(false)
            navigateToMain()
        }, 1500)
    }

    private fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        binding.btnSendOtp.isEnabled = !isLoading
        binding.btnVerifyOtp.isEnabled = !isLoading
    }
}
