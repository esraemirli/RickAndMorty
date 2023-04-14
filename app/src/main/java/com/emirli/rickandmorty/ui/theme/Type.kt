package com.emirli.rickandmorty.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        letterSpacing = (0.15).sp,
        color = Color.White
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        letterSpacing = 0.15.sp,
        color = Color.White
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    caption = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        letterSpacing = 0.75.sp,
        color = Color.White
    ),
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)