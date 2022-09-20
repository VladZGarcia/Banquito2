package com.example.banquito2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class banquitoGame : AppCompatActivity() {

    lateinit var playerTextView : TextView
    lateinit var writeNameTextView : TextView
    lateinit var nameView : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banquito_game)

        playerTextView = findViewById(R.id.playerTextView)
        writeNameTextView = findViewById(R.id.writeNameTextView)
        nameView = findViewById(R.id.nameView)

        playerTextView.text = "Fem spelare är med och spelar med 100 'banquitos' som insats"
        writeNameTextView.text = "Skriv in ditt namn!"

        val nameText = nameView.text.toString()
        //val name =nameText.toIntOrNull()
        val button =findViewById<Button>(R.id.nextButton)

        button.setOnClickListener {

            val intent = Intent( this, gameStartActivity::class.java)
            intent.putExtra("nameText", nameText)

            startActivity(intent)

        }


    }
}