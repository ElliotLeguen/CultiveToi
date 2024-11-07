package com.example.cultivetoioutubois.ui.theme.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.cultivetoioutubois.bo.Player

@Composable
fun HomeScreen(navController: NavController, gameViewModel: GameViewModel = viewModel()) {
    var pseudo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Ajouter un Joueur",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = pseudo,
            onValueChange = { pseudo = it },
            label = { Text("Pseudo") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(
            onClick = {
                if (pseudo.isNotEmpty()) {
                    gameViewModel.addPlayer(Player(id = (gameViewModel.players.size + 1).toLong(), pseudo = pseudo))
                    pseudo = "" // Réinitialiser le champ texte après ajout
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text("Ajouter")
        }

        LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
            items(gameViewModel.players) { player ->
                Text(
                    text = player.pseudo,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                // Navigation vers la page des questions
                navController.navigate("questionsScreen")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Jouer")
        }
    }
}

