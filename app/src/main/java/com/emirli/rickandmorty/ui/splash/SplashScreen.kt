package com.emirli.rickandmorty.ui.splash

import android.annotation.SuppressLint
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.emirli.rickandmorty.R
import com.emirli.rickandmorty.util.navigation.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavHostController) {
    val rotation = remember { Animatable(0f) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        delay(4000)
        navController.navigate(Screen.Home.route)
    }

    coroutineScope.launch {
        rotation.animateTo(
            targetValue = 360f,
            animationSpec = repeatable(
                iterations = 1000,
                animation = tween(200, easing = FastOutSlowInEasing),
            )
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.rotate(rotation.value),
            painter = painterResource(id = R.drawable.icon_rm),
            contentDescription = null,
        )
    }
}