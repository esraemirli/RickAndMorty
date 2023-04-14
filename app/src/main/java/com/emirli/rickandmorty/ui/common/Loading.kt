package com.emirli.rickandmorty.ui.common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.emirli.rickandmorty.ui.home.GRID_COUNT
import com.emirli.rickandmorty.ui.theme.ThemeDimensions

private const val TOOLBAR_HEIGHT = 75

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Loading() {

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(TOOLBAR_HEIGHT.dp)
                .background(MaterialTheme.colors.onSurface)
        )

        LazyVerticalGrid(
            modifier = Modifier
                .weight(1f, true)
                .padding(ThemeDimensions.current.sm),
            cells = GridCells.Fixed(GRID_COUNT),
            verticalArrangement = Arrangement.spacedBy(ThemeDimensions.current.sm),
            horizontalArrangement = Arrangement.spacedBy(ThemeDimensions.current.sm),

            ) {
            items(10) {
                Box(
                    modifier = Modifier
                        .size(width = 100.dp, height = 200.dp)
                        .clip(MaterialTheme.shapes.large)
                        .background(MaterialTheme.colors.onSurface)
                )
            }
        }
    }
}