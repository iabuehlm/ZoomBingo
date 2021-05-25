package com.example.zoombingo.view

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
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zoombingo.viewModel.GameViewModel

@Composable
fun GameUi(
    viewModel: GameViewModel
) {
    GameGrid(viewModel)

    if(viewModel.isGameOver){
            GameDialog(title = "Gewonnen",
                message = "Herzlichen Glückwunsch!!!",
                onConfirmListener = { viewModel.startNewGame() })
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GameGrid(viewModel: GameViewModel) {
    val eventTexts: List<String> by viewModel.events.observeAsState(listOf())

    LazyVerticalGrid(
        cells = GridCells.Fixed(5),
        modifier = Modifier
            .padding(10.dp)
            .padding(top = 16.dp)
    ) {
        items(eventTexts) { eventText ->
            GameGridItem(eventText, viewModel)
        }
    }
}

@Composable
fun GameGridItem(gridText: String, viewModel: GameViewModel) {

    var isSelected by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(if (isSelected) MaterialTheme.colors.secondary else Color.Transparent)

    Box(
        modifier = Modifier
            .padding(2.dp)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable(onClick = {
                isSelected = !isSelected
                clickEvent(gridText, isSelected, viewModel)
            })
            .padding(2.dp)
            .height(75.dp)
            .background(color = backgroundColor),
        )
    {
        Text(
            gridText,
            modifier = Modifier
                .align(Alignment.Center)
                .matchParentSize(),
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }

    if(viewModel.isGameOver){
        DisposableEffect(Unit) {
            onDispose {
                isSelected = false
            }
        }
    }
}

fun clickEvent(
    gridText: String,
    isSelected: Boolean,
    viewModel: GameViewModel
) {
    viewModel.checkBingo(gridText, isSelected)
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreviewGame() {
//    GameUi(viewModel = GameViewModelFactory.create())
//}