package com.example.cowsandbulls2022.app.Game

import android.util.Log
import com.example.cowsandbulls2022.app.GameInfo
import es.uji.jvilar.bullsandcows.game.Guess
import kotlin.random.Random
import kotlin.random.nextInt

class Model(info: GameInfo) {
    private var holes = info.numberOfHoles //length
    private val colors = info.numberOfColors //range
    private val repetitionsAllowed = info.repetitionsAllowed
    var gameEnded: Boolean = false
    val guessList = mutableListOf<Guess>()
    val code = generateCode()

    private fun generateCode(): String {
        return with(StringBuilder(holes)) {
            for (i in 1..holes) {
                var n: Char
                do {
                    n = Random.nextInt(1..colors).toString()[0]
                } while (!repetitionsAllowed && contains(n))
                append(n)
            }
            toString().also {
                Log.i("GameModel", "Code generated: $it")
            }
        }
    }

    fun checkGuess(guess: String): String? {
        if (guess.length != holes) return "The guess has to be $holes digits long!"

        for (i in guess.indices)
            if (guess[i].toString().toInt() > colors)
                return "The guess cannot contain digits greater than $colors!"

        if (!repetitionsAllowed)
            for (i in guess.indices)
                for (j in i + 1 until guess.length)
                    if (guess[i] == guess[j])
                        return "Digits must be unique, repetitions are not allowed!"

        return null
    }

    fun registerGuess(guess: Guess) {
        guessList.add(guess)
        if (guess.numbers == code) gameEnded = true
    }
}