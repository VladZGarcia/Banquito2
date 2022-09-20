package com.example.banquito2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var banquitoTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        banquitoTextView = findViewById(R.id.banquitoTextView)
        val button =findViewById<Button>(R.id.startButton)

        button.setOnClickListener {

            val intent = Intent( this, banquitoExplain::class.java)
            startActivity(intent)

        }



    }
}