package com.example.androiddevchallenge.domain

import com.google.gson.Gson


data class Pet(val name: String, val imageUrl: String, val breed: String) {
    override fun toString(): String {
        return Gson().toJson(this)
    }
}