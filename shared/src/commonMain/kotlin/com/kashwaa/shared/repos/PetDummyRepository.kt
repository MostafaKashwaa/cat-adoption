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
package com.kashwaa.shared.repos

import com.kashwaa.shared.domain.Breed
import com.kashwaa.shared.domain.Pet

object PetDummyRepository : PetsRepository {
//    companion object {
//        private var instance: PetDummyRepository? = null
//        fun getInstance(): PetDummyRepository {
//            if (instance == null) {
//                synchronized(this) {
//                    if (instance == null)
//                        instance = PetDummyRepository()
//                }
//            }
//            return instance!!
//        }
//    }

    override fun getAllBreeds(): List<Breed> {
        return listOf(
            Breed("ctif", "Chantilly Tiffany", "https://cdn2.thecatapi.com/images/TR-5nAd_S.jpg"),
            Breed("hima", "Himalayan", "https://cdn2.thecatapi.com/images/CDhOtM-Ig.jpg"),
            Breed("char", "Chartreux", "https://cdn2.thecatapi.com/images/j6oFGLpRG.jpg"),
            Breed("cymr", "Cymric", "https://cdn2.thecatapi.com/images/3dbtapCWM.jpg"),
            Breed("lihu", "Dragon Li", "https://cdn2.thecatapi.com/images/BQMSld0A0.jpg"),
            Breed("jbob", "Japanese Bobtail", "https://cdn2.thecatapi.com/images/-tm9-znzl.jpg"),
            Breed("esho", "Exotic Shorthair", "https://cdn2.thecatapi.com/images/YnPrYEmfe.jpg"),
            Breed("tang", "Turkish Angora", "https://cdn2.thecatapi.com/images/7CGV6WVXq.jpg"),
        )
    }

    override fun getAllPets(): List<Pet> {
        return dummyPets
    }

    override fun getPetsByBreed(breed: Breed): List<Pet> {
        return if (breed == Breed.defaultBreed)
            dummyPets
        else
            dummyPets.filter { it.breed == breed.name }
    }

    override fun getPetDetails(petId: String): Pet {
        return Pet("Black tiger", "https://cdn2.thecatapi.com/images/E4j4aBDx9.jpg", "Chantilly Tiffany")
    }

    val dummyPets = listOf(
        // Chantilly-Tiffany
        Pet("Charlie", "https://cdn2.thecatapi.com/images/E4j4aBDx9.jpg", "Chantilly Tiffany"),
        Pet("Milo", "https://cdn2.thecatapi.com/images/INXwfT_cp.jpg", "Chantilly Tiffany"),
        Pet("Simba", "https://cdn2.thecatapi.com/images/TR-5nAd_S.jpg", "Chantilly Tiffany"),
        Pet("Ziggy", "https://cdn2.thecatapi.com/images/XAvnPwmqZ.jpg", "Chantilly Tiffany"),
        // Himalayan
        Pet("Shadow", "https://cdn2.thecatapi.com/images/kg7nc0poR.jpg", "Himalayan"),
        Pet("Lucy", "https://cdn2.thecatapi.com/images/rYChTf8ab.jpg", "Himalayan"),
        Pet("Sophie", "https://cdn2.thecatapi.com/images/L7z8fLkoJ.jpg", "Himalayan"),
        Pet("Izzy", "https://cdn2.thecatapi.com/images/Rx_gYvR2e.jpg", "Himalayan"),
        Pet("Daisy", "https://cdn2.thecatapi.com/images/hYG6uIRWL.jpg", "Himalayan"),
        // Chartreux
        Pet("Loki", "https://cdn2.thecatapi.com/images/iY76694gN.jpg", "Chartreux"),
        Pet("Shicko", "https://cdn2.thecatapi.com/images/OUZlUVIco.jpg", "Chartreux"),
        Pet("Cooper", "https://cdn2.thecatapi.com/images/EYtB_5RrB.jpg", "Chartreux"),
        Pet("Missy", "https://cdn2.thecatapi.com/images/K3eHRIQXM.jpg", "Chartreux"),
        // Cymric
        Pet("Tiger", "https://cdn2.thecatapi.com/images/3dbtapCWM.jpg", "Cymric"),
        Pet("Lulu", "https://cdn2.thecatapi.com/images/WXcD6qZEn.jpg", "Cymric"),
        Pet("Pepper", "https://cdn2.thecatapi.com/images/OLP-tyC2i.jpg", "Cymric"),
        Pet("Jasmine", "https://cdn2.thecatapi.com/images/GQ61BDToD.jpg", "Cymric"),
        Pet("Fiona", "https://cdn2.thecatapi.com/images/CKVhCI0bz.jpg", "Cymric"),
        // Dragon Li
        Pet("Romeo", "https://cdn2.thecatapi.com/images/DUxU01IY5.jpg", "Dragon Li"),
        Pet("Millie", "https://cdn2.thecatapi.com/images/KrDYENsA3.jpg", "Dragon Li"),
        Pet("Abby", "https://cdn2.thecatapi.com/images/BQMSld0A0.jpg", "Dragon Li"),
        Pet("Frank", "https://cdn2.thecatapi.com/images/POPfuPq8t.jpg", "Dragon Li"),
        Pet("Oscar", "https://cdn2.thecatapi.com/images/mjeF1hs8v.jpg", "Dragon Li"),
        //  Japanese Bobtail
        Pet("Minnie", "https://cdn2.thecatapi.com/images/StMwZZnDP.jpg", "Japanese Bobtail"),
        Pet("Athena", "https://cdn2.thecatapi.com/images/Sw_EWWLW-.jpg", "Japanese Bobtail"),
        Pet("Olivia", "https://cdn2.thecatapi.com/images/d8AjzQxLp.jpg", "Japanese Bobtail"),
        Pet("Ruby", "https://cdn2.thecatapi.com/images/RfdGhgEf3.jpg", "Japanese Bobtail"),
        Pet("Olivia", "https://cdn2.thecatapi.com/images/CrZtoDsgj.jpg", "Japanese Bobtail"),
        // Exotic Shorthair
        Pet("Coco", "https://cdn2.thecatapi.com/images/cw18Op1Ok.jpg", "Exotic Shorthair"),
        Pet("Pumpkin", "https://cdn2.thecatapi.com/images/y61B6bFCh.jpg", "Exotic Shorthair"),
        Pet("Harley", "https://cdn2.thecatapi.com/images/dnYQq6Vf3.jpg", "Exotic Shorthair"),
        Pet("Bob", "https://cdn2.thecatapi.com/images/Jxl7eRfCW.jpg", "Exotic Shorthair"),
        Pet("Bear", "https://cdn2.thecatapi.com/images/EEf-L2ubj.jpg", "Exotic Shorthair"),
        // Turkish Angora
        Pet("Mimi", "https://cdn2.thecatapi.com/images/41Fe8q9vU.jpg", "Turkish Angora"),
        Pet("Annie", "https://cdn2.thecatapi.com/images/y3l3iYWa4.jpg", "Turkish Angora"),
        Pet("Sunny", "https://cdn2.thecatapi.com/images/c1OwKLEdL.jpg", "Turkish Angora"),
        Pet("Riley", "https://cdn2.thecatapi.com/images/Ak9enJjbC.jpg", "Turkish Angora"),
        Pet("Walter", "https://cdn2.thecatapi.com/images/GlwgzUMan.jpg", "Turkish Angora"),
    )
}
