package com.emirli.rickandmorty.ui.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.emirli.rickandmorty.ui.common.Error
import com.emirli.rickandmorty.ui.common.Loading

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
                //TODO will implement
            }
            is DetailState.Error ->
                Error(
                    message = currentState.errorMessage,
                    onRetryClicked = {
                        //TODO will implement
                    }
                )
        }
    }
}