package com.example.zoombingo.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun GameUi(
    isGameOver: Boolean,
) {
    if(isGameOver){
        GameDialog(title = "Gewonnen", message = "Neues Spiel?", onConfirmListener = { }) {

        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreviewGame() {

    GameUi(isGameOver = true)

}