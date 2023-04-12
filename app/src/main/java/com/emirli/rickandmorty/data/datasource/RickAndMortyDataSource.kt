package com.emirli.rickandmorty.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.emirli.rickandmorty.data.entity.uimodel.CharacterUiModel
import com.emirli.rickandmorty.domain.usecase.GetCharacterListUseCase

class RickAndMortyDataSource(
    private val getCharacterListUseCase: GetCharacterListUseCase,
) : PagingSource<Int, CharacterUiModel>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterUiModel>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterUiModel> {
        return try {
            val page = params.key ?: 1
            val response = getCharacterListUseCase.run(GetCharacterListUseCase.Params(page))
            LoadResult.Page(
                data = response.characters,
                prevKey = null,
                nextKey = if (response.hasNextPage) page + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Page(
                data = emptyList(),
                prevKey = null,
                nextKey = null
            )
        }
    }
}