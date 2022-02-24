package com.example.cowsandbulls2022.app

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ToggleButton
import androidx.core.widget.addTextChangedListener
import com.example.cowsandbulls2022.R
import com.example.cowsandbulls2022.app.Game.GameActivity as GameActivity1

class SettingsView : AppCompatActivity(), SettingsInterface {
    lateinit var editTextColors: EditText
    lateinit var editTextHoles: EditText
    lateinit var toggleRepetitions: ToggleButton
    lateinit var buttonPlay: Button

    lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextColors = findViewById(R.id.editTextColors)
        editTextHoles = findViewById(R.id.editTextHoles)
        toggleRepetitions = findViewById(R.id.toggleRepetitions)
        buttonPlay = findViewById(R.id.buttonPlay)

        presenter = Presenter(this, Model())

        editTextColors.addTextChangedListener(){
            presenter.checkErrors()
        }
        editTextHoles.addTextChangedListener(){
            presenter.checkErrors()
        }
        toggleRepetitions.setOnClickListener{
            presenter.checkErrors()
        }
        buttonPlay.setOnClickListener {
            presenter.startGame()
        }
    }

    override fun showGameInfo(info: GameInfo) {
        editTextColors.setText(info.numberOfColors.toString())
        editTextHoles.setText(info.numberOfHoles.toString())
        toggleRepetitions.isChecked = info.repetitionsAllowed
    }

    override fun setColorsOk(ok: Boolean) {
        if (ok) editTextColors.setTextColor(Color.rgb(0,255,0))
        else editTextColors.setTextColor(Color.rgb(255,0,0))
    }

    override fun setHolesOk(ok: Boolean) {
        if (ok) editTextHoles.setTextColor(Color.rgb(0,255,0))
        else editTextHoles.setTextColor(Color.rgb(255,0,0))
    }

    override fun setPlayEnabled(enabled: Boolean) {
        buttonPlay.isEnabled = enabled
    }

    override fun changeToGame(info: GameInfo) {
        val intent = Intent(this, GameActivity1::class.java).apply {
            putExtra("GAME_INFO", info)
        }
        startActivity(intent)
    }
}