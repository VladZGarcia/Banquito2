package com.example.banquito2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity


class BanquitoGameActivity : AppCompatActivity() {

    lateinit var playerTextView : TextView
    lateinit var writeNameTextView : TextView
    lateinit var nameView : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banquito_game)

        playerTextView = findViewById(R.id.playerTextView)
        writeNameTextView = findViewById(R.id.writeNameTextView)
        nameView = findViewById(R.id.nameView)

        playerTextView.text = "Victor, Jessica, Lionel och Andrea är med och spelar med 50 'banquitos' som insats"
        writeNameTextView.text = "Skriv in ditt namn!"

        val button =findViewById<Button>(R.id.nextButton)
        nameView.setOnEditorActionListener(OnEditorActionListener { v, id, event ->
            if (id == EditorInfo.IME_ACTION_DONE) {
                val nameText = nameView.text.toString() ?: "player1"
                val intent = Intent( this, BanquitoStartActivity::class.java)
                Log.d("!!!","nameText = $nameText " )
                intent.putExtra("nameText",nameText)
                startActivity(intent)

                true
            } else false
        })
        button.setOnClickListener {
            val nameText = nameView.text.toString() ?: "player1"
            val intent = Intent( this, BanquitoStartActivity::class.java)
            Log.d("!!!","nameText = $nameText " )
            intent.putExtra("nameText",nameText)
            startActivity(intent)

        }

    }

}