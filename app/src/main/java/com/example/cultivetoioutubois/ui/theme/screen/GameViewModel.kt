package com.example.cultivetoioutubois.ui.theme.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.cultivetoioutubois.bo.Player

class GameViewModel : ViewModel() {
    // Stocke la liste des joueurs dans le ViewModel
    var players by mutableStateOf<List<Player>>(emptyList())
        private set

    // Fonction pour ajouter un joueur
    fun addPlayer(player: Player) {
        players = players + player
    }
}
