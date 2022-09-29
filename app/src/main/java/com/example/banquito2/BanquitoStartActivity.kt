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
    var name : String? =""
    var firstRound = true
    var bet =0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_start)

            val cardButton1 = findViewById<ImageView>(R.id.cardButton1)
            val cardButton2 = findViewById<ImageView>(R.id.cardButton2)
            val cardButton3 = findViewById<ImageView>(R.id.cardButton3)
            val cardButton4 = findViewById<ImageView>(R.id.cardButton4)
            val cardButton5 = findViewById<ImageView>(R.id.cardButton5)
            val betEditText = findViewById<EditText>(R.id.betEditText)


             name = intent.getStringExtra("nameText")

            infoTextView = findViewById(R.id.infoTextView)

            infoTextView.text = "Korten har delats up i fem högar. Högsta kortet blir BANKEN! $name vilken väljer du? "

            player1 = Players("$name ", 100, false)

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



        if(firstRound){
            cardButton1.setOnClickListener {
                val animation1 = AnimationUtils.loadAnimation(this, R.anim.bounce)
                cardButton1.startAnimation(animation1)
                cardButton1.setImageResource(button1Card.image)
                valdPile = 0

                if(piles.size == 5) {
                    firstPlayerChoice()

                    cardButton2.callOnClick()
                    cardButton3.callOnClick()
                    cardButton4.callOnClick()
                    cardButton5.callOnClick()
                }
                firstRound = false
                //infoTextView.setOnClickListener {
                //    infoTextView.text = "Dags att spela om Banquitos!"
                //    cardButton1.setImageResource(R.drawable.peter_river)
                //    cardButton2.setImageResource(R.drawable.peter_river)
                //    cardButton3.setImageResource(R.drawable.peter_river)
                //    cardButton4.setImageResource(R.drawable.peter_river)
                //    cardButton5.setImageResource(R.drawable.peter_river)
//
                //}
            }

            cardButton2.setOnClickListener {
                val animation2 = AnimationUtils.loadAnimation(this, R.anim.bounce)
                cardButton2.startAnimation(animation2)
                cardButton2.setImageResource(button2Card.image)
                valdPile = 1

                if(piles.size == 5) {
                    firstPlayerChoice()

                    cardButton1.callOnClick()
                    cardButton3.callOnClick()
                    cardButton4.callOnClick()
                    cardButton5.callOnClick()
                }
                firstRound = false
               //infoTextView.setOnClickListener {
               //    infoTextView.text = "Dags att spela om Banquitos!"
               //    cardButton1.setImageResource(R.drawable.peter_river)
               //    cardButton2.setImageResource(R.drawable.peter_river)
               //    cardButton3.setImageResource(R.drawable.peter_river)
               //    cardButton4.setImageResource(R.drawable.peter_river)
               //    cardButton5.setImageResource(R.drawable.peter_river)

               //}
            }
            cardButton3.setOnClickListener {
                val animation3 =AnimationUtils.loadAnimation(this, R.anim.bounce)
                cardButton3.startAnimation(animation3)
                cardButton3.setImageResource(button3Card.image)
                valdPile = 2

                if(piles.size == 5) {
                    firstPlayerChoice()

                    cardButton1.callOnClick()
                    cardButton2.callOnClick()
                    cardButton4.callOnClick()
                    cardButton5.callOnClick()
                }
                firstRound = false
               // infoTextView.setOnClickListener {
               //     infoTextView.text = "Dags att spela om Banquitos!"
               //     cardButton1.setImageResource(R.drawable.peter_river)
               //     cardButton2.setImageResource(R.drawable.peter_river)
               //     cardButton3.setImageResource(R.drawable.peter_river)
               //     cardButton4.setImageResource(R.drawable.peter_river)
               //     cardButton5.setImageResource(R.drawable.peter_river)
//
               // }
            }
            cardButton4.setOnClickListener {
                val animation4 =AnimationUtils.loadAnimation(this, R.anim.bounce)
                cardButton4.startAnimation(animation4)
                cardButton4.setImageResource(button4Card.image)
                valdPile = 3

                if(piles.size == 5) {
                    firstPlayerChoice()

                    cardButton1.callOnClick()
                    cardButton3.callOnClick()
                    cardButton2.callOnClick()
                    cardButton5.callOnClick()
                }
                firstRound = false
                //infoTextView.setOnClickListener {
                //    infoTextView.text = "Dags att spela om Banquitos!"
                //    cardButton1.setImageResource(R.drawable.peter_river)
                //    cardButton2.setImageResource(R.drawable.peter_river)
                //    cardButton3.setImageResource(R.drawable.peter_river)
                //    cardButton4.setImageResource(R.drawable.peter_river)
                //    cardButton5.setImageResource(R.drawable.peter_river)
//
                //}
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
        // Betting time!!
        infoTextView.setOnClickListener {
            infoTextView.text = "Dags att spela om Banquitos!\n Hur mycket Banquitos vill du spela om?"
            cardButton1.setImageResource(R.drawable.peter_river)
            cardButton2.setImageResource(R.drawable.peter_river)
            cardButton3.setImageResource(R.drawable.peter_river)
            cardButton4.setImageResource(R.drawable.peter_river)
            cardButton5.setImageResource(R.drawable.peter_river)

        }


            while (bet != 0) {

                infoTextView.text = "Dags att spela!\n Hur mycket vill du spela om?"

                cardButton1.setImageResource(R.drawable.peter_river)
                cardButton2.setImageResource(R.drawable.peter_river)
                cardButton3.setImageResource(R.drawable.peter_river)
                cardButton4.setImageResource(R.drawable.peter_river)
                cardButton5.setImageResource(R.drawable.peter_river)
                betEditText.setOnEditorActionListener(TextView.OnEditorActionListener { v, id, event ->
                    if (id == EditorInfo.IME_ACTION_DONE) {
                        var betInput = betEditText.text.toString() ?: null
                        bet = betInput!!.toInt()
                        true
                    } else false
                })
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
                        cardButton1.callOnClick()
                        cardButton3.callOnClick()
                        cardButton4.callOnClick()
                        cardButton2.callOnClick()
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

                var newPile = removePile()
                 resultText =  "${infoTextView.text}\n${player.name} väljer korthög ${newPile.pile}"
                infoTextView.text = resultText
                player.cardValue = newPile.value

                if(highestVal.cardValue < player.cardValue) {
                    highestVal = player

                }
            }
        highestVal.bank = true

       //    resultText =  "${infoTextView.text}\n${player1.name} bank :${player1.bank}"
       //    infoTextView.text = resultText

       //for( player in playerList.players){
       //    resultText =  "${infoTextView.text}\n${player.name} bank :${player.bank}"
       //    infoTextView.text = resultText
       //}

        resultText =  "${infoTextView.text}\n${highestVal.name} har högsta kort och är Banken\n Tryck på skärmen!"
        infoTextView.text = resultText

        return


    }
}