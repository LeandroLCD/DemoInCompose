package com.blipblipcode.demoincompose.ui.controls

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.blipblipcode.demoincompose.ui.theme.DemoInComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyEntrys() {

    val name = remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    val isVisible = remember {
        mutableStateOf(true)
    }




    Column {
        BasicTextField(value = name.value,
            modifier = Modifier
                .background(Color.Cyan)
                .height(30.dp),
            onValueChange = {
                name.value = it
            })
        Spacer(modifier = Modifier.height(30.dp))

        TextField(
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Red,
                disabledLabelColor = Color.Gray,
                errorBorderColor = Color.Red,
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Yellow
            ),
            value = name.value,
            onValueChange = {
                name.value = it
            },
        )

        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(value = name.value, label = {
            Text(text = "Password")
        }, leadingIcon = {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
        }, trailingIcon = {
            Icon(imageVector = Icons.Default.Lock,
                contentDescription = null,
                modifier = Modifier.clickable {

                    isVisible.value = !isVisible.value

                })
        }, onValueChange = {
            name.value = it
        },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Go,
                keyboardType = KeyboardType.Email
            ),
            keyboardActions = KeyboardActions(onGo = {
                Toast.makeText(context, "Hola ${name.value}", Toast.LENGTH_LONG).show()
            }),
            visualTransformation = if (isVisible.value) PasswordVisualTransformation('*')
            else VisualTransformation.None,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.Red,
                disabledLabelColor = Color.Gray,
                errorBorderColor = Color.Red,
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Yellow
            )


        )


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ButtonPreview() {
    DemoInComposeTheme {
        Box() {
            MyEntrys()
        }
    }
}