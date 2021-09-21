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
package com.example.androiddevchallenge.navigation

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.PetsDummyViewModelFactory
import com.example.androiddevchallenge.PetsViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.Pet
import com.example.androiddevchallenge.view.Home
import com.example.androiddevchallenge.view.PetDetails
import com.google.gson.Gson

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Home : Screen("homeScreen", R.string.home_screen)
    object PetDetails : Screen("petDetails", R.string.pet_details_screen)
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            val viewModel = viewModel(
                modelClass = PetsViewModel::class.java,
                factory = PetsDummyViewModelFactory()
            )
            Home(
                breeds = viewModel.breeds,
                onChangeBreed = viewModel::onBreedChange,
                onPetClick = {
                    navController.navigate(route = "${Screen.PetDetails.route}/${it.toJson()}") {
                        popUpTo = navController.graph.startDestination
                        launchSingleTop = true
                    }
                },
                pets = viewModel.pets
            )
        }
        composable(
            "${Screen.PetDetails.route}/{pet}"
        ) {
            it.arguments?.getString("pet")?.let { json ->
                PetDetails(Gson().fromJson(json, Pet::class.java))
            }
        }
    }
}

fun Pet.toJson(): String {
    return Gson().toJson(this)
}
