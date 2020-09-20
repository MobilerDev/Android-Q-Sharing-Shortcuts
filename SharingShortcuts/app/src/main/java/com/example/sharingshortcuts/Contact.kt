package com.example.sharingshortcuts

import androidx.annotation.DrawableRes

data class Contact(
    val id: String,
    val name: String,
    @DrawableRes val image: Int
)