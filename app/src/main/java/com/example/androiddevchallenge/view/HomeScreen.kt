package com.example.androiddevchallenge.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.domain.Breed
import com.example.androiddevchallenge.domain.Pet
import com.example.androiddevchallenge.view.components.BreedsViewer
import com.example.androiddevchallenge.view.components.PetsViewer


@Composable
fun Home(
    breeds: List<Breed>,
    onChangeBreed: (Breed) -> Unit = {},
    pets: List<Pet>,
    onPetClick: (Pet) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxSize()
    ) {
        BreedsViewer(breeds, onChangeBreed)
        Spacer(modifier = Modifier.padding(vertical = 16.dp))
        PetsViewer(pets, onPetClick)

    }
}


