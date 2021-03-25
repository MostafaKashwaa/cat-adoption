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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.kashwaa.shared.domain.Pet
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PetCard(
    pet: Pet,
    onClick: (Pet) -> Unit = {}
) {
    Card(
        elevation = 8.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick(pet) }
                .padding(horizontal = 8.dp, vertical = 12.dp)
        ) {
            CoilImage(
                data = pet.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.33f)
                    .align(Alignment.CenterVertically)
                    .clip(RoundedCornerShape(50)),
                requestBuilder = {
                    transformations(CircleCropTransformation())
                },
                contentScale = ContentScale.Fit,
                loading = {
                    Box(Modifier.matchParentSize()) {
                        CircularProgressIndicator(Modifier.align(Alignment.Center))
                    }
                }
            )

            Column(
                Modifier
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = pet.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    style = MaterialTheme.typography.h5
                )
                Text(
                    text = pet.breed,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}
