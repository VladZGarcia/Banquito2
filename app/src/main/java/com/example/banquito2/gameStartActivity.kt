package com.example.banquito2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class GameStartActivity : AppCompatActivity() {

    lateinit var infoTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_start)

        infoTextView = findViewById(R.id.infoTextView)

        val name = intent.getStringExtra("name")

        infoTextView.text = "Banken har delat up korten i fem högar, $name vilken vill du ha? "

        val cardButton1 = findViewById<ImageView>(R.id.cardButton1)
        //val cardButton1.setImageResource(R.drawable.)
        val cardButton2 =findViewById<ImageView>(R.id.cardButton2)
        val cardButton3 =findViewById<ImageView>(R.id.cardButton3)
        val cardButton4 =findViewById<ImageView>(R.id.cardButton4)
        val cardButton5 =findViewById<ImageView>(R.id.cardButton5)







    }
}