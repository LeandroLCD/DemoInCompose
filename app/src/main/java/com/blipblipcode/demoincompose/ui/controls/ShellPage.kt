package com.blipblipcode.demoincompose.ui.controls

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomDrawer
import androidx.compose.material.BottomDrawerValue
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberBottomDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.xavijimenezmulet.shapes.geometry.CircularShape
import com.xavijimenezmulet.shapes.programming.AndroidShape
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun ShellPage3(){
val shape = CustomShape()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        Card(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.8f)
                .clip(AndroidShape)) {
            Column {

                LeadingIconTab(
                    selected = true,
                    onClick = { scope.launch {
                        drawerState.close()
                    } },
                    text = { Text(text = "Home") },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") })
                LeadingIconTab(
                    selected = false,
                    onClick = { },
                    text = { Text(text = "Profile") },
                    icon = { Icon(Icons.Default.Person, contentDescription = "Home") })
                LeadingIconTab(
                    selected = false,
                    onClick = { },
                    text = { Text(text = "Setting") },
                    icon = { Icon(Icons.Default.Settings, contentDescription = "Home") })
            }
        }
    }) {
        val isVisible = rememberBottomDrawerState(initialValue = BottomDrawerValue.Closed )
        val selected = remember {
            mutableStateOf(0)
        }
        Scaffold(
            snackbarHost = { SnackbarHost(snackbarHostState) },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    scope.launch {
                       /* snackbarHostState.showSnackbar(
                            "Snackbar "
                        )*/
                        isVisible.open()
                    }
                }) {
                    Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null)
                }
            },
            floatingActionButtonPosition = FabPosition.End,

            bottomBar = {
                MyButtonBar3(selected = selected.value) {
                    selected.value = it
                }
            },

            ) {
            Box(modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color.Magenta)){

            }
        }

            BottomDrawer(drawerState = isVisible , drawerContent = {
                Column {

                    LeadingIconTab(
                        selected = true,
                        onClick = { scope.launch {
                            drawerState.close()
                            isVisible.close()
                        } },
                        text = { Text(text = "Home") },
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home") })
                    LeadingIconTab(
                        selected = false,
                        onClick = { },
                        text = { Text(text = "Profile") },
                        icon = { Icon(Icons.Default.Person, contentDescription = "Home") })
                    LeadingIconTab(
                        selected = false,
                        onClick = { },
                        text = { Text(text = "Setting") },
                        icon = { Icon(Icons.Default.Settings, contentDescription = "Home") })
                }
            }){

            }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShellPage(){
    val shape = CustomShape()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()


        val selected = remember {
            mutableStateOf(0)
        }
        androidx.compose.material.Scaffold(

            drawerContent = {
                Card(
                    Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.8f)
                        .clip(AndroidShape)) {
                    Column {

                        LeadingIconTab(
                            selected = true,
                            onClick = { scope.launch {
                                scaffoldState.drawerState.close()
                            } },
                            text = { Text(text = "Home") },
                            icon = { Icon(Icons.Default.Home, contentDescription = "Home") })
                        LeadingIconTab(
                            selected = false,
                            onClick = { scope.launch {
                                scaffoldState.drawerState.close()
                            }},
                            text = { Text(text = "Profile") },
                            icon = { Icon(Icons.Default.Person, contentDescription = "Home") })
                        LeadingIconTab(
                            selected = false,
                            onClick = { scope.launch {
                                scaffoldState.drawerState.close()
                            }},
                            text = { Text(text = "Setting") },
                            icon = { Icon(Icons.Default.Settings, contentDescription = "Home") })
                    }
                }
            }, scaffoldState = scaffoldState,
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            "Snackbar "
                        )
                    }
                }, shape = CircularShape) {
                    Icon(imageVector = Icons.Default.PlayArrow, contentDescription = null)
                }
            },
            floatingActionButtonPosition = androidx.compose.material.FabPosition.Center,
            isFloatingActionButtonDocked = true,
            bottomBar = {
                MyButtonBar(selected = selected.value) {
                    selected.value = it
                }
            },

            ) {
            Box(modifier = Modifier
                .padding(top = it.calculateTopPadding(), end = 0.dp)
                .fillMaxSize()
                .background(Color.Cyan)){

            }
        }

}
@Composable
fun MyButtonBar3(selected: Int, onClickSelect: (Int) -> Unit) {

    BottomAppBar(
        tonalElevation = 10.dp,
        contentPadding = PaddingValues(0.dp),
       modifier = Modifier
           .height(50.dp)
           .background(Color.Transparent)
    ) {
        NavigationBarItem(selected = selected == 0, onClick = { onClickSelect(0) }, icon = {

            val color = if (selected == 0) Color.White else Color.Black
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home", tint = color)
        },
            //label = { Text(text = "Home")}
            )
        /* NavigationBarItem(selected = selected == 1, onClick = { onClickSelect(1) }, icon = {
             var color = if (selected == 1) Color.White else Color.Black
             Icon(imageVector = Icons.Default.Details, contentDescription = null, tint = color)
         })*/
        NavigationBarItem(selected = selected == 2, onClick = { onClickSelect(2) }, icon = {
            val color = if (selected == 2) Color.White else Color.Black
            Icon(imageVector = Icons.Default.Call, contentDescription = null, tint = color)
        })
    }
}

@Composable
fun MyButtonBar(selected: Int, onClickSelect: (Int) -> Unit) {

    androidx.compose.material.BottomAppBar(
        elevation = 10.dp,
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.height(50.dp),
        cutoutShape = CircleShape
    ) {

        NavigationBarItem(selected = selected == 0, onClick = { onClickSelect(0) }, icon = {

            val color = if (selected == 0) Color.White else Color.Black
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home", tint = color)
        },
            //label = { Text(text = "Home")}
        )
        /* NavigationBarItem(selected = selected == 1, onClick = { onClickSelect(1) }, icon = {
             var color = if (selected == 1) Color.White else Color.Black
             Icon(imageVector = Icons.Default.Details, contentDescription = null, tint = color)
         })*/
        NavigationBarItem(selected = selected == 2, onClick = { onClickSelect(2) }, icon = {
            val color = if (selected == 2) Color.White else Color.Black
            Icon(imageVector = Icons.Default.Call, contentDescription = null, tint = color)
        })
    }
}


class CustomShape : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): androidx.compose.ui.graphics.Outline {
        val path = Path().apply {
            moveTo(size.width / 2f, 0f)
            lineTo(size.width, size.height)
            lineTo(0f, size.height)
            close()
        }
        return androidx.compose.ui.graphics.Outline.Generic(path)
    }
}