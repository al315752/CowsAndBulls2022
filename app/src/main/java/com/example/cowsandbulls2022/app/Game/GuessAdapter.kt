package com.example.cowsandbulls2022.app.Game

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cowsandbulls2022.R
import es.uji.jvilar.bullsandcows.game.Guess

class GuessAdapter(val guessList: MutableList<Guess>): RecyclerView.Adapter<GuessAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_guess, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewGuess.text = guessList[position].numbers
        holder.textViewBulls.text = guessList[position].bulls.toString()
        holder.textViewCows.text = guessList[position].cows.toString()
    }

    override fun getItemCount(): Int = guessList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewGuess : TextView = view.findViewById(R.id.textViewGuess)
        val textViewBulls : TextView = view.findViewById(R.id.textViewBulls)
        val textViewCows : TextView = view.findViewById(R.id.textViewCows)
    }
}