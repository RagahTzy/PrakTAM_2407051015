package com.example.praktam_2407051015.model

import com.example.praktam_2407051015.R

object PokemonSource {
    val dummyPokemon = listOf(
        Pokemon(
            name = "Bulbasaur",
            type = 1,
            id = 1,
            image = R.drawable.bulbasaur,
            description = "A strange seed was planted on its back at birth. The plant sprouts and grows with this Pokémon.",
            hp = 45,
            attack = 49
        ),
        Pokemon(
            name = "Charmander",
            type = 2,
            id = 4,
            image = R.drawable.charmander,
            description = "The flame at the tip of its tail makes a sound as it burns. You can only hear it in quiet places.",
            hp = 39,
            attack = 52
        ),
        Pokemon(
            name = "Squirtle",
            type = 3,
            id = 7,
            image = R.drawable.squirtle,
            description = "Shoots water at prey while in the water. Withdraws into its shell when in danger.",
            hp = 44,
            attack = 48
        ),
        Pokemon(
            name = "Caterpie",
            type = 4,
            id = 10,
            image = R.drawable.caterpie, // ganti dengan R.drawable.caterpie jika ada
            description = "Its short feet are tipped with suction pads that enable it to tirelessly climb slopes and walls.",
            hp = 45,
            attack = 30
        ),
        Pokemon(
            name = "Pidgey",
            type = 4,
            id = 16,
            image = R.drawable.pidgey, // ganti dengan R.drawable.pidgey jika ada
            description = "A common sight in forests and woods. It flaps its wings at ground level to kick up blinding sand.",
            hp = 40,
            attack = 45
        ),
        Pokemon(
            name = "Pikachu",
            type = 5,
            id = 25,
            image = R.drawable.pikachu, // ganti dengan R.drawable.pikachu jika ada
            description = "When several of these Pokémon gather, their electricity could build and cause lightning storms.",
            hp = 35,
            attack = 55
        )
    )

    // Featured / Rekomendasi Populer (3 pokemon pertama)
    val featuredPokemon = dummyPokemon.take(3)
}