package com.emirli.rickandmorty.util

import androidx.paging.PagingSource
import com.emirli.rickandmorty.data.entity.*
import com.emirli.rickandmorty.data.entity.uimodel.CharacterListUiModel
import com.emirli.rickandmorty.data.entity.uimodel.CharacterUiModel

val characterUiModel = CharacterUiModel(
    id = 1,
    name = "",
    image = "",
    species = "",
    status = "",
    locationName = "",
    genderIcon = null,
    episodes = emptyList()
)

val entityCharacter = Character(
    id = 1,
    name = "",
    image = "",
    species = "",
    type = "",
    gender = "",
    origin = Origin("",""),
    status = "",
    location = Location("",""),
    episode = emptyList(),
    url = "",
    created = ""

)

val characterListUiModel = CharacterListUiModel(
    hasNextPage = true,
    count = 20,
    characters = listOf(characterUiModel)
)

val baseResponse = BaseResponse(
    info = Info(
        count = 20,
        pages = 53,
        next = "2",
        prev = null
    ),
    items = listOf(entityCharacter)
)

val pagingSourceParams = PagingSource
    .LoadParams
    .Append(
        key = 1,
        loadSize = 1,
        placeholdersEnabled = false
    )