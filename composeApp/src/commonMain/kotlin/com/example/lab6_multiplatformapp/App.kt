package com.example.lab6_multiplatformapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab6_multiplatformapp.ui.util.*

@Composable
fun App() {
    MaterialTheme {
        // Instantiate ViewModel
        val viewModel = remember { RecipeViewModel() }
        val selectedRecipe by viewModel.uiState.collectAsState()

        // BoxWithConstraints allow us to measure the screen width on any platform
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val isCompact = maxWidth < 600.dp

            if (isCompact) {
                // Mobile - narrow window view
                if (selectedRecipe.id == 0) {
                    // Show list
                    RecipeListScreen(
                        changeToDetails = { viewModel.setRecipe(it) },
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    // Show details
                    RecipeDetailScreen(
                        viewModel = viewModel,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            } else {
                Row(modifier = Modifier.fillMaxSize()) {
                    RecipeListScreen(
                        changeToDetails = { viewModel.setRecipe(it) },
                        modifier = Modifier.weight(1f)
                    )
                    RecipeDetailScreen(
                        viewModel = viewModel,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}