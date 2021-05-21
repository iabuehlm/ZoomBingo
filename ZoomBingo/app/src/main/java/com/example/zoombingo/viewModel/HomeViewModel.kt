package com.example.zoombingo.viewModel

import androidx.compose.runtime.mutableStateOf

class HomeViewModel {
    //should be saved in database
    val isDark = mutableStateOf(false)

    public fun startNewGame() {

    }

    fun toggleLightTheme(){
        isDark.value = !isDark.value
    }
}