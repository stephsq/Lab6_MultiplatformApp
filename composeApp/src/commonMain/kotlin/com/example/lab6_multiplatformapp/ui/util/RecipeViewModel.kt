package com.example.lab6_multiplatformapp.ui.util

import com.example.lab6_multiplatformapp.data.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecipeViewModel {
    private val _uiState = MutableStateFlow(Recipe(0,"",""))
    val uiState: StateFlow<Recipe> =_uiState.asStateFlow()

    fun setRecipe(recipe: Recipe){
        _uiState.value = recipe
    }
}