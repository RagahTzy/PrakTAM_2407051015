package com.example.praktam_2407051015.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val AppColorScheme = lightColorScheme(
    primary          = PokedexRed,
    secondary        = PokedexYellow,
    background       = PokedexBackground,
    surface          = PokedexSurface,
    onPrimary        = PokedexOnPrimary,
    onSurface        = PokedexOnSurface,
    onBackground     = PokedexOnBackground,
    tertiary         = PokedexRedLight
)

@Composable
fun PrakTAM_NPMTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = AppColorScheme,
        typography  = AppTypography,
        content     = content
    )
}