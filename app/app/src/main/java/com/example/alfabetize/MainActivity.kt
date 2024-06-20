package com.example.alfabetize

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import com.example.alfabetize.viewmodel.ModuleViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val buttonLogin = findViewById<Button>(R.id.login)
        val buttonCadastro = findViewById<Button>(R.id.create_account)
        val options = ActivityOptions.makeSceneTransitionAnimation(this)
        buttonLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent, options.toBundle())
        }


        buttonCadastro.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent, options.toBundle())
        }
    }
}