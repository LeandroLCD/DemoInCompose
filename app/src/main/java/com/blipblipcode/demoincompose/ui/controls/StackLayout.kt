package com.blipblipcode.demoincompose.ui.controls

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.blipblipcode.demoincompose.ui.theme.DemoInComposeTheme


@Composable
fun StackLayoutVertical() {

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Green),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(Modifier.background(Color.Black)) {
            Text("Hola")
        }
        Box(Modifier.background(Color.Red)) {
            Text("Hola")
        }
        Box(Modifier.background(Color.Blue)) {
            Text("Hola")
        }
    }


}

@Composable
fun StackLayoutHorizontal() {
    Row(
        Modifier
            .fillMaxWidth(0.5f)
            .background(Color.Yellow)
            .height(50.dp)
            .horizontalScroll(
                ScrollState(0)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(30.dp)
    )
    {
        repeat(5) {
            Box(Modifier.background(Color.Black)) {
                Text("Hola $it")
            }
            Box(Modifier.background(Color.Red)) {
                Text("Hola $it")
            }
            Box(Modifier.background(Color.Blue)) {
                Text("Hola $it")
            }
        }

    }
}

@Composable
fun GridWithColumnRow(column: Int, row: Int) {
    Column {
        repeat(row) { r ->
            Row {
                repeat(column) { c ->

                    Text("[C $c / r $r]")
                }
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StackLayoutPreview() {
    DemoInComposeTheme {
        StackLayoutHorizontal()
        StackLayoutVertical()
    }
}