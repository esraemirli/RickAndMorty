package com.emirli.rickandmorty.ui.common

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.emirli.rickandmorty.R
import com.emirli.rickandmorty.data.entity.uimodel.CharacterUiModel
import com.emirli.rickandmorty.ui.theme.ThemeDimensions

private const val IMAGE_HEIGHT = 200
private const val NAME_BOX_HEIGHT = 225
private const val DETAIL_BOX_DEFAULT_HEIGHT = 250
private const val DETAIL_BOX_EXPANDED_HEIGHT = 350

@Composable
fun CharacterItemView(
    uiModel: CharacterUiModel,
    onCharacterClicked: (Int) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    val detailBoxHeight = if (isExpanded) DETAIL_BOX_EXPANDED_HEIGHT.dp
    else DETAIL_BOX_DEFAULT_HEIGHT.dp

    Surface {
        Box(
            modifier = Modifier
                .animateContentSize(animationSpec = tween(1000))
                .height(detailBoxHeight)
                .clip(MaterialTheme.shapes.large)
                .paint(
                    painter = painterResource(id = R.drawable.expanded_background),
                    contentScale = ContentScale.Crop
                )
                .clickable { isExpanded = !isExpanded }
        ) {
            if (isExpanded) {
                Column(
                    modifier = Modifier.padding(top = NAME_BOX_HEIGHT.dp),
                ) {
                    ItemText(text = uiModel.species)
                    ItemText(text = uiModel.status)
                    ItemText(text = uiModel.locationName)
                }
            } else {
                Icon(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    painter = painterResource(id = R.drawable.ic_more),
                    contentDescription = null,
                )
            }
        }

        Box(
            modifier = Modifier
                .height(NAME_BOX_HEIGHT.dp)
                .clip(MaterialTheme.shapes.large)
                .background(MaterialTheme.colors.secondary),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(
                text = uiModel.name,
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }

        Image(
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .height(IMAGE_HEIGHT.dp)
                .border(width = 1.dp, color = MaterialTheme.colors.primary)
                .clickable { onCharacterClicked(uiModel.id) },
            painter = rememberAsyncImagePainter(
                model = uiModel.image,
                placeholder = painterResource(id = R.drawable.ic_placeholder)
            ),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}

@Composable
fun ItemText(text: String) {
    Row(
        modifier = Modifier.padding(ThemeDimensions.current.xxs),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(8.dp),
            painter = painterResource(id = R.drawable.ic_circle),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(ThemeDimensions.current.xxs))
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}