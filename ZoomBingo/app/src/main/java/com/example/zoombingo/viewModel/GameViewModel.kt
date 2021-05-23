package com.example.zoombingo.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    var isGameOver by mutableStateOf(false)
    var currentScore by mutableStateOf(0)
    var bingoList = mutableListOf(5,5,5,5,5,5,5,5,5,5)

    init{
        startNewGame()
    }

    fun startNewGame(){
        isGameOver = false
        bingoList = mutableListOf(5,5,5,5,5,5,5,5,5,5)
        //refresh view -> clicked
    }

    fun dismissNewGameDialog(){
        isGameOver = false
    }

    fun getGameState(): Boolean{
        return isGameOver
    }

    fun checkBingo(currentIndex: Int, isSelected: Boolean)
    {
        var index = 0
        var verticalOne = listOf(0,5,10,15,20)
        var verticalTwo = listOf(1,6,11,16,21)
        var verticalThree = listOf(2,7,12,17,22)
        var verticalFour = listOf(3,8,13,18,23)
        //var verticalFive = listOf(4,9,14,19,24)

        if(currentIndex <= 4)
        {
        }
        else if(currentIndex <= 9)
        {
            index = 1
        }
        else if(currentIndex <= 14)
        {
            index = 2
        }
        else if(currentIndex <= 19)
        {
            index = 3
        }
        else
        {
            index = 4
        }

        updateBingoIndex(index, isSelected)

        if(verticalOne.contains(currentIndex))
        {
            index = 5
        }
        else if(verticalTwo.contains(currentIndex))
        {
            index = 6
        }
        else if(verticalThree.contains(currentIndex))
        {
            index = 7
        }
        else if(verticalFour.contains(currentIndex))
        {
            index = 8
        }
        else
        {
            index = 9
        }

        updateBingoIndex(index, isSelected)
    }

    fun updateBingoIndex(index: Int, isSelected: Boolean){
        val listValue = bingoList.get(index).toInt()
        if(isSelected) {
            bingoList[index] = listValue.dec()
        }else
        {
            bingoList[index] = listValue.inc()
        }

        if(bingoList[index] == 0)
        {
            isGameOver = true
            currentScore.inc()
        }
    }
}









