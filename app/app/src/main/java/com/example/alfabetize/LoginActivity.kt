package com.example.alfabetize

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.alfabetize.models.User
import com.example.alfabetize.viewmodel.LoginViewModel
import com.google.android.material.textfield.TextInputLayout
import com.google.gson.Gson

class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        val emailTextInputLayout = findViewById<TextInputLayout>(R.id.emailField)
        val passwordTextInputLayout = findViewById<TextInputLayout>(R.id.passwordField)

        val emailEditText = emailTextInputLayout.editText
        val passwordEditText = passwordTextInputLayout.editText

        val buttonLogin = findViewById<Button>(R.id.login)
        buttonLogin.setOnClickListener {
            val emailString = emailEditText?.text?.toString()
            val passwordString = passwordEditText?.text?.toString()

            if (emailString.isNullOrEmpty() || passwordString.isNullOrEmpty()) {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val userTyped = User(
                id = null,
                name = null,
                email = emailString,
                password = passwordString,
                email_verified_at = null,
                score = null,
                sequence = null
            )

            loginViewModel.login(userTyped)
        }

        loginViewModel.user.observe(this) { user ->
            if (user != null) {
                val intent = Intent(this, ModuleActivity::class.java)
                val jsonUser = Gson().toJson(user)
                MyApp.getInstance().setUserFromJson(userJson = jsonUser)
                val options = ActivityOptions.makeSceneTransitionAnimation(this)
                startActivity(intent, options.toBundle())
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        if (MyApp.getInstance().currentUser != null) {
            val intent = Intent(this, ModuleActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(this)
            startActivity(intent, options.toBundle())
        }

        super.onResume()
    }
}
