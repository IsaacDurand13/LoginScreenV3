package com.example.loginscreenv3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Label
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun FeedScreen() {

    val itemsList = listOf(
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 5"
    )

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
        LazyColumn(modifier = Modifier.fillMaxSize(),) {
            items(itemsList) { item ->
                FeedItem(item = item)
            }
        }
    }

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()) {
        Box(modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()){
            Text(text = "Feed de desafios...",
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(bottom = 16.dp),
                style = TextStyle(fontSize = 24.sp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedItem(item: String) {

    var userName = "Apelido"
    var time = "8:38"
    var imageResId = R.drawable.glass_of_water
    var description = "Lorem ipsum dolor sit amet. Aut quia dolore in temporibus repellendus rem quidem possimus quo aspernatur doloribus in nihil unde qui sint dignissimos."

    Spacer(modifier = Modifier.height(30.dp))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Seção do usuário e hora
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = userName, style = MaterialTheme.typography.bodyMedium)
            Text(text = time, style = MaterialTheme.typography.bodySmall)
        }



        // Seção da imagem
        Image(
            painter = painterResource(imageResId),
            contentDescription = "Imagem do post",
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Seção da descrição
        Text(
            text = description,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FeedScreenPreview() {
    FeedScreen()
}

