package com.emirli.rickandmorty.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.emirli.rickandmorty.R
import com.emirli.rickandmorty.ui.theme.ThemeDimensions

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    title: String,
    iconVisible: Boolean,
    onIconClicked: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(horizontal = ThemeDimensions.current.sm),
            verticalAlignment = CenterVertically
        ) {
            if (iconVisible) {
                Icon(
                    modifier = Modifier
                        .padding(end = ThemeDimensions.current.xxs)
                        .clickable { onIconClicked() },
                    painter = painterResource(id = R.drawable.ic_back),
                    tint = MaterialTheme.colors.onPrimary,
                    contentDescription = null
                )
            }
            Text(
                modifier = Modifier.weight(1f),
                text = title,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h1,
            )
            Image(
                painter = painterResource(id = R.drawable.img_toolbar),
                contentDescription = null,
                alignment = Alignment.CenterEnd
            )
        }
        Divider(
            modifier = Modifier
                .height(ThemeDimensions.current.xxxs)
                .background(MaterialTheme.colors.primary)
        )
    }
}