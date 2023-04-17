package com.emirli.rickandmorty.data.entity.mapper

import com.emirli.rickandmorty.data.entity.BaseResponse
import com.emirli.rickandmorty.data.entity.Character
import com.emirli.rickandmorty.data.entity.uimodel.CharacterListUiModel
import javax.inject.Inject

class CharacterListUiModelMapper @Inject constructor(
    private val characterUiModelMapper: CharacterUiModelMapper
) {

    fun map(data: BaseResponse<List<Character>>): CharacterListUiModel {
        val characterList = data.items.map { character ->
            characterUiModelMapper.map(character)
        }

        return CharacterListUiModel(
            hasNextPage = data.info.next != null,
            count = data.info.count,
            characters = characterList
        )
    }
}