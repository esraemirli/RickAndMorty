package com.emirli.rickandmorty.data.entity.uimodel

data class CharacterUiModel(
    val id: Int,
    val name: String,
    val image: String,
    val species: String,
    val status: String,
    val locationName: String,
    val genderIcon: Int? = null,
    val episodes: List<String>? = null
)
