package com.f8fit.mycrud_i.home

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val price: Double
)