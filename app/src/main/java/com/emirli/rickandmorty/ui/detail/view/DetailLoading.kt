package com.emirli.rickandmorty.ui.detail.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.emirli.rickandmorty.ui.common.DETAIL_IMAGE_SIZE
import com.emirli.rickandmorty.ui.common.TOOLBAR_HEIGHT
import com.emirli.rickandmorty.ui.theme.ThemeDimensions

@Composable
fun Loading() {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(TOOLBAR_HEIGHT.dp)
                .background(MaterialTheme.colors.onSurface)
        )

        Column(modifier = Modifier.padding(ThemeDimensions.current.sm)) {
            Box(
                modifier = Modifier
                    .padding(vertical = ThemeDimensions.current.lg)

                    .clip(MaterialTheme.shapes.large)
                    .size(DETAIL_IMAGE_SIZE.dp)
                    .background(MaterialTheme.colors.onSurface)
            )

            for (i in 0..2) {
                Box(
                    modifier = Modifier
                        .size(width = 250.dp, height = 50.dp)
                        .padding(vertical = ThemeDimensions.current.xs)
                        .background(MaterialTheme.colors.onSurface)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(75.dp)
                    .padding(vertical = ThemeDimensions.current.xs)
                    .background(MaterialTheme.colors.onSurface)
            )
        }

    }
}