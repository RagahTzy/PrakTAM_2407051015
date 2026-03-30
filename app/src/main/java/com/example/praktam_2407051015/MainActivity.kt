package com.example.praktam_2407051015

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktam_2407051015.model.Pokemon
import com.example.praktam_2407051015.model.PokemonSource
import com.example.praktam_2407051015.ui.theme.PrakTAM_NPMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrakTAM_NPMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PokedexScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

fun getTypeColor(typeId: Int): Color = when (typeId) {
    1 -> Color(0xFF78C850) // Grass
    2 -> Color(0xFFF08030) // Fire
    3 -> Color(0xFF6890F0) // Water
    4 -> Color(0xFFA8B820) // Bug/Normal
    5 -> Color(0xFFF8D030) // Electric
    else -> Color(0xFF888888)
}

fun getPokemonType(typeId: Int): String = when (typeId) {
    1 -> "Grass"
    2 -> "Fire"
    3 -> "Water"
    4 -> "Normal"
    5 -> "Electric"
    else -> "Unknown"
}

@Composable
fun PokedexScreen(modifier: Modifier = Modifier) {
    val pokemons = PokemonSource.dummyPokemon
    val featured = PokemonSource.featuredPokemon

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF2F2F2)),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        item {
            PokedexHeader()
        }

        item {
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "⭐  Starter Pokémon",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 12.dp, top = 8.dp)
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(end = 8.dp)
                ) {
                    items(featured) { pokemon ->
                        FeaturedPokemonCard(pokemon = pokemon)
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "📋  Semua Pokémon",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        }

        items(pokemons) { pokemon ->
            PokemonDetailCard(
                pokemon = pokemon,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
            )
        }
    }
}

@Composable
fun PokedexHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(Color(0xFFCC0000), Color(0xFFFF6B6B))
                )
            )
    ) {
        Box(
            modifier = Modifier
                .size(180.dp)
                .offset(x = (-40).dp, y = (-40).dp)
                .background(Color.White.copy(alpha = 0.08f), shape = RoundedCornerShape(90.dp))
        )
        Box(
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.TopEnd)
                .offset(x = 30.dp, y = (-30).dp)
                .background(Color.White.copy(alpha = 0.08f), shape = RoundedCornerShape(60.dp))
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 20.dp, bottom = 20.dp)
        ) {
            Text(
                text = "Pokédex",
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 1.sp
            )
            Text(
                text = "${PokemonSource.dummyPokemon.size} Pokémon terdaftar",
                color = Color.White.copy(alpha = 0.85f),
                fontSize = 13.sp
            )
        }
    }
}

@Composable
fun FeaturedPokemonCard(pokemon: Pokemon) {
    val typeColor = getTypeColor(pokemon.type)

    Card(
        modifier = Modifier
            .width(140.dp)
            .height(180.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = typeColor.copy(alpha = 0.15f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .background(typeColor, shape = RoundedCornerShape(20.dp))
                    .padding(horizontal = 10.dp, vertical = 3.dp)
            ) {
                Text(
                    text = getPokemonType(pokemon.type),
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Image(
                painter = painterResource(id = pokemon.image),
                contentDescription = pokemon.name,
                modifier = Modifier
                    .size(70.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = pokemon.name,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = Color(0xFF222222)
            )
            Text(
                text = "#${String.format("%03d", pokemon.id)}",
                fontSize = 11.sp,
                color = Color(0xFF888888)
            )
        }
    }
}

@Composable
fun PokemonDetailCard(pokemon: Pokemon, modifier: Modifier = Modifier) {
    var isFavorite by remember { mutableStateOf(false) }
    val typeColor = getTypeColor(pokemon.type)

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(typeColor.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = pokemon.image),
                    contentDescription = pokemon.name,
                    modifier = Modifier.size(70.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = pokemon.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF1A1A2E)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "#${String.format("%03d", pokemon.id)}",
                        fontSize = 12.sp,
                        color = Color(0xFF999999)
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Box(
                    modifier = Modifier
                        .background(typeColor, shape = RoundedCornerShape(20.dp))
                        .padding(horizontal = 10.dp, vertical = 3.dp)
                ) {
                    Text(
                        text = getPokemonType(pokemon.type),
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                StatRow(label = "HP", value = pokemon.hp, maxValue = 100, color = Color(0xFF4CAF50))
                Spacer(modifier = Modifier.height(3.dp))
                StatRow(label = "ATK", value = pokemon.attack, maxValue = 100, color = Color(0xFFFF5722))

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {},
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = typeColor),
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                    modifier = Modifier.height(32.dp)
                ) {
                    Text(
                        text = "See Details",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color.White
                    )
                }
            }

            IconButton(
                onClick = { isFavorite = !isFavorite },
                modifier = Modifier.size(36.dp)
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = if (isFavorite) Color(0xFFE53935) else Color(0xFFBBBBBB),
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}

@Composable
fun StatRow(label: String, value: Int, maxValue: Int, color: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = label,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF888888),
            modifier = Modifier.width(28.dp)
        )
        Text(
            text = "$value",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF444444),
            modifier = Modifier.width(24.dp)
        )
        LinearProgressIndicator(
            progress = { value / maxValue.toFloat() },
            modifier = Modifier
                .height(6.dp)
                .weight(1f)
                .clip(RoundedCornerShape(3.dp)),
            color = color,
            trackColor = Color(0xFFEEEEEE)
        )
    }
}