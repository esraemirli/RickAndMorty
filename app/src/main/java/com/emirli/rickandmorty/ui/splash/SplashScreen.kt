package com.emirli.rickandmorty.ui.splash

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.emirli.rickandmorty.R
import com.emirli.rickandmorty.ui.common.ANIMATION_IMAGE_SIZE
import com.emirli.rickandmorty.util.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    val rotation = remember { Animatable(0f) }

    LaunchedEffect(rotation) {
        rotation.animateTo(
            targetValue = 360f,
            animationSpec = tween(durationMillis = 1500, easing = FastOutSlowInEasing)
        )
    }

    LaunchedEffect(true) {
        delay(1500)
        navController.navigate(Screen.Home.route) {
            popUpTo(Screen.Splash.route) {
                inclusive = true
            }
        }
    }

    val arcColor =  MaterialTheme.colors.primary
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .size(ANIMATION_IMAGE_SIZE.dp)
                .clip(CircleShape)
                .drawBehind {
                    drawArc(
                        color = arcColor,
                        useCenter = true,
                        startAngle = -90f,
                        sweepAngle = -rotation.value,
                    )
                },
            painter = painterResource(id = R.drawable.icon_rm),
            contentDescription = null,
        )
    }
}