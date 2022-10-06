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

            banquitoTextView.text = "-Banquito  går ut på att få ett högre kortvärde än 'Banken'. \n\n-Spelaren som får högsta kortet innan första omgången blir 'Bank'.\n\n-Spelaren som är ensam om att få ett 'ess' under spelets gång, blir 'Bank'.\n\n-Hänsyn tas till turordning!\n \n-'Banken' vinner alltid vid lika kortvärde!"
            button.setOnClickListener {

                val intent = Intent( this, BanquitoGameActivity::class.java)
                startActivity(intent)
            }
        }
    }
}