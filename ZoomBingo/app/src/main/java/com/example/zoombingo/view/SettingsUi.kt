package com.example.zoombingo.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zoombingo.viewModel.GameViewModel

@Composable
fun SettingsUi(viewModel: GameViewModel) {
    Column(modifier = Modifier
        .padding(16.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        Text("Ganze Karte füllen zum Sieg: ", fontSize = 21.sp)
        Spacer(modifier = Modifier.padding(10.dp))

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Theme dark mode: " , fontSize = 21.sp)
            SimpleThemeSwitch(viewModel)
        }
    }
}

@Composable
fun SimpleThemeSwitch(viewModel: GameViewModel) {
    var mRemember by remember { mutableStateOf(false) }

    Switch(checked = mRemember, onCheckedChange = {
        viewModel.toggleLightTheme()
        mRemember = it
    })
}