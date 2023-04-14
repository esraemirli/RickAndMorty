package com.emirli.rickandmorty.ui.theme

import android.annotation.SuppressLint
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.dp

@SuppressLint("CompositionLocalNaming")
val ThemeDimensions = compositionLocalOf { Dimensions() }

class Dimensions {
    val xxxs = 2.dp
    val xxs = 4.dp
    val xs = 8.dp
    val st = 12.dp
    val sm = 16.dp
    val md = 24.dp
    val lg = 32.dp
    val xl = 48.dp
    val xxl = 64.dp
    val xxxl = 80.dp
}