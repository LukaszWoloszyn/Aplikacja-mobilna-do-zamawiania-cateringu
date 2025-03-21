package com.example.projectcatering

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        dbHelper = DatabaseHelper(this)

        val loginButton: Button = findViewById(R.id.button)
        val loginField: EditText = findViewById(R.id.editTextText)
        val passwordField: EditText = findViewById(R.id.editTextTextPassword)

        loginButton.setOnClickListener {
            val login = loginField.text.toString()
            val password = passwordField.text.toString()

            if (login.isNotEmpty() && password.isNotEmpty()) {
                if (dbHelper.loginUser(login, password)) {
                    Toast.makeText(this, "Zalogowano pomyślnie!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomepageActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Błędny login lub hasło", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Uzupełnij wszystkie pola!", Toast.LENGTH_SHORT).show()
            }
        }

        val register = findViewById<Button>(R.id.register)
        register.setOnClickListener {
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }

        val mainPage = findViewById<Button>(R.id.button4)
        mainPage.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
