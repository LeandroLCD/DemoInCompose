package com.blipblipcode.demoincompose.ui.controls

import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.blipblipcode.demoincompose.ui.theme.DemoInComposeTheme

@Composable
fun Label(text: String, modifier: Modifier = Modifier) {
    //$"Hello {text}!"
    Text(
        text = "Hola estas en $text Studio!",
        modifier = modifier
            .background(Color.Red)
            .horizontalScroll(ScrollState(0)),
        color = Color.Blue,
        fontSize = 30.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.W900,
        fontFamily = FontFamily.Default,
        letterSpacing = 10.sp,
        textAlign = TextAlign.Justify,
        lineHeight = 100.sp,
        maxLines = 1,
        onTextLayout = {
            val textWidth = it.size
            Log.d("compose", "width: ${textWidth.width}")
            Log.d("compose", "height: ${textWidth.height}")
        }

    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LabelPreview() {
    DemoInComposeTheme {
        Box() {
            Label("Android")

        }
    }
}