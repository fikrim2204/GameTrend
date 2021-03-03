package rpl1pnp.fikri.gametrend.viewmodel

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import rpl1pnp.fikri.gametrend.model.Game

class MainViewModel(private val resources: Resources) : ViewModel() {
    private var games: MutableList<Game> = mutableListOf()

    fun getAllGame() {

    }
}