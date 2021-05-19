package com.example.zoombingo.view

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout
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


@Preview(showBackground = true)
@Composable
fun DefaultPreviewGame() {

    GameUi(isGameOver = true)

}