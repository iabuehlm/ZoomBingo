package com.example.zoombingo.view

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zoombingo.R
import com.example.zoombingo.viewModel.GameViewModel


@Composable
fun GameUi(
    viewModel: GameViewModel
) {
    val openDialog = remember { mutableStateOf(true) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.app_name),
                        textAlign = TextAlign.Center,
                    )
                        },
                contentColor = Color.White,
                backgroundColor = MaterialTheme.colors.primaryVariant,
                elevation = 12.dp,
            )
        }

    ) {
        GameGrid(viewModel)
    }
    if(viewModel.isGameOver){
            GameDialog(title = "Gewonnen", message = "Neues Spiel?",
                onConfirmListener = { viewModel.startNewGame()}, onDismissListener = {})
    }
}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GameGrid(viewModel: GameViewModel) {
    val stringList = listOf("Bier", "gezwirbelter Schnauzer", "Lokomotive", "bli bla blu bli bla blu bli bla blu", "1","one", "2", "3", "4", "5","6", "7", "8", "9", "10","11", "22", "33", "44", "55","66", "77", "88", "99", "111")
    val bingoList = stringList

    LazyVerticalGrid(
        cells = GridCells.Fixed(5),
        modifier = Modifier
            .padding(15.dp)
    ) {
        items(stringList
        ) { list ->
            GameGridItem(list, bingoList, viewModel)
        }
    }
}

@Composable
fun GameGridItem(gridText: String, bingoList: List<String>, viewModel: GameViewModel){
    var isSelected by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(if (isSelected) Color.Cyan else Color.Transparent)

    Box(
        modifier = Modifier
            .padding(2.dp)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable(onClick = {
                clickEvent(gridText, bingoList, viewModel)
                isSelected = !isSelected
            })
            .padding(2.dp)
            .height(75.dp)
            .background(color = backgroundColor)
    )
    {
        Text(gridText ,
            modifier = Modifier
                .align(Alignment.Center)
                .matchParentSize(),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )

    }

}

fun clickEvent(gridText: String, bingoList: List<String>, viewModel: GameViewModel){
   var index: Int =  bingoList.indexOf(gridText)
    Log.d("bingo", index.toString())
    viewModel.checkBingo(index)
}


@Preview(showBackground = true)
@Composable
fun DefaultPreviewGame() {
    GameUi( viewModel = GameViewModel())
}