package com.example.movielistscreens

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.movielistscreens.databinding.SigninBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: SigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signinbutton.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()

            if (isValidInput(username, password)) {
                // Move to Movie List Screen if validation passes
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun isValidInput(username: String, password: String): Boolean {

        // Check if the user name is not empty
        if (TextUtils.isEmpty(username)) {
            binding.username.error = "Username cannot be empty"
            return false
        }

        // Check if the password is not empty
        if (TextUtils.isEmpty(password)) {
            binding.password.error = "Password cannot be empty"
            return false
        }

        // Check if the password has at least 8 characters
        if (password.length < 8) {
            binding.password.error = "Password must be at least 8 characters long" // Show error under password field
            return false
        }

        // Check if the password contains at least one letter
        if (!password.matches(".*[A-Za-z].*".toRegex())) {
            binding.password.error = "Password must contain at least one letter" // Show error under password field
            return false
        }

        // Check if the password contains at least one number
        if (!password.matches(".*[0-9].*".toRegex())) {
            binding.password.error = "Password must contain at least one number" // Show error under password field
            return false
        }

        return true
    }
}
