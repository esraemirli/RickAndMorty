package com.emirli.rickandmorty.data.entity.mapper

import com.emirli.rickandmorty.data.entity.BaseResponse
import com.emirli.rickandmorty.data.entity.Character
import com.emirli.rickandmorty.data.entity.uimodel.CharacterListUiModel
import com.emirli.rickandmorty.data.entity.uimodel.CharacterUiModel
import javax.inject.Inject

class CharacterListUiModelMapper @Inject constructor() {

    fun map(data: BaseResponse<List<Character>>): CharacterListUiModel {
        val characterList = data.items.map { character ->
            CharacterUiModel(
                id = character.id,
                name = character.name,
                image = character.image,
                species = character.species,
                status = character.status,
                locationName = character.location.name
            )
        }

        return CharacterListUiModel(
            hasNextPage = data.info.next != null,
            count = data.info.count,
            characters = characterList
        )
    }
}