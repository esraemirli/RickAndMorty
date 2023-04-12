package com.emirli.rickandmorty.data.entity.uimodel

data class CharacterListUiModel(
    val hasNextPage: Boolean,
    val count: Int,
    val characters: List<CharacterUiModel>
)
