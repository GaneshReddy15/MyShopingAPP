package com.example.myshopingapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var usernameInput: EditText
    lateinit var passwordInput: EditText
    lateinit var loginBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        usernameInput = findViewById(R.id.et_email)
        passwordInput = findViewById(R.id.et_password)
        loginBtn = findViewById(R.id.btn_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loginBtn.setOnClickListener {
            // Fetch the input data if needed
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            // Perform any validation or authentication here if needed

            // Create an intent to navigate to HomeActivity
            val intent = Intent(this, HomeActivity::class.java)
            // Optionally, pass data to the HomeActivity
           // intent.putExtra("USERNAME", username)

            // Start the HomeActivity
            startActivity(intent)
        }

    }
}