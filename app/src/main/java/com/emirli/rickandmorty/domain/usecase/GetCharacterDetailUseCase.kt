package com.emirli.rickandmorty.domain.usecase

import com.emirli.rickandmorty.data.entity.mapper.CharacterUiModelMapper
import com.emirli.rickandmorty.data.entity.uimodel.CharacterUiModel
import com.emirli.rickandmorty.data.repository.RickAndMortyRepository
import com.emirli.rickandmorty.util.Result
import com.emirli.rickandmorty.util.UseCase
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor(
    private val repository: RickAndMortyRepository,
    private val mapper: CharacterUiModelMapper
) : UseCase<GetCharacterDetailUseCase.Params, CharacterUiModel> {

    override suspend fun run(params: Params): CharacterUiModel {
        try {
            return when (
                val response = repository.getCharacterDetail(params.id)
            ) {
                is Result.Success -> mapper.map(response.data)
                is Result.Error -> throw Exception(response.message)
            }
        } catch (exception: Exception) {
            throw exception
        }
    }

    data class Params(
        val id: Int = -1
    )
}