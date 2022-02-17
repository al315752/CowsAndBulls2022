package com.example.cowsandbulls2022.app

class Model() {
    var numberOfColors: Int = 6
    var numberOfHoles: Int = 4
    var repetitionsAllowed: Boolean = false
    val colorsOK: Boolean = false
    val holesOK: Boolean = false

    constructor(info: GameInfo) : this() {
        numberOfColors = info.numberOfColors
        numberOfHoles = info.numberOfHoles
        repetitionsAllowed = info.repetitionsAllowed
    }

    fun toGameInfo(): GameInfo{
        return GameInfo(numberOfColors, numberOfHoles, repetitionsAllowed)
    }
}