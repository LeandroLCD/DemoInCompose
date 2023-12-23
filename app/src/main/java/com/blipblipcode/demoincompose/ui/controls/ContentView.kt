package com.blipblipcode.demoincompose.ui.controls

import android.util.Log
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentView() {

    Card(
        onClick = { Log.d("Card", "onClick") }, elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
            pressedElevation = 0.dp,
            focusedElevation = 20.dp
        )
    ) {
        Label(text = "Hola")
        Label(text = "Android")
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCard() {
    ContentView()
}