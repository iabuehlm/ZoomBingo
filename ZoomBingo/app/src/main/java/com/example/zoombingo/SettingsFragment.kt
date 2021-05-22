package com.example.zoombingo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zoombingo.viewModel.HomeViewModel

class SettingsFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        return ComposeView(requireContext()).apply {
            setContent {
                SettingsContent(viewModel)
            }
        }
    }
}

@Composable
fun SettingsContent(viewModel: HomeViewModel) {
    Column(modifier = Modifier
        .padding(16.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        //Text("Einstellungen", fontSize = 21.sp)
        val gameCount = 0//remember { mutableStateOf(false) }
        val won = 0//remember { mutableStateOf(false) }
        Text("Ganze Karte füllen zum Sieg: ", fontSize = 21.sp)
            //SimpleSwitch(viewModel)
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
fun SimpleThemeSwitch(viewModel: HomeViewModel) {
    val mRemember = remember { mutableStateOf(false) }

    Switch(checked = mRemember.value, onCheckedChange = {
        viewModel.toggleLightTheme()
        mRemember.value = it
    })
}

