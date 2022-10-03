package com.example.banquito2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class BanquitorResultActivity : AppCompatActivity() {

    lateinit var infoTextView: TextView
    var player1 = Players("", 100, false, 0)
    val playerList = PlayerList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banquito_explain)

        infoTextView = findViewById(R.id.banquitoXTextView)
        val button = findViewById<Button>(R.id.Button)
        player1.name = intent.getStringExtra("nameP1")
        player1.money = intent.getIntExtra("moneyP1", 0)
        for(player in playerList.players){
            player.name = intent.getStringExtra("${player.name}")
            player.money = intent.getIntExtra("${player.name} money", 0)


        }

        var resultText ="${infoTextView.text}\n\n${player1.name} har ${player1.money} banquitos att spela för. "
        infoTextView.text = resultText

        for (player in playerList.players) {
            resultText ="${infoTextView.text}\n${player.name} har ${player.money} banquitos att spela för. "
            infoTextView.text = resultText

        }
        resultText = "${infoTextView.text}\nTryck på knappen. "
        infoTextView.text = resultText
        button.setOnClickListener {

            finish()
        }
    }
}