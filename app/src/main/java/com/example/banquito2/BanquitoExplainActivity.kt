package com.example.banquito2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class BanquitoExplainActivity : AppCompatActivity() {

    lateinit var banquitoXTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banquito_explain)

        banquitoXTextView = findViewById(R.id.banquitoXTextView)
        val button =findViewById<Button>(R.id.Button)

        button.setOnClickListener {



        }
    }
}