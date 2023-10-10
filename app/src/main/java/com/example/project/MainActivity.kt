package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btn_signIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_signIn = findViewById(R.id.btn_signIn)
        btnToLogin()
    }

    private fun btnToLogin(){
        btn_signIn.setOnClickListener{
            startActivity(Intent(this, LogInActivity::class.java))
        }
    }
}