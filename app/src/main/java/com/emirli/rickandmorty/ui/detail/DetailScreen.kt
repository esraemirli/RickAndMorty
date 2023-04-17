package com.emirli.rickandmorty.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.emirli.rickandmorty.ui.common.Error
import com.emirli.rickandmorty.ui.detail.view.ContentView
import com.emirli.rickandmorty.ui.detail.view.Loading

@Composable
fun DetailScreen(
    navHostController: NavHostController,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val currentState = viewModel.stateFlow.collectAsState().value

    Surface(modifier = Modifier.fillMaxSize()) {
        when (currentState) {
            is DetailState.Loading -> Loading()
            is DetailState.Content -> {
                ContentView(
                    uiModel = currentState.uiModel,
                    onBackClicked = {
                        navHostController.popBackStack()
                    }
                )
            }
            is DetailState.Error -> {
                Error(
                    message = currentState.errorMessage,
                    onRetryClicked = { viewModel.retry() }
                )
            }
        }
    }
}