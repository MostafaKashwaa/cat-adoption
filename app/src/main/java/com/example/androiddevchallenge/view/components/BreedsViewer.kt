package com.example.androiddevchallenge.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.Breed
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
                })
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
    Column(modifier = Modifier
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
