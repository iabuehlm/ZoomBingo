package com.example.zoombingo.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainContent(){
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val gameCount = 0
        val won = 0

        Text("Anzahl Spiele: $gameCount" , fontSize = 21.sp)
        Spacer(modifier = Modifier.padding(16.dp))
        Text("Davon gewonnen: $won", fontSize = 21.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewProfile() {
    MainContent()
}