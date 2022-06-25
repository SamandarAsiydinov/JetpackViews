package com.example.jetpackviews.shopping.model

import androidx.annotation.DrawableRes

data class Product(
    val title: String,
    val price: String,
    val desc: String,
    val size: String,
    @DrawableRes val image: Int
)
