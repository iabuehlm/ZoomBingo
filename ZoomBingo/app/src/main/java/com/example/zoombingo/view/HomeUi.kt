package com.example.zoombingo.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zoombingo.viewModel.HomeViewModel

@Composable
fun HomeUi(
    onNewGameRequested: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Zoom Bingo") },
                contentColor = Color.White,
                backgroundColor = MaterialTheme.colors.primaryVariant
                    )
        }
    ) {
        MyScreenContent()
    }
}

@Composable
fun MyScreenContent(names: List<String> = List(1000) { "Hello Android #$it" }) {
    //val textState = remember { mutableStateOf(0) }

    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()) {
        Spacer(modifier = Modifier.padding(top = 10.dp))
        MainContent()
    }
}

@Composable
fun MainContent(){
    Column() {
        Button(onClick = {  },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Neues Spiel")
        }
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Einstellungen")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

   // HomeUi( HomeViewModel.startNewGame() //Create instance   )

}