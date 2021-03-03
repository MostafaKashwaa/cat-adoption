package com.example.androiddevchallenge.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.domain.Pet

@Composable
fun PetsViewer(
    pets: List<Pet>,
    onPetClick: (Pet) -> Unit
) {
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.padding(horizontal = 12.dp)) {
            Text(text = "Available for adoption")
            Spacer(modifier = Modifier.padding(bottom = 8.dp))
            LazyColumn {
                items(pets) { pet ->
                    PetCard(pet = pet, onClick = onPetClick)
                    Spacer(modifier = Modifier.padding(bottom = 8.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun PetsViewerPreview() {
    PetsViewer(
        pets = listOf(
            Pet("Shicko", "https://cdn2.thecatapi.com/images/CDhOtM-Ig.jpg", "Himalayan"),
            Pet("Shadow", "", "Himalayan"),
            Pet("Milo", "", "Himalayan")
        ),
        onPetClick = {  }
    )
}