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

class gameStartActivity : AppCompatActivity() {

    lateinit var infoTextView : TextView
    lateinit var betView : EditText
    val deck = mutableListOf<Cards>()
    val players = mutableListOf<Players>()
    var player1 = Players("",100,false,  0)
    val piles = mutableListOf<Cards>()
    var valdPile = 0
    var name : String? =""
    var firstRound = true


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


        createPlayers()
        createDeck()
        deck.shuffle()
        players.shuffle()
        var button1Card = deck[1]
        button1Card.pile = 1
        piles.add(button1Card)
        var button2Card = deck[2]
        button2Card.pile = 2
        piles.add(button2Card)
        var button3Card = deck[3]
        button3Card.pile = 3
        piles.add(button3Card)
        var button4Card = deck[4]
        button4Card.pile = 4
        piles.add(button4Card)
        var button5Card = deck[5]
        button5Card.pile = 5
        piles.add(button5Card)

        //createpile()


        //  assignCardsToButtons()
        cardButton1.setOnClickListener {

            val animation1 = AnimationUtils.loadAnimation(this, R.anim.bounce)
            cardButton1.startAnimation(animation1)
            cardButton1.setImageResource(button1Card.image)
            valdPile = 0
            if(firstRound){
                player1.bank = true
                firstRound = false
            }
            if(piles.size == 5) {
                nextPlayerChoice()

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
            if(firstRound){
                player1.bank = true
                firstRound = false
            }

            if(piles.size == 5) {
                nextPlayerChoice()

                 cardButton1.callOnClick()
                 cardButton3.callOnClick()
                 cardButton4.callOnClick()
                 cardButton5.callOnClick()
            }

        }
        cardButton3.setOnClickListener {

            val animation3 =AnimationUtils.loadAnimation(this, R.anim.bounce)
            cardButton3.startAnimation(animation3)
            cardButton3.setImageResource(button3Card.image)
            valdPile = 2
            if(firstRound){
                player1.bank = true
                firstRound = false
            }

            if(piles.size == 5) {
                nextPlayerChoice()

                cardButton1.callOnClick()
                cardButton2.callOnClick()
                cardButton4.callOnClick()
                cardButton5.callOnClick()
            }
        }
        cardButton4.setOnClickListener {

            val animation4 =AnimationUtils.loadAnimation(this, R.anim.bounce)
            cardButton4.startAnimation(animation4)
            cardButton4.setImageResource(button4Card.image)
            valdPile = 3
            if(firstRound){
                player1.bank = true
                firstRound = false
            }

            if(piles.size == 5) {
                nextPlayerChoice()

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
            if(firstRound){
                player1.bank = true
                firstRound = false
            }

            if (piles.size == 5) {
                nextPlayerChoice()

            cardButton1.callOnClick()
            cardButton3.callOnClick()
            cardButton4.callOnClick()
            cardButton2.callOnClick()
        }
        }
        betEditText.setOnEditorActionListener(TextView.OnEditorActionListener { v, id, event ->
            if (id == EditorInfo.IME_ACTION_DONE) {
                var betInput = betEditText.text.toString() ?: null
                    var bet = betInput!!.toInt() 
                //val intent = Intent(this, gameStartActivity::class.java)
                Log.d("!!!", "nameText = $bet ")
                //intent.putExtra("betText", betText)
                //startActivity(intent)
                //do something here
                deck.shuffle()
                players.shuffle()
                button1Card = deck[1]
                button1Card.pile = 1
                piles.add(button1Card)
                button2Card = deck[2]
                button2Card.pile = 2
                piles.add(button2Card)
                button3Card = deck[3]
                button3Card.pile = 3
                piles.add(button3Card)
                button4Card = deck[4]
                button4Card.pile = 4
                piles.add(button4Card)
                button5Card = deck[5]
                button5Card.pile = 5
                piles.add(button5Card)
                true
            } else false
        })


    }
    fun createPlayers() {
//
        val player2 = Players("Victor ", 100, false)
        players.add(player2)
        val player3 = Players("Jessica ", 100, false)
        players.add(player3)
        val player4 = Players("Lionel ", 100, false)
        players.add(player4)
        val player5 = Players("Andrea ", 100, false)
        players.add(player5)
    }


    fun removePile() : Cards {
       //if(piles.isEmpty() ) {
       //    initializeWords()
       //}

       val rndPile = (0 until piles.size).random()
       val newPile = piles.removeAt(rndPile)

       return newPile
   }
    fun nextPlayerChoice() {
        var resultText = ""
        var highestVal = piles[valdPile]
        piles.removeAt(valdPile)

        valdPile += 1
        infoTextView.text = "$name du valde Korthög $valdPile"

            for (player in players) {

                var newPile = removePile()
                 resultText =  "${infoTextView.text}\n${player.name} väljer korthög ${newPile.pile}"
                infoTextView.text = resultText
                if(highestVal.value < newPile.value){
                    player.bank = true
                    player1.bank = false
                    highestVal = newPile
                }



            }
        if(!player1.bank){
            for(player in players) {
                if(player.bank)
                    resultText =  "${infoTextView.text}\n${player.name} har högsta kort och är Banken"
                infoTextView.text = resultText

            }
             if(player1.bank){
                resultText =  "${infoTextView.text}\n${player1.name} har högsta kort och är Banken"
                infoTextView.text = resultText

            }


        }



    }
    fun createDeck() {
        val card = Cards(R.drawable.a_s, 14, "spades")
        deck.add(card)
        val card1 = Cards(R.drawable.k_s, 13, "spades")
        deck.add(card1)
        val card2 = Cards(R.drawable.q_s, 12, "spades")
        deck.add(card2)
        val card3 = Cards(R.drawable.j_s, 11, "spades")
        deck.add(card3)
        val card4 = Cards(R.drawable.ten_s, 10, "spades")
        deck.add(card4)
        val card5 = Cards(R.drawable.nine_s, 9, "spades")
        deck.add(card5)
        val card6 = Cards(R.drawable.eight_s, 8, "spades")
        deck.add(card6)
        val card7 = Cards(R.drawable.seven_s, 7, "spades")
        deck.add(card7)
        val card8 = Cards(R.drawable.six_s, 6, "spades")
        deck.add(card8)
        val card9 = Cards(R.drawable.five_s, 5, "spades")
        deck.add(card9)
        val card10 = Cards(R.drawable.four_s, 4, "spades")
        deck.add(card10)
        val card11 = Cards(R.drawable.three_s, 3, "spades")
        deck.add(card11)
        val card12 = Cards(R.drawable.two_s, 2, "spades")
        deck.add(card12)
        //
        val card13 = Cards(R.drawable.a_h, 14, "hearts")
        deck.add(card13)
        val card14 = Cards(R.drawable.k_h, 13, "hearts")
        deck.add(card14)
        val card15 = Cards(R.drawable.q_h, 12, "hearts")
        deck.add(card15)
        val card16 = Cards(R.drawable.j_h,11, "hearts")
        deck.add(card16)
        val card17 = Cards(R.drawable.ten_h, 10, "hearts")
        deck.add(card17)
        val card18 = Cards(R.drawable.nine_h, 9, "hearts")
        deck.add(card18)
        val card19 = Cards(R.drawable.eight_h, 8, "hearts")
        deck.add(card19)
        val card20 = Cards(R.drawable.seven_h, 7, "hearts")
        deck.add(card20)
        val card21 = Cards(R.drawable.six_h, 6, "hearts")
        deck.add(card21)
        val card22 = Cards(R.drawable.five_h, 5, "hearts")
        deck.add(card22)
        val card23 = Cards(R.drawable.four_h, 4, "hearts")
        deck.add(card23)
        val card24 = Cards(R.drawable.three_h, 3, "hearts")
        deck.add(card24)
        val card25 = Cards(R.drawable.two_h, 2, "hearts")
        deck.add(card25)
        //
        val card26 = Cards(R.drawable.a_c, 14, "clubs")
        deck.add(card26)
        val card27 = Cards(R.drawable.k_c, 13, "clubs")
        deck.add(card27)
        val card28 = Cards(R.drawable.q_c, 12, "clubs")
        deck.add(card28)
        val card29 = Cards(R.drawable.j_c,11, "clubs")
        deck.add(card29)
        val card30 = Cards(R.drawable.ten_c, 10, "clubs")
        deck.add(card30)
        val card31 = Cards(R.drawable.nine_c, 9, "clubs")
        deck.add(card31)
        val card32 = Cards(R.drawable.eight_c, 8, "clubs")
        deck.add(card32)
        val card33 = Cards(R.drawable.seven_c, 7, "clubs")
        deck.add(card33)
        val card34 = Cards(R.drawable.six_c, 6, "clubs")
        deck.add(card34)
        val card35 = Cards(R.drawable.five_c, 5, "clubs")
        deck.add(card35)
        val card36 = Cards(R.drawable.four_c, 4, "clubs")
        deck.add(card36)
        val card37 = Cards(R.drawable.three_c, 3, "clubs")
        deck.add(card37)
        val card38 = Cards(R.drawable.two_c, 2, "clubs")
        deck.add(card38)
        //
        val card39 = Cards(R.drawable.a_d, 14, "diamonds")
        deck.add(card39)
        val card40 = Cards(R.drawable.k_d, 13, "diamonds")
        deck.add(card40)
        val card41 = Cards(R.drawable.q_d, 12, "diamonds")
        deck.add(card41)
        val card42 = Cards(R.drawable.j_d, 11, "diamonds")
        deck.add(card42)
        val card43 = Cards(R.drawable.ten_d, 10, "diamonds")
        deck.add(card43)
        val card44 = Cards(R.drawable.nine_d, 9, "diamonds")
        deck.add(card44)
        val card45 = Cards(R.drawable.eight_d, 8, "diamonds")
        deck.add(card45)
        val card46 = Cards(R.drawable.seven_d, 7, "diamonds")
        deck.add(card46)
        val card47 = Cards(R.drawable.six_d, 6, "diamonds")
        deck.add(card47)
        val card48 = Cards(R.drawable.five_d, 5, "diamonds")
        deck.add(card48)
        val card49 = Cards(R.drawable.four_d, 4, "diamonds")
        deck.add(card49)
        val card50 = Cards(R.drawable.three_d, 3, "diamonds")
        deck.add(card50)
        val card51 = Cards(R.drawable.two_d, 2, "diamonds")
        deck.add(card51)
    }

}