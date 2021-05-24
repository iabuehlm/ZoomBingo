package com.example.zoombingo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.zoombingo.ui.theme.ZoomBingoTheme
import com.example.zoombingo.viewModel.HomeViewModel

class MainFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        return ComposeView(requireContext()).apply {
            setContent {
                MyApp(viewModel) {
                    MyScreenContent(this@MainFragment.view)
                }
            }
        }
    }
}

@Composable
fun MyApp(
        viewModel: HomeViewModel,
        content: @Composable () -> Unit,
    )
{
    ZoomBingoTheme(
        darkTheme = viewModel.isDark.value
    ) {
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
            .fillMaxWidth(),
        style = MaterialTheme.typography.h5,
        fontSize = 30.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun MainContent(view: View?){
    Column(
        modifier = Modifier
            //.padding(10.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Button(onClick = {
            view?.findNavController()?.navigate(R.id.action_view_gameFragment)
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
            ) {
            Text(text = "Neues Spiel")
        }
        Button(onClick = {
            view?.findNavController()?.navigate(R.id.action_view_settingsFragment)
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Einstellungen")
        }
        Button(onClick = { //Vorerst hier
            view?.findNavController()?.navigate(R.id.action_view_profileFragment)
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Profil")
        }
    }
}





