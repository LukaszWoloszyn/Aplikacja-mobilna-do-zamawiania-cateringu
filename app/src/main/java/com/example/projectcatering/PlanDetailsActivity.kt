package com.example.projectcatering

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

class PlanDetailsActivity : AppCompatActivity() {

    private lateinit var mealAdapter: MealAdapter
    private val meals = mutableListOf<Meal>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan_details)

        val planId = intent.getIntExtra("plan_id", -1)

        if (planId == -1) {
            Toast.makeText(this, "Nie przekazano ID planu!", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        val recyclerView: RecyclerView = findViewById(R.id.meals_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        mealAdapter = MealAdapter(meals)
        recyclerView.adapter = mealAdapter

        fetchPlanDetails(planId)
    }

    private fun fetchPlanDetails(planId: Int) {
        val url = "http://10.0.2.2/get_plan_details.php?plan_id=$planId"

        val request = JsonArrayRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                try {
                    meals.clear()
                    for (i in 0 until response.length()) {
                        val jsonObject = response.getJSONObject(i)
                        val meal = Meal(
                            id = jsonObject.getInt("id"),
                            name = jsonObject.getString("nazwa"),
                            description = jsonObject.getString("opis"),
                            price = jsonObject.getDouble("cena"),
                            imageUrl = jsonObject.optString("obraz", null)
                        )
                        meals.add(meal)
                    }
                    mealAdapter.notifyDataSetChanged()
                } catch (e: JSONException) {
                    e.printStackTrace()
                    Toast.makeText(this, "Błąd przetwarzania danych", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener {
                Toast.makeText(this, "Błąd sieci: ${it.message}", Toast.LENGTH_SHORT).show()
            }
        )

        Volley.newRequestQueue(this).add(request)
    }
}
