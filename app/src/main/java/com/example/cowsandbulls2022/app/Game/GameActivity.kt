package com.example.cowsandbulls2022.app.Game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cowsandbulls2022.R
import com.example.cowsandbulls2022.app.GameInfo
import es.uji.jvilar.bullsandcows.game.Guess

class GameActivity : AppCompatActivity(), GameInterface {
    lateinit var editTextGuesses: EditText
    lateinit var buttonCheck: Button
    lateinit var recyclerViewGuesses: RecyclerView
    lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val info = intent.getParcelableExtra<GameInfo>("GAME_INFO")!!

        editTextGuesses = findViewById(R.id.editTextGuesses)
        buttonCheck = findViewById(R.id.buttonCheck)
        recyclerViewGuesses = findViewById(R.id.recyclerViewGuesses)
        presenter = Presenter(this, Model(info))


        buttonCheck.setOnClickListener {
            presenter.manageGuess(editTextGuesses.text.toString())
        }
    }

    override fun displayGameEndDialog(code: String, turns: Int) {
        AlertDialog.Builder(this).apply {
            setTitle("Game ended")
            setMessage("You found the code ($code) in $turns turns")
            setPositiveButton("OK"){ _, _ ->
                finish()
            }
            show()
        }
    }

    override fun displayGuesses(guessList: MutableList<Guess>) {
        recyclerViewGuesses.also{
            it.adapter = GuessAdapter(guessList)
            it.layoutManager = LinearLayoutManager(this)
        }
    }

    override fun displayMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun clearEntry() {
        editTextGuesses.setText("")
    }
}