package com.example.cultivetoioutubois

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.compose.*
import com.example.cultivetoioutubois.ui.theme.CultiveToiOuTuBoisTheme
import com.example.cultivetoioutubois.ui.theme.screen.HomeScreen
import com.example.cultivetoioutubois.ui.theme.screen.QuestionsScreen
import com.example.cultivetoioutubois.bo.Player
import com.example.cultivetoioutubois.ui.theme.screen.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CultiveToiOuTuBoisTheme {
                val navController = rememberNavController()
                val gameViewModel: GameViewModel = viewModel()  // Récupère le ViewModel

                NavHost(
                    navController = navController,
                    startDestination = "homeScreen"
                ) {
                    composable("homeScreen") {
                        // Passer gameViewModel à HomeScreen
                        HomeScreen(navController = navController, gameViewModel = gameViewModel)
                    }
                    composable("questionsScreen") {
                        // Passer gameViewModel à QuestionsScreen
                        QuestionsScreen(navController = navController, gameViewModel = gameViewModel)
                    }
                }
            }
        }
    }
}


