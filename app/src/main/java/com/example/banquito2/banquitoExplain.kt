package com.example.banquito2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class banquitoExplain : AppCompatActivity() {

    lateinit var banquitoXTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banquito_explain)

        banquitoXTextView = findViewById(R.id.banquitoXTextView)
        val button =findViewById<Button>(R.id.Button)

        banquitoXTextView.text = "Banquito är ett chansspel som går ut på att få ett högre kortvärde än 'banken' och på det sättet dubla sin insats. 'Banken' blir den spelaren som får högsta kortet innan första omgången, får en spelare ett 'ess' under spelets gång blir han 'banken' om inte 'banken' också har ett 'ess'. Banken vinner alltid vid lika kortvärde."





        button.setOnClickListener {

            val intent = Intent( this, banquitoGame::class.java)
            startActivity(intent)

        }



    }
}