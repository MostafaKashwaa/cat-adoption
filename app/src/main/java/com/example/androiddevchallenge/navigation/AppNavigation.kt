package com.example.androiddevchallenge.navigation

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.PetsDummyViewModelFactory
import com.example.androiddevchallenge.PetsViewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.domain.Breed
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
                    navController.navigate(route = "${Screen.PetDetails.route}/${it}") {
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
            Log.i("Navigator", "AppNavHost: ${it.arguments?.getString("pet")}")
            it.arguments?.getString("pet")?.let { json ->
                PetDetails(Gson().fromJson(json, Pet::class.java))
            }
        }
    }
}