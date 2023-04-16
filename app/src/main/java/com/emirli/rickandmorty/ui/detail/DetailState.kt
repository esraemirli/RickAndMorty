package com.emirli.rickandmorty.ui.detail

import com.emirli.rickandmorty.data.entity.uimodel.CharacterUiModel

sealed class DetailState {
    object Loading : DetailState()

    data class Content(val uiModel: CharacterUiModel) : DetailState()

    data class Error(val errorMessage: String) : DetailState()
}