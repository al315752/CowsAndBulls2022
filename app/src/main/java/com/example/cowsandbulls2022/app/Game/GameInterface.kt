package com.example.cowsandbulls2022.app.Game

import es.uji.jvilar.bullsandcows.game.Guess

interface GameInterface {
    fun displayGameEndDialog(code: String, turns: Int)
    fun displayGuesses(guessList: MutableList<Guess>)
    fun displayMessage(message: String)
    fun clearEntry()
}