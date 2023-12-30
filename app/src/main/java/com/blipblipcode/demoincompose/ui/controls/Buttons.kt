package com.blipblipcode.demoincompose.ui.controls

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.blipblipcode.demoincompose.ui.theme.DemoInComposeTheme

@Composable
fun MyButtons(){
    val context = LocalContext.current
    val colorStops = arrayOf(
        0.0f to Color.Yellow,
        0.5f to Color.Red,
        1f to Color.Blue
    )
    Column {
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            Toast.makeText(context, "Button on Click", Toast.LENGTH_LONG).show()
        }, shape = RoundedCornerShape(10.dp), modifier = Modifier.size(100.dp)) {
            Text(text = "Click")
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(onClick = {
            Toast.makeText(context, "OutlinedButton on Click", Toast.LENGTH_LONG).show()
        }, colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent
        )
        ) {
            Text(text = "Click")
        }
        Spacer(modifier = Modifier.height(20.dp))


        ElevatedButton(onClick = {
            Toast.makeText(context, "ElevatedButton on Click", Toast.LENGTH_LONG).show()
        },
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 20.dp,
                disabledElevation = 0.dp,
                pressedElevation = 8.dp,
                focusedElevation = 25.dp
            ),
            border = BorderStroke(4.dp, Brush.verticalGradient(colorStops = colorStops
               ))
        ) {
            Text(text = "Click")
        }
    }
    /*FloatingActionButton(onClick = {
        Toast.makeText(context, "ExtendedFloatingActionButton on Click", Toast.LENGTH_LONG).show()

    }) {
        Text(text = "Click")
    }*/




}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ButtonsPreview() {
    DemoInComposeTheme {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            MyButtons()
        }
    }
}