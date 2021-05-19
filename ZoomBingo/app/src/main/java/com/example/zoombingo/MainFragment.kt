package com.example.zoombingo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.zoombingo.ui.theme.ZoomBingoTheme

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = ComposeView(requireContext()).apply {
            setContent {
                MyApp{
                    MyScreenContent(view)
                }

            }
        }
        return view

    }
}

@Composable
fun MyApp(content: @Composable () -> Unit,
          ){
    ZoomBingoTheme(darkTheme = false) {
        // A surface container using the 'background' color from the theme
        //Surface(color = Color.White) {
        Surface{
            content()
        }
    }
}

@Composable
fun MyScreenContent(view:View?) {
    //val textState = remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxHeight()) {
        MainTitle(text = "Zoom Bingo")
        Spacer(modifier = Modifier.padding(top = 10.dp))
        MainContent(view)
    }
}

@Composable
fun MainTitle(text: String){
    Text(text = text,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
        ,
        style = MaterialTheme.typography.h5,
        fontSize = 30.sp
    )
}

@Composable
fun MainContent(view: View?){
    Column() {
        Button(onClick = {
            view?.findNavController()?.navigate(R.id.action_view_gameFragment)
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan),
            modifier = Modifier.padding(16.dp)
            ) {
            Text(text = "Neues Spiel")
        }
        Button(onClick = {
            view?.findNavController()?.navigate(R.id.action_view_settingsFragment)
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan),
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Einstellungen")
        }
        Button(onClick = { //Vorerst hier
            view?.findNavController()?.navigate(R.id.action_view_profileFragment)
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan),
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Profil")
        }

    }
}





