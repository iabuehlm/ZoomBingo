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

    fun getGamesPlayed(): LiveData<Int> {
        return gamesPlayed
    }

    fun getGamesWon(): LiveData<Int> {
        return gamesWon
    }

    lateinit var events: LiveData<List<String>>
    val isDark = mutableStateOf(false)

    var isGameOver by mutableStateOf(false)
    var bingoList = mutableListOf(5,5,5,5,5,5,5,5,5,5)

    init {
        gamesPlayed.value = PreferenceHelper.getPreferenceValue(GAMES_PLAYED)
        gamesWon.value = PreferenceHelper.getPreferenceValue(GAMES_WON)
    }

    fun startNewGame(){
        incrementGamesPlayedPreferences()
        isGameOver = false
        bingoList = mutableListOf(5,5,5,5,5,5,5,5,5,5)
        val mappedEvents = Transformations.map(gameRepository.events) { it.map { event -> event.eventText } }
        val shuffledEvents = Transformations.map(mappedEvents) { it.shuffled() }
        val twentyFiveEvents = Transformations.map(shuffledEvents) { it.take(25) }
        events = twentyFiveEvents
    }

    fun incrementGamesPlayedPreferences() {
        val storedValue = PreferenceHelper.getPreferenceValue(GAMES_PLAYED)
        val newValue = storedValue + 1
        PreferenceHelper.setPreferenceValue(GAMES_PLAYED, newValue)
        gamesPlayed.value = newValue
    }

    fun incrementGamesWonPreferences() {
        val storedValue = PreferenceHelper.getPreferenceValue(GAMES_WON)
        val newValue = storedValue + 1
        PreferenceHelper.setPreferenceValue(GAMES_WON, newValue)
        gamesWon.value = newValue
    }

    fun checkBingo(selectedGridText: String, isSelected: Boolean)
    {
        val currentIndex: Int = events.value.orEmpty().indexOf(element = selectedGridText)
        var rowIndex = 0
        var columnIndex = 0
        val verticalOne = listOf(0,5,10,15,20)
        val verticalTwo = listOf(1,6,11,16,21)
        val verticalThree = listOf(2,7,12,17,22)
        val verticalFour = listOf(3,8,13,18,23)

        if(currentIndex <= 4)
        {
        }
        else if(currentIndex <= 9)
        {
            rowIndex = 1
        }
        else if(currentIndex <= 14)
        {
            rowIndex = 2
        }
        else if(currentIndex <= 19)
        {
            rowIndex = 3
        }
        else
        {
            rowIndex = 4
        }

        updateBingoIndex(rowIndex, isSelected)

        if(verticalOne.contains(currentIndex))
        {
            columnIndex = 5
        }
        else if(verticalTwo.contains(currentIndex))
        {
            columnIndex = 6
        }
        else if(verticalThree.contains(currentIndex))
        {
            columnIndex = 7
        }
        else if(verticalFour.contains(currentIndex))
        {
            columnIndex = 8
        }
        else
        {
            columnIndex = 9
        }

        updateBingoIndex(columnIndex, isSelected)
    }

    fun updateBingoIndex(index: Int, isSelected: Boolean){
        val listValue = bingoList.get(index)
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

    fun toggleLightTheme(){
        isDark.value = !isDark.value
    }
}
