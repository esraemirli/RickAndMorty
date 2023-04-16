package com.emirli.rickandmorty.ui.home

import androidx.paging.PagingSource
import com.emirli.rickandmorty.data.datasource.RickAndMortyDataSource
import com.emirli.rickandmorty.data.entity.uimodel.CharacterListUiModel
import com.emirli.rickandmorty.domain.usecase.GetCharacterListUseCase
import com.emirli.rickandmorty.util.characterListUiModel
import com.emirli.rickandmorty.util.characterUiModel
import com.emirli.rickandmorty.util.pagingSourceParams
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class HomeViewModelTest {

    private val getCharacterListUseCase: GetCharacterListUseCase = mockk()

    private lateinit var viewModel: HomeViewModel
    private lateinit var pagerSource: RickAndMortyDataSource

    @Before
    fun setUp() {
        viewModel = HomeViewModel(getCharacterListUseCase)
        pagerSource = RickAndMortyDataSource(getCharacterListUseCase)
    }

    @Test
    fun `WHEN characters has next page then paging source returns success append load result`() =
        runBlocking {
            val expected = PagingSource.LoadResult.Page(
                data = listOf(characterUiModel),
                prevKey = null,
                nextKey = 2
            )
            coEvery { getCharacterListUseCase.run(GetCharacterListUseCase.Params(1)) }.returns(
                characterListUiModel
            )

            val actual = pagerSource.load(params = pagingSourceParams)

            assertEquals(expected, actual)
        }

    @Test
    fun `WHEN characters are given then paging source returns error load result`() =
        runBlocking {
            val expected = PagingSource
                .LoadResult.Error<Int, CharacterListUiModel>(
                    throwable = RuntimeException("Error")
                )::class.java
            coEvery { getCharacterListUseCase.run(GetCharacterListUseCase.Params(1)) }
                .throws(Exception("Error"))

            val actual = pagerSource.load(params = pagingSourceParams)::class.java

            assertEquals(expected, actual)
        }
}