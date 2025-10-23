package com.isetr.logapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.isetr.logapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    // 1. Déclaration de l'objet de liaison (Binding Object)
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonLogin.setOnClickListener {
            val username = binding.editTextUsername.text.toString()
            val password = binding.editTextPassword.text.toString()
            if (username.isNotEmpty() && password.isNotEmpty()) {
                if (username == "admin" && password == "admin") {
                    val user = User(username, password)
                    val intent = Intent(this, ProfileActivity::class.java).apply {
                        putExtra("EXTRA_USER", user)
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}


