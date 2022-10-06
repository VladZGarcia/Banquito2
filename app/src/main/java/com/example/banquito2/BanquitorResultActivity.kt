package com.example.banquito2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class BanquitorResultActivity : AppCompatActivity() {

    lateinit var infoTextView: TextView
    var player1 = Players("", 100, false, 0)
    val playerList = PlayerList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banquito_result)

        infoTextView = findViewById(R.id.banquitoXTextView)
        val button = findViewById<Button>(R.id.Button)

        player1.name = intent.getStringExtra("nameP1")
        player1.money = intent.getIntExtra("moneyP1", 0)
        player1.bank = intent.getBooleanExtra("${player1.name} bank", false)
        for(player in playerList.players){
            player.name = intent.getStringExtra("${player.name}")
            player.money = intent.getIntExtra("${player.name} money", 0)
            player.bank = intent.getBooleanExtra("${player.name} bank", false)
        }

        var resultText ="${infoTextView.text}\n\n${player1.name} har ${player1.money} banquitos kvar.\n"
        infoTextView.text = resultText

        for (player in playerList.players) {
            resultText ="\n${infoTextView.text}\n${player.name} har ${player.money} banquitos kvar.\n"
            infoTextView.text = resultText
            if(player.money == 0){


            }

        }


        button.setOnClickListener {
            for (player in playerList.players) {

                if(player.money <= 0  ){
                    resultText ="\n${player.name} har ${player.money} banquitos och är ute ur spelet.\n"
                    infoTextView.text = resultText
                    playerList.players.remove(player)


                }

            }
            val intent = Intent(this, BanquitoStartActivity::class.java)

            intent.putExtra("nameText", player1.name)
            intent.putExtra("moneyP1", player1.money)
            if(player1.bank) {
                intent.putExtra("${player1.name} bank", player1.bank)
            }
            for (player in playerList.players) {
                intent.putExtra("${player.name}", player.name)
                intent.putExtra("${player.name} money", player.money)
                if(player.bank){
                    intent.putExtra("${player.name} bank", player.bank)
                }
            }
            intent.putExtra("firstRound", false)

            startActivity(intent)
            finish()
        }
    }
}