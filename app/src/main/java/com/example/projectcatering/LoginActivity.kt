package com.example.projectcatering

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.projectcatering.MainActivity
import com.example.projectcatering.R
import com.example.projectcatering.RegisterActivity
import org.json.JSONObject


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val loginButton: Button = findViewById(R.id.button)
        val loginField: EditText = findViewById(R.id.editTextText)
        val passwordField: EditText = findViewById(R.id.editTextTextPassword)

        loginButton.setOnClickListener {
            val login = loginField.text.toString()
            val password = passwordField.text.toString()

            if (login.isNotEmpty() && password.isNotEmpty()) {
                loginUser(login, password)
            } else {
                Toast.makeText(this, "Uzupełnij wszystkie pola!", Toast.LENGTH_SHORT).show()
            }
        }

        val register = findViewById<Button>(R.id.register)
        register.setOnClickListener{
            val intentSA = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intentSA)
        }

        val mainPage = findViewById<Button>(R.id.button4)
        mainPage.setOnClickListener{
            val intentSA = Intent(applicationContext, MainActivity::class.java)
            startActivity(intentSA)
        }
    }


    private fun loginUser(login: String, password: String) {
        val url = "http://10.0.2.2/login.php" // Emulator używa 10.0.2.2 dla localhost
        val queue = Volley.newRequestQueue(this)

        val requestBody = JSONObject()
        requestBody.put("login", login)
        requestBody.put("password", password)

        val request = JsonObjectRequest(
            Request.Method.POST, url, requestBody,
            { response ->
                val status = response.getString("status")
                val message = response.getString("message")

                if (status == "success") {
                    // Przenieś użytkownika na stronę główną
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Wyświetl błąd
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                }
            },
            { error ->
                Toast.makeText(this, "Błąd serwera: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        )

        queue.add(request)
    }


}