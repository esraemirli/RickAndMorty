package com.emirli.rickandmorty.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.emirli.rickandmorty.R
import com.emirli.rickandmorty.ui.theme.ThemeDimensions

@Composable
fun Error(
    message: String,
    onRetryClicked: () -> Unit = {}
) {

    Column(
        modifier = Modifier.padding(top = ThemeDimensions.current.sm),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.error_animation))
        val animationState by animateLottieCompositionAsState(
            composition = composition,
            isPlaying = true,
            iterations = LottieConstants.IterateForever
        )
        LottieAnimation(
            modifier = Modifier.size(250.dp),
            composition = composition,
            progress = { animationState },
        )

        Text(
            text = message,
            style = MaterialTheme.typography.caption,
            textAlign = TextAlign.Center
        )

        Button(
            modifier = Modifier.width(250.dp),
            shape = MaterialTheme.shapes.large,
            onClick = onRetryClicked
        ) {
            Text(
                modifier = Modifier.padding(ThemeDimensions.current.xs),
                text = stringResource(id = R.string.retry_text),
                style = MaterialTheme.typography.h1
            )
        }
    }
}