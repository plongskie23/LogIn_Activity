package com.example.log_in

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var textViewMessage: TextView

    // Hardcoded credentials
    private val validUsername = "admin"
    private val validPassword = "12345"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
        textViewMessage = findViewById(R.id.textViewMessage)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            // Validate input
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check credentials
            if (username == validUsername && password == validPassword) {
                // Success
                textViewMessage.text = "Welcome, $username!"
                textViewMessage.visibility = View.VISIBLE

                editTextUsername.visibility = View.GONE
                editTextPassword.visibility = View.GONE
                buttonLogin.visibility = View.GONE
            } else {
                // Failure
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                editTextPassword.text.clear() // Clear password field
            }
        }
    }
}