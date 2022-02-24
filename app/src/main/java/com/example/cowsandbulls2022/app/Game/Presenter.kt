package com.example.cowsandbulls2022.app.Game

import es.uji.jvilar.bullsandcows.game.Guess

class Presenter(val view: GameActivity, val model: Model) {
    fun manageGuess(guess: String){
        val guessError = model.checkGuess(guess)
        if (guessError != null) view.displayMessage(guessError)
        else {
            val newGuess = Guess(guess, model.code)
            model.registerGuess(newGuess)
            view.displayGuesses(model.guessList)
            view.clearEntry()
            if (model.gameEnded) view.displayGameEndDialog(model.code, model.guessList.size)
        }
    }
}