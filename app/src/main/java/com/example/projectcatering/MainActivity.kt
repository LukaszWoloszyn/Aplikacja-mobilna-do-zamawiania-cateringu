package com.example.projectcatering

import User
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

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

        val dbHelper = DatabaseHelper(this)
        val db = dbHelper.writableDatabase

    }
}



