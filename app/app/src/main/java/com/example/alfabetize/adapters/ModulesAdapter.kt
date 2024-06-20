package com.example.alfabetize.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alfabetize.ChildModuleActivity
import com.example.alfabetize.R
import com.example.alfabetize.models.Module
import com.google.gson.Gson

class ModulesAdapter(private var modules: List<Module>) : RecyclerView.Adapter<ModulesAdapter.ModuleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_module, parent, false)
        return ModuleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        val module = modules[position]
        holder.bind(module)
    }

    override fun getItemCount(): Int {
        return modules.size
    }

    fun updateModules(newModules: List<Module>) {
        modules = newModules
        notifyDataSetChanged()
    }

    inner class ModuleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val moduleTitle: TextView = itemView.findViewById(R.id.tv_module_title)
        private val moduleButton: Button = itemView.findViewById(R.id.access_module)

        fun bind(module: Module) {
            moduleTitle.text = module.title
            moduleButton.setOnClickListener {
                val intent = Intent(itemView.context, ChildModuleActivity::class.java)
                val gson = Gson()
                val activitiesJson = gson.toJson(module.activities)
                intent.putExtra("activities", activitiesJson)
                itemView.context.startActivity(intent)
            }
        }
    }
}
