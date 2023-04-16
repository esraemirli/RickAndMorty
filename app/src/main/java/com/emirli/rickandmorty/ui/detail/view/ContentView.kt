package com.emirli.rickandmorty.ui.detail.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.emirli.rickandmorty.R
import com.emirli.rickandmorty.data.entity.uimodel.CharacterUiModel
import com.emirli.rickandmorty.ui.common.DETAIL_IMAGE_SIZE
import com.emirli.rickandmorty.ui.common.Toolbar
import com.emirli.rickandmorty.ui.theme.ThemeDimensions

@Composable
fun ContentView(
    uiModel: CharacterUiModel,
    onBackClicked: () -> Unit
) {
    val scrollState = rememberScrollState()
    Column {
        Toolbar(title = uiModel.name, iconVisible = true, onIconClicked = onBackClicked)

        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            Image(
                modifier = Modifier
                    .padding(
                        vertical = ThemeDimensions.current.lg,
                        horizontal = ThemeDimensions.current.sm
                    )
                    .size(DETAIL_IMAGE_SIZE.dp)
                    .clip(MaterialTheme.shapes.large)
                    .border(width = 5.dp, color = MaterialTheme.colors.primary),
                painter = rememberAsyncImagePainter(
                    model = uiModel.image,
                    placeholder = painterResource(id = R.drawable.ic_placeholder),
                ),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )

            ItemInfo(title = stringResource(id = R.string.location), text = uiModel.locationName)
            ItemInfo(title = stringResource(id = R.string.species), text = uiModel.species)
            ItemInfo(title = stringResource(id = R.string.gender), icon = uiModel.genderIcon)

            uiModel.episodes?.let {
                Episodes(episodes = uiModel.episodes)
            }
        }
    }
}

@Composable
fun ItemInfo(
    title: String,
    text: String? = null,
    icon: Int? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = ThemeDimensions.current.xs,
                horizontal = ThemeDimensions.current.sm
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "$title :",
            style = MaterialTheme.typography.subtitle1,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.width(ThemeDimensions.current.xxs))
        text?.let {
            Text(
                text = text,
                style = MaterialTheme.typography.body2,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
        icon?.let {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = MaterialTheme.colors.onPrimary
            )
        }
    }
}

@Composable
fun Episodes(
    episodes: List<String>
) {
    var isExpanded by remember { mutableStateOf(false) }

    Divider(
        modifier = Modifier
            .padding(vertical = ThemeDimensions.current.st)
            .height(1.dp),
        color = MaterialTheme.colors.onSurface
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = ThemeDimensions.current.sm)
            .clickable { isExpanded = !isExpanded },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(id = R.string.episodes),
            style = MaterialTheme.typography.subtitle1,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.width(ThemeDimensions.current.xxs))
        Icon(
            painter = painterResource(
                id = if (isExpanded) R.drawable.ic_up else R.drawable.ic_down
            ),
            contentDescription = null,
            tint = MaterialTheme.colors.primary
        )
    }

    if (isExpanded) {
        episodes.forEach { number ->
            Text(
                modifier = Modifier.padding(
                    vertical = ThemeDimensions.current.xs,
                    horizontal = ThemeDimensions.current.sm
                ),
                text = stringResource(id = R.string.episode_number, number),
                style = MaterialTheme.typography.body2
            )
        }
    }

    Divider(
        modifier = Modifier
            .padding(vertical = ThemeDimensions.current.st)
            .height(1.dp),
        color = MaterialTheme.colors.onSurface
    )
}