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
package com.example.androiddevchallenge.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.transform.RoundedCornersTransformation
import com.example.androiddevchallenge.domain.Pet
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PetDetails(pet: Pet?) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        pet?.let {
            CoilImage(
                data = it.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .clip(RoundedCornerShape(22.0f)),
                requestBuilder = {
                    transformations(RoundedCornersTransformation(8.0f))
                },
                contentScale = ContentScale.FillHeight,
                loading = {
                    Box(Modifier.matchParentSize()) {
                        CircularProgressIndicator(Modifier.align(Alignment.Center))
                    }
                }
            )
            Spacer(modifier = Modifier.padding(bottom = 8.dp))
            Row {
                Text(
                    text = it.name,
                    fontSize = 32.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    imageVector = Icons.Default.Female, contentDescription = "Female cat",
                    Modifier
                        .align(
                            Alignment.CenterVertically
                        )
                        .scale(1.4f)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                DetailsCard(title = "Breed", text = it.breed, percent = 0.25f)
                DetailsCard(title = "Age", text = "4 Years", percent = 0.33f)
                DetailsCard(title = "Size", text = "Big", percent = 0.50f)
                DetailsCard(title = "Color", text = "Black", percent = 1f, false)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Status", fontWeight = FontWeight.Black)
            Text(text = "Adoptable", fontWeight = FontWeight.Light)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "About", fontWeight = FontWeight.Black)
            Text(text = "About the cat goes here...", fontWeight = FontWeight.Light)
        }
    }
}

@Composable
fun DetailsCard(title: String, text: String, percent: Float, divider: Boolean = true) {
    Row(
        modifier = Modifier
            .fillMaxWidth(percent),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(Modifier.fillMaxWidth(0.825f)) {
            Text(text = title, modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.Black, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = text,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Light
            )
        }
        if (divider) VerticalDivider()
    }
}

@Composable
fun VerticalDivider() {
    Divider(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .width(1.dp)
            .fillMaxHeight(),
        color = Color.Gray
    )
}
