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

            banquitoTextView.text = "Banquito är ett chansspel som går ut på att få ett högre kortvärde än 'banken' och på det sättet dubla sin insats. 'Banken' blir den spelaren som får högsta kortet innan första omgången, får en spelare ett 'ess' under spelets gång blir den spelaren 'banken' om inte 'banken' också har ett 'ess'. Banken vinner alltid vid lika kortvärde."
            button.setOnClickListener {

                val intent = Intent( this, banquitoGame::class.java)
                startActivity(intent)

            }


        }



    }
}