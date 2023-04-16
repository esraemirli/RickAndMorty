package com.emirli.rickandmorty.data.entity.mapper

import com.emirli.rickandmorty.data.entity.uimodel.CharacterUiModel
import com.emirli.rickandmorty.data.entity.Character
import javax.inject.Inject

class CharacterUiModelMapper @Inject constructor() {

    fun map(data: Character) = CharacterUiModel(
        id = data.id,
        name = data.name,
        image = data.image,
        species = data.species,
        status = data.status,
        locationName = data.location.name
    )
}