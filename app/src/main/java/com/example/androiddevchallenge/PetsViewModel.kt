package com.example.androiddevchallenge

import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androiddevchallenge.domain.Breed
import com.example.androiddevchallenge.domain.Pet
import com.example.androiddevchallenge.repos.PetDummyRepository
import com.example.androiddevchallenge.repos.PetsRepository

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
class PetsDummyViewModelFactory(): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PetsViewModel(PetDummyRepository.getInstance()) as T
    }
}