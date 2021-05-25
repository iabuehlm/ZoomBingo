package com.example.zoombingo

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.zoombingo.ui.theme.ZoomBingoTheme
import com.example.zoombingo.view.GameUi
import com.example.zoombingo.view.ProfileUi
import com.example.zoombingo.view.SettingsUi
import com.example.zoombingo.viewModel.GameViewModel
import com.example.zoombingo.viewModel.GameViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: GameViewModel
    private lateinit var viewModelFactory: GameViewModelFactory

    companion object {
        var preferences: SharedPreferences? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        preferences = getSharedPreferences( packageName + "_preferences", MODE_PRIVATE)
        viewModelFactory = GameViewModelFactory(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(GameViewModel::class.java)
        super.onCreate(savedInstanceState)
        setContent {
            ZoomBingoApp(viewModel = viewModel) {
                Navigation(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun Navigation(viewModel: GameViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "MainMenuUi"
    ) {
        composable("MainMenuUi") { MainMenuUi(viewModel = viewModel, navController) }
        composable("GameUi"){ GameUi(viewModel = viewModel) }
        composable("SettingsUi"){ SettingsUi(viewModel = viewModel) }
        composable("ProfileUi"){ ProfileUi(viewModel = viewModel) }
    }
}

@Composable
fun ZoomBingoApp(
    viewModel: GameViewModel,
    content: @Composable () -> Unit,
) {
    ZoomBingoTheme(
        darkTheme = viewModel.isDark.value
    ) {
        Surface{
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                Text(
                                    stringResource(R.string.app_name),
                                )
                            }
                        },
                        contentColor = MaterialTheme.colors.onPrimary,
                        backgroundColor = MaterialTheme.colors.secondary,
                        elevation = 12.dp,
                    )
                }
            ) {
                content()
            }
        }
    }
}

@Composable
fun MainMenuUi(
    viewModel: GameViewModel,
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxHeight()) {
        Spacer(modifier = Modifier.padding(top = 16.dp))
        MainMenuButtons(navController, viewModel = viewModel)
    }
}

@Composable
fun MainMenuButtons(
    navController: NavController,
    viewModel: GameViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 150.dp, bottom = 180.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Button(onClick = {
            viewModel.startNewGame()
            navController.navigate("GameUi")
        },
            modifier = Modifier
                .width(200.dp)
        ) {
            Text(text = "Neues Spiel")
        }
        Button(onClick = {
            navController.navigate("SettingsUi")
        },
            modifier = Modifier
                .width(200.dp)
        ) {
            Text(text = "Einstellungen")
        }
        Button(onClick = {
            navController.navigate("ProfileUI")
        },
            modifier = Modifier
                .width(200.dp)
        ) {
            Text(text = "Profil")
        }
    }
}