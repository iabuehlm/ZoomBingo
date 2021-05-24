package com.example.zoombingo.viewModel;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.zoombingo.data.GameRepository

class GameViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T: ViewModel?> create(modelClass: Class<T>) : T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            return GameViewModel(GameRepository(context)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}