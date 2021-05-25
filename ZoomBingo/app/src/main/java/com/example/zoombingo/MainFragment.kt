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
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.zoombingo.ui.theme.ZoomBingoTheme
import com.example.zoombingo.view.GameUi
import com.example.zoombingo.view.SettingsContent
import com.example.zoombingo.view.*
import com.example.zoombingo.viewModel.GameViewModel
import com.example.zoombingo.viewModel.GameViewModelFactory

class MainFragment : Fragment() {

    private lateinit var viewModel: GameViewModel
    private lateinit var viewModelFactory: GameViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModelFactory = GameViewModelFactory(this.requireContext())
        viewModel = ViewModelProvider(this, viewModelFactory).get(GameViewModel::class.java)
        return ComposeView(requireContext()).apply {
            setContent {
                MyApp(viewModel = viewModel) {
                    AppNavigator(viewModel)
                }
            }
        }
    }
}

@Composable
fun AppNavigator(viewModel: GameViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "MyZoomBingoApp"
    ){
        composable("MyZoomBingoApp") { MyScreenContent(viewModel, navController)};
        composable("GameUi"){ GameUi(viewModel = viewModel) }
        composable("SettingsUi"){ SettingsContent(viewModel) }
        composable("ProfileUi"){ ProfileUi(viewModel) }
    }
}

@Composable
fun MyApp(
    viewModel: GameViewModel,
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
fun MyScreenContent(viewModel: GameViewModel, navController: NavController) {
    Column(modifier = Modifier.fillMaxHeight()) {
        MainTitle(text = "Zoom Bingo")
        Spacer(modifier = Modifier.padding(top = 10.dp))
        MainContent(navController, viewModel = viewModel)
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
fun MainContent(navController: NavController, viewModel: GameViewModel){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Button(onClick = {
            viewModel.startNewGame()
            navController.navigate("GameUi")
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Neues Spiel")
        }
        Button(onClick = {
            navController.navigate("SettingsUi")
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Cyan),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Einstellungen")
        }
        Button(onClick = {
            navController.navigate("ProfileUI")
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





