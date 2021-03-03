package com.example.androiddevchallenge.repos

import com.example.androiddevchallenge.domain.Breed
import com.example.androiddevchallenge.domain.Pet

interface PetsRepository {
    fun getAllBreeds(): List<Breed>
    fun getAllPets(): List<Pet>
    fun getPetsByBreed(breed: Breed): List<Pet>
    fun getPetDetails(petId: String): Pet
}