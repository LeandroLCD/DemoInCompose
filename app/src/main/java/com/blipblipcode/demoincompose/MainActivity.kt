package com.blipblipcode.demoincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.blipblipcode.demoincompose.ui.controls.*
import com.blipblipcode.demoincompose.ui.theme.DemoInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoInComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Green),
                    color = MaterialTheme.colorScheme.background
                ) {

                    ShellPage3()


                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    DemoInComposeTheme {
        Box() {
            Label("BlipBlip")

        }
    }
}