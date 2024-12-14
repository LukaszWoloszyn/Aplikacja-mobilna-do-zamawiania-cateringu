package com.example.projectcatering

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlanAdapter(private val plans: List<Plan>, private val context: Context) :
    RecyclerView.Adapter<PlanAdapter.PlanViewHolder>() {

    class PlanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val planImage: ImageView = itemView.findViewById(R.id.plan_image)
        val planTitle: TextView = itemView.findViewById(R.id.plan_title)
        val planDescription: TextView = itemView.findViewById(R.id.plan_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plan, parent, false)
        return PlanViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {
        val plan = plans[position]
        holder.planImage.setImageResource(plan.imageRes)
        holder.planTitle.text = plan.title
        holder.planDescription.text = plan.description
        holder.planImage.setImageResource(plan.imageRes)


        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, PlanDetailsActivity::class.java)
            intent.putExtra("plan_id", plan.id)
            it.context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int = plans.size
}
