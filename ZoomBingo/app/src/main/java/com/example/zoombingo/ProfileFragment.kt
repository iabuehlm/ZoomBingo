package com.example.zoombingo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment

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
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Profil", fontSize = 21.sp)
        val gameCount = 0//remember { mutableStateOf(false) }
        val won = 0//remember { mutableStateOf(false) }
        Text("Anzahl Spiele: $gameCount" )
        Spacer(modifier = Modifier.padding(16.dp))
        Text("Davon gewonnen: $won" )
    }
}