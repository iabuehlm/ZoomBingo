package com.example.zoombingo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.zoombingo.ui.theme.ZoomBingoTheme
import com.example.zoombingo.view.AppTheme
import com.example.zoombingo.view.HomeUi
import kotlinx.coroutines.NonCancellable.children


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface {
                    HomeUi(
                        onNewGameRequested = { /**startNewGame()**/}
                    )
                }
            }
        }
    }
}

/**
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp{
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit){
    ZoomBingoTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = Color.White) {
            content()
        }
    }
}

@Composable
fun MyScreenContent(names: List<String> = List(1000) { "Hello Android #$it" }) {
    //val textState = remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxHeight()) {
        MainTitle(text = "Zoom Bingo")
        Spacer(modifier = Modifier.padding(top = 10.dp))
        MainContent()
    }
}

@Composable
fun MainTitle(text: String){
    Text(text = text,
        modifier = Modifier
            .background(color = Color.Cyan)
            .padding(16.dp),
        style = MaterialTheme.typography.h5,
    )
}

@Composable
fun MainContent(){
    Column() {
        Button(onClick = { },
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


@Composable
fun BingoGame(){
    Column(modifier = Modifier.fillMaxHeight()) {
        MainTitle(text = "Zoom Bingo")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    MyApp{
        MyScreenContent()
    }

}
**/