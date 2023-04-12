package com.emirli.rickandmorty.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.emirli.rickandmorty.data.entity.uimodel.CharacterUiModel

const val GRID_COUNT = 2

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val lazyPagingItems = viewModel.pager.collectAsLazyPagingItems()

    Surface(modifier = Modifier.fillMaxSize()) {
        when (lazyPagingItems.itemCount) {
            0 -> LoadingView()
            else -> ContentView(lazyPagingItems)
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContentView(
    lazyPagingItems: LazyPagingItems<CharacterUiModel>
) {
    LazyVerticalGrid(cells = GridCells.Fixed(GRID_COUNT)) {
        items(
            lazyPagingItems = lazyPagingItems,
            itemContent = { value ->
                value?.let {
                    //TODO will implement Character View
                }
            }
        )
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

@Composable
fun LoadingView() {

}