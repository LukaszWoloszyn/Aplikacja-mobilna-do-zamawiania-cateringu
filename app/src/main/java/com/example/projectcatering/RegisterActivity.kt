package com.example.projectcatering

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val userName = findViewById<EditText>(R.id.userName)
        val name = findViewById<EditText>(R.id.name)
        val surname = findViewById<EditText>(R.id.surname)
        val email = findViewById<EditText>(R.id.email)
        val phoneNumber = findViewById<EditText>(R.id.phoneNumber)
        val password = findViewById<EditText>(R.id.password)
        val checkPassword = findViewById<EditText>(R.id.checkPassword)
        val deliveryAddress = findViewById<EditText>(R.id.deliveryAddress)
        val createButton = findViewById<Button>(R.id.create)

        createButton.setOnClickListener {
            val passwordText = password.text.toString()
            val checkPasswordText = checkPassword.text.toString()

            if (passwordText != checkPasswordText) {
                Toast.makeText(this, "Hasła nie są zgodne", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val url = "http://10.0.2.2/register.php" // Adres do skryptu PHP
            val queue = Volley.newRequestQueue(this)

            val stringRequest = object : StringRequest(
                Request.Method.POST, url,
                { response ->
                    val responseObject = JSONObject(response)
                    val status = responseObject.getString("status")
                    val message = responseObject.getString("message")

                    if (status == "success") {
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, LoginActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                    }
                },
                { error ->
                    Toast.makeText(this, "Błąd połączenia: ${error.message}", Toast.LENGTH_SHORT).show()
                }
            ) {
                override fun getParams(): Map<String, String> {
                    val params = HashMap<String, String>()
                    params["userName"] = userName.text.toString()
                    params["name"] = name.text.toString()
                    params["surname"] = surname.text.toString()
                    params["email"] = email.text.toString()
                    params["phoneNumber"] = phoneNumber.text.toString()
                    params["password"] = password.text.toString()
                    params["deliveryAddress"] = deliveryAddress.text.toString()
                    return params
                }
            }

            queue.add(stringRequest)
        }

        val mainPage = findViewById<Button>(R.id.mainPage)
        mainPage.setOnClickListener{
            val intentSA = Intent(applicationContext, MainActivity::class.java)
            startActivity(intentSA)
        }
    }

}
