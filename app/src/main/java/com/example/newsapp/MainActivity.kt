@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    var value by remember { mutableStateOf("") }
    var selectedTab by remember { mutableStateOf("Noticias") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Barra de búsqueda
        OutlinedTextField(
            value = value,
            onValueChange = { value = it },
            placeholder = { Text(text = "Buscar") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = ""
                )
            },
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(56.dp),
            shape = RoundedCornerShape(30.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tabs
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TabItem("Noticias", selectedTab) { selectedTab = "Noticias" }
            TabItem("Eventos", selectedTab) { selectedTab = "Eventos" }
            TabItem("Clima", selectedTab) { selectedTab = "Clima" }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Título "Últimas Noticias"
        Text(
            text = "Últimas Noticias",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 10.dp, bottom = 20.dp)
        )

        // Scroll horizontal con tarjetas azules
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 10.dp)
        ) {
            items(4) {
                NewsCard()
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Título "Alrededor del Mundo"
        Text(
            text = "Alrededor del Mundo",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 10.dp, bottom = 25.dp)
        )

        // Cuadrícula 2x2
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                WorldCard("Noticia 1")
                WorldCard("Noticia 2")
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                WorldCard("Noticia 3")
                WorldCard("Noticia 4")
            }
        }
    }
}

@Composable
fun TabItem(
    title: String,
    selectedTab: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = if (selectedTab == title) Color.Blue else Color.Gray
        )
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .height(3.dp)
                .width(40.dp)
                .background(
                    if (selectedTab == title) Color.Blue else Color.Transparent,
                    shape = RoundedCornerShape(2.dp)
                )
        )
    }
}

@Composable
fun NewsCard() {
    Box(
        modifier = Modifier
            .width(220.dp)
            .height(140.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFF9269FA))
            .padding(12.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "El presidente de EE.UU. no muestra signos de arrepentimiento...",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                maxLines = 3
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "febrero 08-2024",
                color = Color.White.copy(alpha = 0.9f),
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun WorldCard(text: String) {
    Box(
        modifier = Modifier
            .width(185.dp)
            .height(185.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFDAD7D7)) // gris claro
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 16.sp
        )
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    NewsAppTheme {
        HomeScreen()
    }
}
