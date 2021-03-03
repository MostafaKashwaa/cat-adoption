package com.example.androiddevchallenge.domain

data class Breed(
    val id: String,
    val name: String,
    val imageUrl: String,
    val childFriendly: Int = -1,
    val dogFriendly: Int = -1,
    val strangerFriendly: Int = -1,
) {
    companion object {
        val defaultBreed = Breed("All","All", "")
    }

}