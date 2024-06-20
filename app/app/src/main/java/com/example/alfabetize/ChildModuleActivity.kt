package com.example.alfabetize

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alfabetize.adapters.ChildModuleAdapter
import com.example.alfabetize.adapters.ModulesAdapter
import com.example.alfabetize.models.Activity
import com.example.alfabetize.viewmodel.ModuleViewModel
import com.example.alfabetize.viewmodel.UserActivityViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ChildModuleActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ChildModuleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_child_module)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val gson = Gson()
        val activitiesJson = intent.getStringExtra("activities")
        val activitiesType = object : TypeToken<List<Activity>>() {}.type
        val activities: List<Activity> = gson.fromJson(activitiesJson, activitiesType)
        recyclerView = findViewById(R.id.rv_child)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ChildModuleAdapter(activities)
        recyclerView.adapter = adapter
    }
}