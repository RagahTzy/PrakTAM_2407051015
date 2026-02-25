package com.example.praktam_npm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.praktam_npm.model.PokemonSource
import com.example.praktam_npm.ui.theme.PrakTAM_NPMTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrakTAM_NPMTheme{
                HeroScreen()
            }
        }
    }
}

@Composable
fun HeroScreen() {
    val heroes = PokemonSource.dummyPokemon

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        heroes.forEach { pokemon ->

            Image(
                painter = painterResource(id = pokemon.image),
                contentDescription = pokemon.name,
                modifier = Modifier.size(120.dp)
            )

            Text(text = "Name: ${pokemon.name}")
            Text(text = "ID: ${pokemon.id}")
            Text(text = "Order: ${pokemon.order}")

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}