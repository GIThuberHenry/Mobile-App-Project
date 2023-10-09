package com.example.login_register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
    private lateinit var tv_login: TextView
    private lateinit var btn_register: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        tv_login = findViewById(R.id.tv_login)
        toLogin()

        btn_register = findViewById(R.id.btn_register)
        registerLogin()
    }

    private fun toLogin(){
        tv_login.setOnClickListener{
            startActivity(Intent(this, LogInActivity::class.java))
        }
    }

    private fun registerLogin(){
        btn_register.setOnClickListener{
            startActivity(Intent(this, LogInActivity::class.java))
        }
    }
}