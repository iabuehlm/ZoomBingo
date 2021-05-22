package com.example.zoombingo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.zoombingo.view.GameUi
import com.example.zoombingo.viewModel.GameViewModel

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent(){
    Column(modifier = Modifier
        //.padding(16.dp)
        .fillMaxHeight()
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Text("Profil", fontSize = 21.sp)
        val gameCount = 0//remember { mutableStateOf(false) }
        val won = 0//remember { mutableStateOf(false) }

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