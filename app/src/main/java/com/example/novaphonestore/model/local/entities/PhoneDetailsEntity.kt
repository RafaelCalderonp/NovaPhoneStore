package com.example.novaphonestore.model.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "phone_details_table")
data class PhoneDetailsEntity (
    @PrimaryKey
    @NotNull
    val id: Int,
    val name: String,
    val price: Int,
    val image: String,
    val description: String,
    val lastPrice: Int,
    val credit: Boolean
)
