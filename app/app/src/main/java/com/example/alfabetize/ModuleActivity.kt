package com.example.alfabetize

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alfabetize.adapters.ModulesAdapter
import com.example.alfabetize.models.User
import com.example.alfabetize.viewmodel.ModuleViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson

class ModuleActivity : AppCompatActivity() {
    private lateinit var viewModel: ModuleViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ModulesAdapter
    private lateinit var currentUser: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_module)

        currentUser = (MyApp.getInstance().currentUser ?: run {
            finish()
            return
        })

        Toast.makeText(this, "Welcome ${currentUser.name}", Toast.LENGTH_SHORT).show()

        val textViewScore = findViewById<TextView>(R.id.userScore)
        textViewScore.text = currentUser.score.toString()

        val profileButtonImage: ImageButton = findViewById(R.id.afiImage)
        profileButtonImage.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(this)
            startActivity(intent, options.toBundle())
        }

        recyclerView = findViewById(R.id.rv_modules)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        viewModel = ViewModelProvider(this)[ModuleViewModel::class.java]

        adapter = ModulesAdapter(emptyList())
        recyclerView.adapter = adapter

        viewModel.modules.observe(this) { modules ->
            if (modules != null) {
                adapter.updateModules(modules)
            } else {
                adapter.updateModules(emptyList())
            }
        }

        viewModel.fetchModules()
    }

    override fun onResume() {
        currentUser = MyApp.getInstance().currentUser ?: run {
            finish()
            return
        }

        val textViewScore = findViewById<TextView>(R.id.userScore)
        textViewScore.text = currentUser.score.toString()

        super.onResume()
    }
}