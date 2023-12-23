package com.blipblipcode.demoincompose.ui.controls

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview()
@Composable
fun Grid() {
    Box(
        Modifier
            .size(100.dp)
            .background(Color.Cyan),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(text = "Hola", Modifier.align(Alignment.BottomCenter))
        Text("Kotlin")
    }

}