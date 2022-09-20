package com.example.banquito2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class gameStartActivity : AppCompatActivity() {

    lateinit var infoTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_start)

        infoTextView = findViewById(R.id.infoTextView)

        val name = intent.getStringExtra("name")

        infoTextView.text = "Banken har delat up korten i fem högar, vilken vill du ha? "

        val cardButton1 =findViewById<Button>(R.id.cardButton1)
        val cardButton2 =findViewById<Button>(R.id.cardButton2)
        val cardButton3 =findViewById<Button>(R.id.cardButton3)
        val cardButton4 =findViewById<Button>(R.id.cardButton4)
        val cardButton5 =findViewById<Button>(R.id.cardButton5)







    }
}