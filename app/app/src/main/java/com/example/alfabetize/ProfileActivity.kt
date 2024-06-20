package com.example.alfabetize

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alfabetize.models.User
import com.google.gson.Gson

class ProfileActivity : AppCompatActivity() {
    private lateinit var currentUser: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        currentUser = MyApp.getInstance().currentUser ?: run {
            finish()
            return
        }

        val txtUsername = findViewById<TextView>(R.id.txtUsername)
        val txtScore = findViewById<TextView>(R.id.txtScore)
        val txtSequence = findViewById<TextView>(R.id.txtSequence)
        txtUsername.text = currentUser.name
        txtScore.text = currentUser.score.toString()
        txtSequence.text = currentUser.sequence.toString()

        findViewById<TextView>(R.id.btnLogout).setOnClickListener {
            MyApp.getInstance().currentUser = null
            val intent = Intent(this, MainActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(this)
            startActivity(intent, options.toBundle())
            finish()
        }
    }

    override fun onResume() {
        currentUser = MyApp.getInstance().currentUser ?: run {
            finish()
            return
        }

        val textViewScore = findViewById<TextView>(R.id.txtScore)
        textViewScore.text = currentUser.score.toString()

        super.onResume()
    }
}