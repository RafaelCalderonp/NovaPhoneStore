package com.example.novaphonestore.model.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "phone_list_table")
data class PhoneEntity  (
    @PrimaryKey
    @NotNull
    val id: Int,
    val image: String,
    val name: String,
    val price: Int
)