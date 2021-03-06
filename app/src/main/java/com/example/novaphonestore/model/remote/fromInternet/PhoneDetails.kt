package com.example.novaphonestore.model.remote.fromInternet

data class PhoneDetails(
    val credit: Boolean,
    val description: String,
    val id: Int,
    val image: String,
    val lastPrice: Int,
    val name: String,
    val price: Int
)