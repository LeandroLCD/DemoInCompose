package com.blipblipcode.demoincompose.ui.controls

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.blipblipcode.demoincompose.ui.theme.DemoInComposeTheme

@Composable
fun CollectionView() { // RecyclerView

    val list = mutableListOf("")
    repeat(200) { number ->
        list.add(number, "Empleado # $number")   // $"Empleado {it}"
    }
    //LazyRow
    LazyColumn(modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)) {


        items(list) { empleado ->
           Card(shape = RoundedCornerShape(10.dp),
               colors = CardDefaults.cardColors(containerColor = Color.Yellow,
                   contentColor = Color.Magenta ),
               modifier = Modifier
                   .height(60.dp)
                   .fillMaxWidth()) {
               Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){

                   Text(text = empleado)
               }
           }
        }


    }
}

@Composable
fun CollectionViewGrid(){
    val list = mutableListOf("")
    repeat(200) { number ->
        list.add(number, "Empleado # $number")   // $"Empleado {it}"
    }
    LazyHorizontalGrid(rows = GridCells.Fixed(4),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)){
        items(list) { empleado ->
            Card(shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Yellow,
                    contentColor = Color.Magenta ),
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth()) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){

                    Text(text = empleado)
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CollectionViewPreview() {
    DemoInComposeTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            CollectionViewGrid()
        }
    }
}