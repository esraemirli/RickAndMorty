package com.emirli.rickandmorty.ui.detail

import com.emirli.rickandmorty.domain.usecase.GetCharacterDetailUseCase
import com.emirli.rickandmorty.util.BaseUnitTest
import com.emirli.rickandmorty.util.characterUiModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class DetailViewModelTest : BaseUnitTest() {

    private val getCharacterDetailUseCase: GetCharacterDetailUseCase = mockk()

    private lateinit var viewModel: DetailViewModel
    private lateinit var handler: CoroutineExceptionHandler

    @Before
    fun setUp() {
        viewModel = DetailViewModel(getCharacterDetailUseCase)

        handler = CoroutineExceptionHandler { _, _ ->

        }
    }

    @Test
    fun `WHEN fetch character detail AND response is success THEN update state as Content`() =
        runBlocking(handler) {
            val expected = DetailState.Content(uiModel = characterUiModel)
            coEvery { getCharacterDetailUseCase.run(GetCharacterDetailUseCase.Params(1)) }.returns(
                characterUiModel
            )

            val uiModel = getCharacterDetailUseCase.run(GetCharacterDetailUseCase.Params(1))

            val actual = DetailState.Content(uiModel = uiModel)
            assertEquals(expected, actual)
        }

    @Test
    fun `WHEN fetch character detail AND response is not success THEN update state as Error`() =
        runBlocking(handler) {
            val expected = DetailState.Error("Error")
            coEvery { getCharacterDetailUseCase.run(GetCharacterDetailUseCase.Params(1)) }
                .throws(Exception("Error"))
            var actual: DetailState = DetailState.Loading

            try {
                getCharacterDetailUseCase.run(GetCharacterDetailUseCase.Params(1))
            } catch(exception: Exception) {
                actual = DetailState.Error(exception.message.orEmpty())
            }

            assertEquals(expected, actual)
        }
}