package com.blipblipcode.demoincompose.ui.controls

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
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


    val brush = Brush.horizontalGradient(colorStops = colorStops)
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
            Box(Modifier.background(brush), contentAlignment = Alignment.Center){
                Text(text = "Click")
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        GradientOutlinedButton(onClick = {
            Toast.makeText(context, "GradientButton on Click", Toast.LENGTH_LONG).show()
        },
            modifier = Modifier,
            gradient = brush){
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

@Composable
fun GradientOutlinedButton(
    onClick: () -> Unit = { },
    gradient : Brush,
    modifier: Modifier = Modifier,
    shape: Shape = ButtonDefaults.outlinedShape,
    colors:ButtonColors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
    elevation: ButtonElevation? = null,
    border: BorderStroke? = ButtonDefaults.outlinedButtonBorder,
    content: @Composable RowScope.() -> Unit
) {
    OutlinedButton(
        modifier = modifier,
        shape = shape,
        colors = colors,
        contentPadding = PaddingValues(0.dp),
        elevation = elevation,
        border = border,
        onClick = { onClick() },
    ) {
        Box(
            modifier = Modifier

                .then(modifier).defaultMinSize(
                    minWidth = ButtonDefaults.MinWidth,
                    minHeight = ButtonDefaults.MinHeight

                )
                .background(gradient)
                .padding(ButtonDefaults.ContentPadding),
            contentAlignment = Alignment.Center,
        ) { content }
    }
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