package com.example.cowsandbulls2022.app

class Presenter(val view: SettingsView, var model: Model) {
    init {
        view.showGameInfo(model.toGameInfo())
        checkErrors()
    }

    fun checkErrors(){
        val colorsOk =
                if (!view.toggleRepetitions.isChecked)
                    if (view.editTextColors.text.isNotBlank())
                        if (view.editTextHoles.text.isNotBlank())
                            view.editTextColors.text.toString().toInt() in view.editTextHoles.text.toString().toInt()..9
                        else
                            false
                    else
                        false
                else
                    if (view.editTextColors.text.isNotBlank())
                        view.editTextColors.text.toString().toInt() in 2..9
                    else
                        false

        val holesOk =
                if (view.editTextHoles.text.isNotBlank())
                    view.editTextHoles.text.toString().toInt() in 2..9
                else
                    false

        model.numberOfColors = if (view.editTextColors.text.isNotBlank()) view.editTextColors.text.toString().toInt() else 0
        model.numberOfHoles = if (view.editTextHoles.text.isNotBlank()) view.editTextHoles.text.toString().toInt() else 0
        model.repetitionsAllowed = view.toggleRepetitions.isChecked

        view.setColorsOk(colorsOk)
        view.setHolesOk(holesOk)
        view.buttonPlay.isEnabled = colorsOk && holesOk
    }

    fun startGame(){
        view.changeToGame(model.toGameInfo())
    }
}