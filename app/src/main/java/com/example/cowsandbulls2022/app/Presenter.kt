package com.example.cowsandbulls2022.app

class Presenter(val view: SettingsView, model: Model) {
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

        view.setColorsOk(colorsOk)
        view.setHolesOk(holesOk)
        view.buttonPlay.isEnabled = colorsOk && holesOk
    }
}