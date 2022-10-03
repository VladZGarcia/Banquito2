package com.example.banquito2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class BanquitoStartActivity : AppCompatActivity() {

    lateinit var infoTextView : TextView
    lateinit var betView : EditText
    val deck = CardList()
    val playerList = PlayerList()
    var player1 = Players("",100,false,  0)
    val piles = mutableListOf<Cards>()
    var valdPile = 0
    var name : String? = "player1"
    var firstRound = true
    var bet =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_start)

        var cardButton1 = findViewById<ImageView>(R.id.cardButton1)
        var cardButton2 = findViewById<ImageView>(R.id.cardButton2)
        var cardButton3 = findViewById<ImageView>(R.id.cardButton3)
        var cardButton4 = findViewById<ImageView>(R.id.cardButton4)
        var cardButton5 = findViewById<ImageView>(R.id.cardButton5)
        betView = findViewById(R.id.betEditText)

        betView.setEnabled(false)


        name = intent.getStringExtra("nameText")

        infoTextView = findViewById(R.id.infoTextView)
        var resultText = "Korten har delats up i fem högar. Högsta kortet blir BANKEN!  "
        infoTextView.text = "$resultText\n \n$name vilken väljer du?"

        player1 = Players("$name ", 100, false)





        if (firstRound) {
            var button1Card = deck.newRndCard()
            button1Card.pile = 1
            piles.add(button1Card)
            var button2Card = deck.newRndCard()
            button2Card.pile = 2
            piles.add(button2Card)
            var button3Card = deck.newRndCard()
            button3Card.pile = 3
            piles.add(button3Card)
            var button4Card = deck.newRndCard()
            button4Card.pile = 4
            piles.add(button4Card)
            var button5Card = deck.newRndCard()
            button5Card.pile = 5
            piles.add(button5Card)
            cardButton1.setOnClickListener {
                val animation1 = AnimationUtils.loadAnimation(this, R.anim.bounce)
                cardButton1.startAnimation(animation1)
                cardButton1.setImageResource(button1Card.image)
                valdPile = 0

                if (piles.size == 5) {
                    firstPlayerChoice()

                    cardButton2.callOnClick()
                    cardButton3.callOnClick()
                    cardButton4.callOnClick()
                    cardButton5.callOnClick()
                }
                firstRound = false
            }

            cardButton2.setOnClickListener {
                val animation2 = AnimationUtils.loadAnimation(this, R.anim.bounce)
                cardButton2.startAnimation(animation2)
                cardButton2.setImageResource(button2Card.image)
                valdPile = 1

                if (piles.size == 5) {
                    firstPlayerChoice()

                    cardButton1.callOnClick()
                    cardButton3.callOnClick()
                    cardButton4.callOnClick()
                    cardButton5.callOnClick()
                }
                firstRound = false
            }
            cardButton3.setOnClickListener {
                val animation3 = AnimationUtils.loadAnimation(this, R.anim.bounce)
                cardButton3.startAnimation(animation3)
                cardButton3.setImageResource(button3Card.image)
                valdPile = 2

                if (piles.size == 5) {
                    firstPlayerChoice()

                    cardButton1.callOnClick()
                    cardButton2.callOnClick()
                    cardButton4.callOnClick()
                    cardButton5.callOnClick()
                }
                firstRound = false
            }
            cardButton4.setOnClickListener {
                val animation4 = AnimationUtils.loadAnimation(this, R.anim.bounce)
                cardButton4.startAnimation(animation4)
                cardButton4.setImageResource(button4Card.image)
                valdPile = 3

                if (piles.size == 5) {
                    firstPlayerChoice()

                    cardButton1.callOnClick()
                    cardButton3.callOnClick()
                    cardButton2.callOnClick()
                    cardButton5.callOnClick()
                }
                firstRound = false
            }
            cardButton5.setOnClickListener {
                val animation5 = AnimationUtils.loadAnimation(this, R.anim.bounce)
                cardButton5.startAnimation(animation5)
                cardButton5.setImageResource(button5Card.image)
                valdPile = 4

                if (piles.size == 5) {
                    firstPlayerChoice()

                    cardButton1.callOnClick()
                    cardButton3.callOnClick()
                    cardButton4.callOnClick()
                    cardButton2.callOnClick()
                }
                firstRound = false
            }

        }
        //disable button push
        //
        //if(!firstRound){
        //    cardButton1.setEnabled(false)
        //    cardButton2.setEnabled(false)
        //    cardButton3.setEnabled(false)
        //    cardButton4.setEnabled(false)
        //    cardButton5.setEnabled(false)
        //} //funka ej

        // Betting time!!


        infoTextView.setOnClickListener {
            if (!firstRound) {
                cardButton1.setEnabled(false)
                cardButton2.setEnabled(false)
                cardButton3.setEnabled(false)
                cardButton4.setEnabled(false)
                cardButton5.setEnabled(false)
                cardButton1.setImageResource(R.drawable.peter_river)
                cardButton2.setImageResource(R.drawable.peter_river)
                cardButton3.setImageResource(R.drawable.peter_river)
                cardButton4.setImageResource(R.drawable.peter_river)
                cardButton5.setImageResource(R.drawable.peter_river)

                resultText = "Dags att spela om Banquitos!\n "

            }

            if (!player1.bank) {

                infoTextView.text = "$resultText \n Hur mycket vill du spela om?"
                betView.setEnabled(true)
                betView.setOnEditorActionListener(TextView.OnEditorActionListener { v, id, event ->

                    if (id == EditorInfo.IME_ACTION_DONE) {
                        var betInput = betView.text.toString() ?: null
                        bet = betInput!!.toInt()
                        player1.banquitoBet = bet

                        infoTextView.text = "${player1.name} betar ${player1.banquitoBet} Banquitos"
                        for (player in playerList.players) {
                            if (!player.bank) {
                                var playerbet = (1..5).random()
                                player.banquitoBet = playerbet
                                resultText =
                                    "${infoTextView.text}\n ${player.name} betar ${player.banquitoBet} Banquitos"
                                infoTextView.text = resultText
                            }
                        }

                        infoTextView.text = "${infoTextView.text}\n Nya kort!"
                        infoTextView.text =
                            "${infoTextView.text}\n\nTryck på skärmen för att Starta!"

                        betView.setEnabled(false)

                        true
                    } else false
                })

            } else if(player1.bank) {
                infoTextView.setOnClickListener {

                    for (player in playerList.players) {

                            var playerbet = (1..5).random()
                            player.banquitoBet = playerbet
                            resultText =
                                "${infoTextView.text}\n ${player.name} betar ${player.banquitoBet} Banquitos"
                            infoTextView.text = resultText

                    }

                    infoTextView.text = "${infoTextView.text}\n\nTryck på skärmen för att Starta!"

                }
            }

            infoTextView.setOnClickListener {
                cardButton1.setEnabled(true)
                cardButton2.setEnabled(true)
                cardButton3.setEnabled(true)
                cardButton4.setEnabled(true)
                cardButton5.setEnabled(true)
                if (!player1.bank) {
                    for (player in playerList.players) {
                        if (player.bank) {
                            infoTextView.text =
                                "Korten har delats up i fem högar. ${player.name} är BANKEN! $name vilken väljer du? "
                        }
                    }
                } else {
                    infoTextView.text =
                        "Korten har delats up i fem högar. ${player1.name} är BANKEN! $name vilken väljer du? "
                }
            }
            if(!firstRound){

                deck.createDeck()
                var button1Card = deck.newRndCard()
                button1Card.pile = 1
                piles.add(button1Card)
                var button2Card = deck.newRndCard()
                button2Card.pile = 2
                piles.add(button2Card)
                var button3Card = deck.newRndCard()
                button3Card.pile = 3
                piles.add(button3Card)
                var button4Card = deck.newRndCard()
                button4Card.pile = 4
                piles.add(button4Card)
                var button5Card = deck.newRndCard()
                button5Card.pile = 5
                piles.add(button5Card)
                // HÄR BÖRJAR PROBLEMEN!

                cardButton1.setOnClickListener {
                    val animation1 = AnimationUtils.loadAnimation(this, R.anim.bounce)
                    cardButton1.startAnimation(animation1)
                    cardButton1.setImageResource(button1Card.image)
                    valdPile = 0

                    if (piles.size == 5) {
                        bankGame()
                        cardButton2.callOnClick()
                        cardButton3.callOnClick()
                        cardButton4.callOnClick()
                        cardButton5.callOnClick()
                    }
                }

                cardButton2.setOnClickListener {
                    val animation2 = AnimationUtils.loadAnimation(this, R.anim.bounce)
                    cardButton2.startAnimation(animation2)
                    cardButton2.setImageResource(button2Card.image)
                    valdPile = 1

                    if (piles.size == 5) {
                        bankGame()
                        cardButton1.callOnClick()
                        cardButton3.callOnClick()
                        cardButton4.callOnClick()
                        cardButton5.callOnClick()
                    }
                }
                cardButton3.setOnClickListener {
                    val animation3 = AnimationUtils.loadAnimation(this, R.anim.bounce)
                    cardButton3.startAnimation(animation3)
                    cardButton3.setImageResource(button3Card.image)
                    valdPile = 2

                    if (piles.size == 5) {
                        bankGame()
                        cardButton1.callOnClick()
                        cardButton2.callOnClick()
                        cardButton4.callOnClick()
                        cardButton5.callOnClick()
                    }
                }
                cardButton4.setOnClickListener {
                    val animation4 = AnimationUtils.loadAnimation(this, R.anim.bounce)
                    cardButton4.startAnimation(animation4)
                    cardButton4.setImageResource(button4Card.image)
                    valdPile = 3

                    if (piles.size == 5) {
                        bankGame()
                        cardButton1.callOnClick()
                        cardButton3.callOnClick()
                        cardButton2.callOnClick()
                        cardButton5.callOnClick()
                    }
                }
                cardButton5.setOnClickListener {
                    val animation5 = AnimationUtils.loadAnimation(this, R.anim.bounce)
                    cardButton5.startAnimation(animation5)
                    cardButton5.setImageResource(button5Card.image)
                    valdPile = 4

                    if (piles.size == 5) {
                        bankGame()
                        cardButton1.callOnClick()
                        cardButton3.callOnClick()
                        cardButton4.callOnClick()
                        cardButton2.callOnClick()
                    }
                }
            }
        }
    }

    fun removePile() : Cards {

       val rndPile = (0 until piles.size).random()
       val newPile = piles.removeAt(rndPile)

       return newPile
   }

    fun firstPlayerChoice() {
        var resultText = ""
        var firstChoice = piles[valdPile]
        piles.removeAt(valdPile)
        player1.cardValue = firstChoice.value
        var highestVal = player1
        valdPile += 1
        infoTextView.text = "$name du valde Korthög $valdPile"

            for (player in playerList.players) {
                var rndPlayer = playerList.RndPlayer()
                var newPile = removePile()
                 resultText =  "${infoTextView.text}\n${rndPlayer.name} väljer korthög ${newPile.pile}"
                infoTextView.text = resultText
                rndPlayer.cardValue = newPile.value

                if(highestVal.cardValue < rndPlayer.cardValue) {
                    highestVal = rndPlayer

                }
            }
        //for(player in playerList.players) {
        //}
        highestVal.bank = true
//bank kontroll
       //    resultText =  "${infoTextView.text}\n${player1.name} bank :${player1.bank}"
       //    infoTextView.text = resultText
//
       //for( player in playerList.players){
       //    resultText =  "${infoTextView.text}\n${player.name} bank :${player.bank}"
       //    infoTextView.text = resultText
       //}

        resultText =  "${infoTextView.text}\n${highestVal.name} har högsta kort och är Banken\n Tryck på skärmen!"
        infoTextView.text = resultText




    }

    fun bankGame() {
        var resultText = ""
        infoTextView.text =""
        var pileChoice = piles[valdPile]
        piles.removeAt(valdPile)
        player1.cardValue = pileChoice.value
        valdPile += 1
        infoTextView.text = "$name du valde Korthög $valdPile"

        for (player in playerList.players) {
            var rndPlayer = playerList.RndPlayer()
            var newPile = removePile()
            resultText = "${infoTextView.text}\n${rndPlayer.name} väljer korthög ${newPile.pile}"
            infoTextView.text = resultText
            rndPlayer.cardValue = newPile.value
        }

        resultText = "${infoTextView.text}\n Tryck på skärmen!"
        infoTextView.text = resultText

        infoTextView.setOnClickListener {
            if(player1.bank) {
                for(player in playerList.players){

                    if (player1.cardValue >= player.cardValue) {

                        player.money -= player.banquitoBet
                        player1.money += player.banquitoBet
                        resultText =
                            "${infoTextView.text}\n${player1.name} vinner ${player.banquitoBet} banquitos av ${player.name}. "
                        infoTextView.text = resultText

                    } else {
                        player.money += player.banquitoBet
                        player1.money -= player.banquitoBet
                        resultText =
                            "${infoTextView.text}\n${player1.name} forlorar ${player.banquitoBet} banquitos till ${player.name}. "
                        infoTextView.text = resultText
                    }
                }
            }
            resultText = "${infoTextView.text}\n Tryck på skärmen!"
            infoTextView.text = resultText
            for(player in playerList.players){
                if(player.bank){
                    //cardValue controll mot spelare 1
                    if(player.cardValue >= player1.cardValue) {
                        player1.money -= player1.banquitoBet
                        player.money += player1.banquitoBet
                        infoTextView.text = "${player.name} vinner ${player1.banquitoBet} banquitos av ${player1.name}. "


                    }else {
                        player1.money += player1.banquitoBet
                        player.money -= player1.banquitoBet
                        infoTextView.text = "${player.name} forlorar ${player1.banquitoBet} banquitos till ${player1.name}. "
                    }
                    //cardValue controll mot bottarna
                    for(player2 in playerList.players){
                        if(!player2.bank) {

                            if (player.cardValue >= player2.cardValue) {

                                player2.money -= player2.banquitoBet
                                player.money += player2.banquitoBet
                                resultText =
                                    "${infoTextView.text}\n${player.name} vinner ${player2.banquitoBet} banquitos av ${player2.name}. "
                                infoTextView.text = resultText

                            } else {
                                player2.money += player2.banquitoBet
                                player.money -= player2.banquitoBet
                                resultText =
                                    "${infoTextView.text}\n${player.name} forlorar ${player2.banquitoBet} banquitos till ${player2.name}. "
                                infoTextView.text = resultText
                            }
                        }

                    }
                }
            }
        }

        }
    }
