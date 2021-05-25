package com.example.zoombingo.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    primary = DarkBlue,
    primaryVariant = DarkBlue,
    secondary = DarkBlue,
    background = Dark,
    surface = Dark,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = LightBlue,
    primaryVariant = LightBlue,
    secondary = LightBlue,
    background = Color.White,
    surface = Color.White,
    onPrimary = DarkBlue,
    onSecondary = Dark,
    onBackground = Dark,
    onSurface = Dark
)

@Composable
fun ZoomBingoTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}