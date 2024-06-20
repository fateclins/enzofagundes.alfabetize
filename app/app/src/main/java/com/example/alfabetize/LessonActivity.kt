package com.example.alfabetize

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.alfabetize.models.Activity
import com.example.alfabetize.models.User
import com.example.alfabetize.models.UserActivity
import com.example.alfabetize.viewmodel.UserActivityViewModel
import com.google.android.material.textfield.TextInputLayout
import com.google.gson.Gson

class LessonActivity : AppCompatActivity() {
    private lateinit var timerProgressBar: ProgressBar
    private lateinit var activityContent: TextView
    private lateinit var answerField: TextInputLayout
    private lateinit var answerButton: Button
    private lateinit var countDownTimer: CountDownTimer
    private lateinit var userActivityViewModel: UserActivityViewModel
    private lateinit var currentUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lesson)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        currentUser = MyApp.getInstance().currentUser ?: run {
            finish()
            return
        }

        val gson = Gson()
        val activityJson = intent.getStringExtra("activity")

        timerProgressBar = findViewById(R.id.timer_progress_bar)
        activityContent = findViewById(R.id.activity_content)
        answerField = findViewById(R.id.answerField)
        answerButton = findViewById(R.id.answer)

        val activity: Activity = gson.fromJson(activityJson, Activity::class.java)
        activityContent.text = activity.content

        countDownTimer = object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                timerProgressBar.progress = secondsRemaining.toInt()
            }

            override fun onFinish() {
                timerProgressBar.progress = 0
                currentUser.id?.let { postUserActivity(it, activity.id, false, "", false) }
                showAlertDialog("Tempo esgotado", "Você não concluiu a atividade a tempo!") {}
            }
        }

        countDownTimer.start()

        userActivityViewModel = ViewModelProvider(this)[UserActivityViewModel::class.java]

        answerButton.setOnClickListener {
            val userAnswer = answerField.editText?.text.toString()
            val isCorrect = userAnswer == activity.correct_answer
            currentUser.id?.let { it1 -> postUserActivity(activityId = activity.id, isCorrect = isCorrect, answer = userAnswer, isCompleted = true, userId = it1) }

            if (userAnswer == activity.correct_answer) {
                showAlertDialog("Resposta", "Resposta correta!") {
                    currentUser.score = currentUser.score?.plus(activity.points)
                    currentUser.sequence = currentUser.sequence?.plus(1)
                    MyApp.getInstance().currentUser = currentUser
                    countDownTimer.cancel()
                }
            } else {
                showAlertDialog("Resposta", "Resposta incorreta!") {
                    countDownTimer.cancel()
                }
            }
        }
    }

    private fun postUserActivity(userId: Int, activityId: Int, isCorrect: Boolean, answer: String, isCompleted: Boolean) {
        val userActivity = UserActivity(
            user_id = userId,
            activity_id = activityId,
            is_correct = isCorrect,
            answer = answer,
            is_completed = isCompleted,
        )

        userActivityViewModel.postUserActivity(userActivity)
    }

    private fun showAlertDialog(title: String, message: String, onOkAction: () -> Unit) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_custom, null)

        val dialogTitle = dialogView.findViewById<TextView>(R.id.dialog_title)
        val dialogMessage = dialogView.findViewById<TextView>(R.id.dialog_message)
        val dialogButton = dialogView.findViewById<Button>(R.id.dialog_button)

        dialogTitle.text = title
        dialogMessage.text = message

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        dialogButton.setOnClickListener {
            dialog.dismiss()
            onOkAction.invoke()
            finish()
        }

        dialog.show()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_custom, null)

        val dialogTitle = dialogView.findViewById<TextView>(R.id.dialog_title)
        val dialogMessage = dialogView.findViewById<TextView>(R.id.dialog_message)
        val dialogButton = dialogView.findViewById<Button>(R.id.dialog_button)

        dialogTitle.text = title
        dialogMessage.text = "Tem certeza que deseja sair da lição?"

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        dialogButton.setOnClickListener {
            dialog.dismiss()
            countDownTimer.cancel() // Certifique-se de cancelar o timer
            super.onBackPressed() // Finaliza a activity
            finish()
        }

        dialog.show()
    }
}
