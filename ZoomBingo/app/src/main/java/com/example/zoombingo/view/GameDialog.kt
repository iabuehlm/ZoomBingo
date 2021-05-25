package com.example.zoombingo.view

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable

@Composable
fun GameDialog(
    title: String,
    message: String,
    onConfirmListener: () -> Unit
) {
    AlertDialog(
        title = { Text(text = title) },
        text = { Text(text = message) },
        confirmButton = {
            TextButton(
                onClick = { onConfirmListener() }
            ) {
                Text("OK")
            }
                        },
        onDismissRequest = {  }
    )
}