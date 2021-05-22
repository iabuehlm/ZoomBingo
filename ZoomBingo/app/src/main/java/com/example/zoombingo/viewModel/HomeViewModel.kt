package com.example.zoombingo.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    //should be saved in database
    val isDark = mutableStateOf(false)

    fun toggleLightTheme(){
        isDark.value = !isDark.value
    }
}