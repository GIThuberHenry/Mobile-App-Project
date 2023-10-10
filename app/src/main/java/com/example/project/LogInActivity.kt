package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LogInActivity : AppCompatActivity() {
    private lateinit var tv_register: TextView
    private lateinit var btn_login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        tv_register = findViewById(R.id.tv_register)
        toRegister()

        btn_login = findViewById(R.id.btn_login)
        toWorkoutAcativity()

    }

    private fun toRegister(){
        tv_register.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun toWorkoutAcativity(){
        btn_login.setOnClickListener{
            startActivity(Intent(this, WorkoutActivity::class.java))
        }
    }
}