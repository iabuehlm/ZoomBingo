package com.example.zoombingo.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zoombingo.data.GameRepository
import kotlin.random.Random

class GameViewModel(private val gameRepository: GameRepository) : ViewModel() {

    private val _events = MutableLiveData<List<String>>()
    val events: LiveData<List<String>> = _events

    var isGameOver by mutableStateOf(false)
    var currentScore by mutableStateOf(0)
    var bingoList = mutableListOf(5,5,5,5,5,5,5,5,5,5)

    init {
        startNewGame()
    }

    fun startNewGame(){
        isGameOver = false
        bingoList = mutableListOf(5,5,5,5,5,5,5,5,5,5)
        val dataFromDb = gameRepository.getEvents()
        var tempData = dataFromDb
        _events.postValue(tempData
            .value
            .orEmpty()
            .map { event -> event.eventText }
            .shuffled(random = Random(1337))
            .take(25))
    }

    fun dismissNewGameDialog(){
        isGameOver = false
    }

    fun getGameState(): Boolean{
        return isGameOver
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
            currentScore.inc()
        }
    }
}
