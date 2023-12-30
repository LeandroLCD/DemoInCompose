package com.blipblipcode.demoincompose.ui.controls

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.blipblipcode.demoincompose.R
import com.blipblipcode.demoincompose.ui.theme.DemoInComposeTheme

@Composable
fun MyIcons() {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Icon(painterResource(id = R.drawable.done), null)
        Spacer(modifier = Modifier.height(20.dp))
        Icon(
            painterResource(id = R.drawable.done_xml), null,
            modifier = Modifier.size(20.dp), tint = Color.Blue
        )
        Spacer(modifier = Modifier.height(20.dp))
        Icon(imageVector = Icons.Filled.Favorite, contentDescription = null, tint = Color.Red)
        Spacer(modifier = Modifier.height(20.dp))
        IconButton(onClick = { Toast.makeText(context, "IconButton", Toast.LENGTH_LONG).show() }) {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = null,
                tint = Color.Blue
            )
        }
        val isChecked = remember {
            mutableStateOf(false)
        }
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable {
                isChecked.value = !isChecked.value
            }) {


            FilledIconToggleButton(checked = isChecked.value,
                shape = RoundedCornerShape(10.dp),
                colors = IconButtonDefaults.iconToggleButtonColors(

                ),
                onCheckedChange = {
                    isChecked.value = !isChecked.value
                }) {

                if (isChecked.value) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = null,
                        tint = Color.Red
                    )

                } else {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null, tint = Color.Black
                    )

                }
            }
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "Favorite")
        }

        LeadingIconTab(
            selected = isChecked.value,
            onClick = {
                isChecked.value = !isChecked.value
            },
            text = {
                Text("Favorite")
            },
            icon = {
                if (isChecked.value) {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = null,
                        tint = Color.Red
                    )

                } else {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null, tint = Color.Black
                    )
                }
            })


    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun IconsPreview() {
    DemoInComposeTheme {
        Box {
            MyIcons()
        }
    }
}