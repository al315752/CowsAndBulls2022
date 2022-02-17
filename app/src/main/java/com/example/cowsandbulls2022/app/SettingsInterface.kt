package com.example.cowsandbulls2022.app

interface SettingsInterface {
    fun showGameInfo(info: GameInfo)
    fun setColorsOk(ok: Boolean)
    fun setHolesOk(ok: Boolean)
    fun setPlayEnabled(enabled: Boolean)
    fun changeToGame(info: GameInfo)
}