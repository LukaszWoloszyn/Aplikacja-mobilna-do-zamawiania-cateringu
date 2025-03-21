package com.example.projectcatering

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.android.volley.Request
import com.android.volley.Response
import org.json.JSONArray

class HomepageActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var planAdapter: PlanAdapter
    private val plans = mutableListOf<Plan>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)

        val userIcon: View = findViewById(R.id.icon_user)
        userIcon.setOnClickListener {
            showUserMenu(it)
        }

        recyclerView = findViewById(R.id.plan_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        planAdapter = PlanAdapter(plans, this)
        recyclerView.adapter = planAdapter

        fetchPlansFromDatabase()
    }

    private fun fetchPlansFromDatabase() {
        val url = "http://10.0.2.2/get_plans.php"
        val requestQueue = Volley.newRequestQueue(this)

        val jsonArrayRequest = JsonArrayRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                Log.d("HomepageActivity", "Otrzymana odpowiedź: $response")
                parsePlans(response)
            },
            Response.ErrorListener { error ->
                Toast.makeText(this, "Błąd sieci: ${error.message}", Toast.LENGTH_SHORT).show()
                Log.e("HomepageActivity", "Błąd sieci: ${error.message}")
            }
        )

        requestQueue.add(jsonArrayRequest)
    }

    private fun parsePlans(response: JSONArray) {
        plans.clear()
        for (i in 0 until response.length()) {
            val planJson = response.getJSONObject(i)

            // Pobieram nazwę obrazu z pola "image"
            val imageName = planJson.optString("image", "")
            Log.d("ImageDebug", "Pobrano nazwę obrazu: $imageName")

            val imageResId = if (imageName.isNotEmpty()) {
                resources.getIdentifier(imageName, "drawable", packageName)
            } else {
                R.drawable.pancake // Domyślny obraz
            }

            val plan = Plan(
                id = planJson.getInt("id"),
                title = planJson.getString("title"),
                description = planJson.getString("description"),
                imageRes = imageResId
            )
            plans.add(plan)
        }
        planAdapter.notifyDataSetChanged()
    }


    private fun showUserMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.user_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_profile -> {
                    Toast.makeText(this, "Przejście do profilu", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.menu_manage -> {
                    Toast.makeText(this, "Przejście do zarządzania zamówieniami", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.menu_logout -> {
                    Toast.makeText(this, "Wylogowano", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
        popupMenu.show()
    }
}