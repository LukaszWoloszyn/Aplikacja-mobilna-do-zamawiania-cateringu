package com.example.projectcatering

import User
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import org.json.JSONArray
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectcatering.LoginActivity
import com.example.projectcatering.MySingleton
import com.example.projectcatering.R
import com.example.projectcatering.UserAdapter


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private val userList = mutableListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toolbarButton: Button = findViewById(R.id.toolbar_button)
        toolbarButton.setOnClickListener {
            val intentSA = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intentSA)
        }

        val myButton: Button = findViewById(R.id.myButton)
        myButton.setOnClickListener {
            val intentSA = Intent(applicationContext, HomepageActivity::class.java)
            startActivity(intentSA)
        }
    }
}

//to bylo do przetestowania pobierania danych z bazy

//    private fun fetchUsers() {
//        val url = "http://10.0.2.2/get_users.php" // Poprawny adres URL dla emulatora
//
//        val stringRequest = StringRequest(
//            Request.Method.GET, url,
//            Response.Listener { response ->
//                try {
//                    val jsonArray = JSONArray(response)
//                    for (i in 0 until jsonArray.length()) {
//                        val jsonObject = jsonArray.getJSONObject(i)
//                        val user = User(
//                            id = jsonObject.getInt("id"),
//                            nazwa_uzytkownika = jsonObject.getString("nazwa_uzytkownika"),
//                            email = jsonObject.getString("email"),
//                            imie = jsonObject.optString("imie", ""),
//                            nazwisko = jsonObject.optString("nazwisko", ""),
//                            adres_dostawy = jsonObject.optString("adres_dostawy", ""),
//                            telefon = jsonObject.optString("telefon", ""),
//                            rola = jsonObject.getString("rola")
//                        )
//                        userList.add(user)
//                    }
//                    if (::userAdapter.isInitialized) {
//                        userAdapter.notifyDataSetChanged() // Aktualizacja RecyclerView
//                    } else {
//                        userAdapter = UserAdapter(userList)
//                        recyclerView.adapter = userAdapter
//                    }
//                } catch (e: Exception) {
//                    Log.e("Parsing Error", e.message ?: "Unknown error")
//                }
//            },
//            Response.ErrorListener {
//                Log.e("API Error", it.message ?: "Unknown error")
//            }
//        )
//
//        MySingleton.getInstance(this).addToRequestQueue(stringRequest)
//    }
//}


