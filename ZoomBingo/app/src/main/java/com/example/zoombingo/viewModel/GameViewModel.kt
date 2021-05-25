package com.example.zoombingo.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.zoombingo.PreferenceHelper
import com.example.zoombingo.data.GameRepository

class GameViewModel(private val gameRepository: GameRepository) : ViewModel() {

    private val GAMES_PLAYED = "gamesPlayed"
    private val GAMES_WON = "gamesWon"
    private val gamesPlayed: MutableLiveData<Int> = MutableLiveData()
    private val gamesWon: MutableLiveData<Int> = MutableLiveData()

    val isDark = mutableStateOf(false)

    private var bingoList = mutableListOf(5,5,5,5,5,5,5,5,5,5)

    lateinit var events: LiveData<List<String>>
    var isGameOver by mutableStateOf(false)

    init {
        gamesPlayed.value = PreferenceHelper.getPreferenceValue(GAMES_PLAYED)
        gamesWon.value = PreferenceHelper.getPreferenceValue(GAMES_WON)
    }

    fun getGamesPlayed(): LiveData<Int> { return gamesPlayed }

    fun getGamesWon(): LiveData<Int> { return gamesWon }

    fun startNewGame(){
        incrementGamesPlayedPreferences()
        isGameOver = false
        bingoList = mutableListOf(5,5,5,5,5,5,5,5,5,5)
        val mappedEvents = Transformations.map(gameRepository.events) { it.map { event -> event.eventText } }
        val shuffledEvents = Transformations.map(mappedEvents) { it.shuffled() }
        val twentyFiveEvents = Transformations.map(shuffledEvents) { it.take(25) }
        events = twentyFiveEvents
    }

    fun checkBingo(selectedGridText: String, isSelected: Boolean) {
        val currentIndex: Int = events.value.orEmpty().indexOf(element = selectedGridText)
        val column1 = listOf(0,5,10,15,20)
        val column2 = listOf(1,6,11,16,21)
        val column3 = listOf(2,7,12,17,22)
        val column4 = listOf(3,8,13,18,23)
        var rowIndex: Int
        var columnIndex: Int

        when {
            currentIndex <= 4 -> {
                rowIndex = 0
            }
            currentIndex <= 9 -> {
                rowIndex = 1
            }
            currentIndex <= 14 -> {
                rowIndex = 2
            }
            currentIndex <= 19 -> {
                rowIndex = 3
            }
            else -> {
                rowIndex = 4
            }
        }

        updateBingoIndex(rowIndex, isSelected)

        when {
            column1.contains(currentIndex) -> {
                columnIndex = 5
            }
            column2.contains(currentIndex) -> {
                columnIndex = 6
            }
            column3.contains(currentIndex) -> {
                columnIndex = 7
            }
            column4.contains(currentIndex) -> {
                columnIndex = 8
            }
            else -> {
                columnIndex = 9
            }
        }

        updateBingoIndex(columnIndex, isSelected)
    }

    fun toggleLightTheme(){
        isDark.value = !isDark.value
    }

    private fun incrementGamesPlayedPreferences() {
        val storedValue = PreferenceHelper.getPreferenceValue(GAMES_PLAYED)
        val newValue = storedValue + 1
        PreferenceHelper.setPreferenceValue(GAMES_PLAYED, newValue)
        gamesPlayed.value = newValue
    }

    private fun incrementGamesWonPreferences() {
        val storedValue = PreferenceHelper.getPreferenceValue(GAMES_WON)
        val newValue = storedValue + 1
        PreferenceHelper.setPreferenceValue(GAMES_WON, newValue)
        gamesWon.value = newValue
    }

    private fun updateBingoIndex(index: Int, isSelected: Boolean){
        val listValue = bingoList[index]
        if (isSelected) {
            bingoList[index] = listValue.dec()
        } else {
            bingoList[index] = listValue.inc()
        }

        if (bingoList[index] == 0) {
            isGameOver = true
            incrementGamesWonPreferences()
        }
    }
}
