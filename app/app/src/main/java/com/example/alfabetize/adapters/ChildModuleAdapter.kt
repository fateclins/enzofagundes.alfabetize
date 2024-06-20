package com.example.alfabetize.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alfabetize.LessonActivity
import com.example.alfabetize.models.Activity
import com.example.alfabetize.R
import com.google.gson.Gson

class ChildModuleAdapter(private var activities: List<Activity>) : RecyclerView.Adapter<ChildModuleAdapter.ChildModuleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildModuleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_child_module, parent, false)
        return ChildModuleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChildModuleViewHolder, position: Int) {
        val activity = activities[position]
        holder.bind(activity)
    }

    override fun getItemCount(): Int {
        return activities.size
    }

    fun updateActivities(newActivities: List<Activity>) {
        activities = newActivities
        notifyDataSetChanged()
    }

    inner class ChildModuleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val activityTitle: TextView = itemView.findViewById(R.id.tv_module_title)
        private val activityButton: Button = itemView.findViewById(R.id.btn_module)
        fun bind(activity: Activity) {
            activityTitle.text = activity.title
            activityButton.setOnClickListener {
                val intent = Intent(itemView.context, LessonActivity::class.java)
                val gson = Gson()
                val activityJson = gson.toJson(activity)
                intent.putExtra("activity", activityJson)
                itemView.context.startActivity(intent)
            }
        }
    }
}