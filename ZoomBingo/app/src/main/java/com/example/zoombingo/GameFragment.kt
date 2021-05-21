package com.example.zoombingo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zoombingo.view.GameUi
import com.example.zoombingo.viewModel.GameViewModel

class GameFragment : Fragment() {

    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        return ComposeView(requireContext()).apply {
            setContent {
                GameUi(isGameOver = false, viewModel) //mit variable ersetzen
            }
        }
    }
}
