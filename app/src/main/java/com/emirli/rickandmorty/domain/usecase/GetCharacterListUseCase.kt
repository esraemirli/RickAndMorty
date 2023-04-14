package com.emirli.rickandmorty.domain.usecase

import android.accounts.NetworkErrorException
import com.emirli.rickandmorty.data.entity.mapper.CharacterListUiModelMapper
import com.emirli.rickandmorty.data.entity.uimodel.CharacterListUiModel
import com.emirli.rickandmorty.data.repository.RickAndMortyRepository
import com.emirli.rickandmorty.util.UseCase
import com.emirli.rickandmorty.util.Result
import javax.inject.Inject

class GetCharacterListUseCase @Inject constructor(
    private val repository: RickAndMortyRepository,
    private val mapper: CharacterListUiModelMapper
) : UseCase<GetCharacterListUseCase.Params, CharacterListUiModel> {

    override suspend fun run(params: Params): CharacterListUiModel {
        return when (
            val response = repository.getCharacterList(params.page)
        ) {
            is Result.Success -> mapper.map(response.data)
            is Result.Error ->
                throw NetworkErrorException("FetchCharacterListUseCase Network Error")
        }
    }

    data class Params(
        val page: Int = 1
    )
}