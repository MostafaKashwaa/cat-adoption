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

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.example.androiddevchallenge.R
import com.kashwaa.shared.domain.Breed
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun BreedsViewer(
    breeds: List<Breed>,
    onChangeBreed: (Breed) -> Unit
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        elevation = 32.dp
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Breeds")
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "")
            }
            BreedsRow(breeds = breeds, onChangeBreed = onChangeBreed)
        }
    }
}

@Composable
private fun BreedsRow(
    breeds: List<Breed>,
    onChangeBreed: (Breed) -> Unit
) {
    var selectedBreed by remember { mutableStateOf(-1) }
    LazyRow {
        item {
            BreedItem(
                breed = Breed.defaultBreed,
                selected = selectedBreed == -1,
                onClick = {
                    selectedBreed = -1
                    onChangeBreed(Breed.defaultBreed)
                }
            )
            Spacer(modifier = Modifier.padding(end = 8.dp))
        }
        itemsIndexed(breeds) { index, breed ->
            BreedItem(
                breed,
                selected = selectedBreed == index,
                onClick = {
                    selectedBreed = index
                    onChangeBreed(it)
                }
            )
            Spacer(modifier = Modifier.padding(end = 8.dp))
        }
    }
}

@Composable
private fun BreedItem(
    breed: Breed,
    selected: Boolean = false,
    onClick: (Breed) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .clickable {
                onClick(breed)
            }
    ) {
        BreedImage(
            imageUrl = breed.imageUrl,
            selected = selected,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        if (selected) {
            Text(
                text = breed.name,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        } else {
            Spacer(modifier = Modifier.height(21.dp))
        }
    }
}

@Composable
fun BreedImage(imageUrl: String, selected: Boolean, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        if (imageUrl.isBlank()) {
            Image(
                painter = painterResource(id = R.drawable.cat),
                contentDescription = "default cat image",
                modifier = Modifier
                    .border(
                        width = if (selected) 3.dp else 0.dp,
                        color = MaterialTheme.colors.secondaryVariant,
                        shape = RoundedCornerShape(50)
                    )
                    .clip(RoundedCornerShape(50))
                    .height(65.dp)
            )
        } else {
            CoilImage(
                data = imageUrl,
                contentScale = ContentScale.Inside,
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .height(65.dp)
                    .border(
                        width = if (selected) 5.dp else 0.dp,
                        color = MaterialTheme.colors.secondaryVariant,
                        shape = RoundedCornerShape(50)
                    ),
                requestBuilder = {
                    transformations(CircleCropTransformation())
                },
                loading = {
                    Box(Modifier.matchParentSize()) {
                        CircularProgressIndicator(
                            Modifier.align(Alignment.Center),
                            strokeWidth = 2.dp,
                            color = MaterialTheme.colors.secondaryVariant
                        )
                    }
                }
            )
        }
    }
}
