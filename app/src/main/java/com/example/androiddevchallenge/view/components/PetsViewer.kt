/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
        onPetClick = { }
    )
}
