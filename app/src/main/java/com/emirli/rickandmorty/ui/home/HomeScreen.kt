package com.emirli.rickandmorty.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.emirli.rickandmorty.R
import com.emirli.rickandmorty.data.entity.uimodel.CharacterUiModel
import com.emirli.rickandmorty.ui.common.CharacterItemView
import com.emirli.rickandmorty.ui.common.Toolbar
import com.emirli.rickandmorty.ui.theme.ThemeDimensions

const val GRID_COUNT = 2

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val lazyPagingItems = viewModel.pager.collectAsLazyPagingItems()

    Surface(modifier = Modifier.fillMaxSize()) {

        when (val currentState = lazyPagingItems.loadState.refresh) {
            is LoadState.Loading -> {
                //TODO implement loading view
            }
            is LoadState.Error -> {
                //TODO implement error view
            }
            else -> {
                if (lazyPagingItems.itemCount > 0) {
                    ContentView(
                        items = lazyPagingItems,
                        onItemClicked = { id ->
                            //TODO navigate to Detail Screen
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContentView(
    modifier: Modifier = Modifier,
    items: LazyPagingItems<CharacterUiModel>,
    onItemClicked: (Int) -> Unit,
) {
    Column(modifier = modifier) {
        Toolbar(title = stringResource(id = R.string.home_title), iconVisible = false)

        LazyVerticalGrid(
            modifier = Modifier
                .weight(1f, true)
                .padding(ThemeDimensions.current.sm),
            cells = GridCells.Fixed(GRID_COUNT),
            verticalArrangement = Arrangement.spacedBy(ThemeDimensions.current.sm),
            horizontalArrangement = Arrangement.spacedBy(ThemeDimensions.current.sm)
        ) {
            items(
                lazyPagingItems = items,
                itemContent = { value ->
                    value?.let {
                        CharacterItemView(uiModel = value, onCharacterClicked = onItemClicked)
                    }
                }
            )
        }
    }
}

@ExperimentalFoundationApi
fun <T : Any> LazyGridScope.items(
    lazyPagingItems: LazyPagingItems<T>,
    itemContent: @Composable LazyItemScope.(value: T?) -> Unit
) {
    items(lazyPagingItems.itemCount) { index ->
        itemContent(lazyPagingItems[index])
    }
}