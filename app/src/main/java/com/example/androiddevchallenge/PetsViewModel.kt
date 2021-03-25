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
package com.example.androiddevchallenge

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kashwaa.shared.domain.Breed
import com.kashwaa.shared.domain.Pet
import com.kashwaa.shared.repos.PetDummyRepository
import com.kashwaa.shared.repos.PetsRepository

class PetsViewModel(private val petsRepository: PetsRepository) : ViewModel() {

    var breeds: List<Breed> by mutableStateOf(petsRepository.getAllBreeds())
        private set

    var pets: List<Pet> by mutableStateOf(petsRepository.getAllPets())
        private set

    fun onBreedChange(breed: Breed) {
        pets = petsRepository.getPetsByBreed(breed)
    }
}

@Suppress("UNCHECKED_CAST")
class PetsDummyViewModelFactory() : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PetsViewModel(PetDummyRepository) as T
    }
}
