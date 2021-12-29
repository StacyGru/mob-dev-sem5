package com.example.a10greatpersons

import androidx.annotation.DrawableRes

data class Person (
    @DrawableRes val photo: Int,
    val name: String,
    val years_of_life: String,
    val description: String,
    val gender: String
)