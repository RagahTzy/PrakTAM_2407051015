package com.example.praktam_2407051015.model

data class Pokemon(
    val name: String,
    val type: Int,
    val id: Int,
    val image: Int,
    val description: String = "",
    val hp: Int = 0,
    val attack: Int = 0
)