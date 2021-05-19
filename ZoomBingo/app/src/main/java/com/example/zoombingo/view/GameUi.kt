package com.example.zoombingo.view

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
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


@Composable
fun GameUi(
    isGameOver: Boolean,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
                contentColor = Color.White,
                backgroundColor = MaterialTheme.colors.primaryVariant,
            )
        }
    ) {
        Spacer(modifier = Modifier.padding(top = 16.dp))
        GameGrid()

    }
    if(isGameOver){
        GameDialog(title = "Gewonnen", message = "Neues Spiel?",
            onConfirmListener = { }, onDismissListener = {})
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GameGrid(){
    val stringList = listOf("one", "gezwirbelter Schnauzer", "Lokomotive", "bli bla blu bli bla blu bli bla blu", "1","one", "two", "one", "Three", "1","one", "two", "one", "Three", "1","one", "two", "one", "Three", "1","one", "two", "one", "Three", "1")
    LazyVerticalGrid(
        cells = GridCells.Fixed(5)
    ) {
        items(stringList,
            itemContent = { list ->
                GameGridItem(list)
            })

    }
}

@Composable
fun GameGridItem(gridText: String){
    var isSelected by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(if (isSelected) Color.Cyan else Color.Transparent)
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable(onClick = { clickEvent(gridText)
                isSelected = !isSelected})
            .padding(1.dp)
            .height(75.dp)
            .background(color = backgroundColor)

    )
    {
        Text(gridText,
            modifier = Modifier
                .align(Alignment.Center)
                .matchParentSize(),
            textAlign = TextAlign.Center,
            fontSize = 12.sp,


                //.wrapContentSize(align = Alignment.Center, unbounded = true),

//                .heightIn(min = 5.dp, max= 30.dp)
//                .height( intrinsicSize = IntrinsicSize.Max)
        )

    }

}

fun clickEvent(gridText: String){
    Log.d("clicked", gridText)
}


@Preview(showBackground = true)
@Composable
fun DefaultPreviewGame() {

    GameUi(isGameOver = true)

}