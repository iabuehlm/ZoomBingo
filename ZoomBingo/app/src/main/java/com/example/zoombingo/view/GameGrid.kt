package com.example.zoombingo.view

import androidx.compose.runtime.Composable
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.min


private val GRID_TILE_RADIUS = 4.dp
const val GRID_SIZE = 5

@Composable
fun GameGrid() {
    BoxWithConstraints {

        val width = with(LocalDensity.current) { maxWidth.toPx() }
        val height = with(LocalDensity.current) { maxHeight.toPx() }
        val tileMarginPx = with(LocalDensity.current) { 4.dp.toPx() }
        val tileSizePx =
            ((min(width, height) - tileMarginPx * (GRID_SIZE - 1)) / GRID_SIZE).coerceAtLeast(0f)
        val tileSizeDp = Dp(tileSizePx / LocalDensity.current.density)
        val tileSizeHightDp = Dp(tileSizePx + 1)
        val tileOffsetPx = tileSizePx + tileMarginPx
        Box(


        ) {

            // Draw the background empty tiles.
            for (row in 0 until GRID_SIZE) {
                for (col in 0 until GRID_SIZE) {
                    Box(
                        modifier = Modifier.drawWithContent {
                            drawRoundRect(
                                color = Color.LightGray,
                                topLeft = Offset(col * tileOffsetPx, row * tileOffsetPx),
                                size = Size(tileSizePx, tileSizePx),
                                cornerRadius = CornerRadius(GRID_TILE_RADIUS.toPx()),

                            )
                        }.clickable {
                            Log.d("clicked", "0")
                        }
                    )

                }
            }
        }
        /**
        Row(modifier = Modifier.fillMaxWidth()
        .height(Dp(height ))
        .padding(bottom = 16.dp)
        ){
        for (row in 0 until GRID_SIZE) {
        for (col in 0 until GRID_SIZE) {
        if(counter >= 0){
        counter.dec()
        ClickableText(
        text = AnnotatedString("Test"),
        style = TextStyle(background =  Color.Blue ),
        modifier = Modifier.size(tileSizeDp, tileSizeHightDp)
        .padding( start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp)
        ,onClick = {
        Log.d("Clicked $counter", counter.toString())
        }
        )

        }

        }
        }
        }**/

        /**
        Box(
        Modifier
        .width(Dp(width))
        .height(Dp(height))
        ) {
        for (row in 0 until GRID_SIZE) {
        for (col in 0 until GRID_SIZE) {
        if(counter >= 0){

        ClickableText(
        text = AnnotatedString("Test"),
        style = TextStyle(background = if(selected.value) Color.Blue else Color.LightGray),
        modifier = Modifier.size(tileSizeDp, tileSizeHightDp)
        .
        .padding( start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp)
        ,onClick = {
        selected.value = !selected.value
        }
        )
        }
        /**Button(onClick = { color.value = Color.Blue }, colors = ButtonDefaults.buttonColors(backgroundColor = color.value),
        modifier =  Modifier.size(tileSizeDp, tileSizeHightDp)
        ) {

        }**/
        }
        }
        }**/

    }
}