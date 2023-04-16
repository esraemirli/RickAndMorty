package com.emirli.rickandmorty.domain.usecase

import com.emirli.rickandmorty.util.baseResponse
import com.emirli.rickandmorty.util.characterListUiModel
import com.emirli.rickandmorty.data.entity.mapper.CharacterListUiModelMapper
import com.emirli.rickandmorty.data.repository.RickAndMortyRepository
import com.emirli.rickandmorty.util.BaseUnitTest
import com.emirli.rickandmorty.util.Result
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetCharacterListUseCaseTest : BaseUnitTest() {

    private val repository: RickAndMortyRepository = mockk()
    private val mapper: CharacterListUiModelMapper = mockk()

    private lateinit var useCase: GetCharacterListUseCase
    private lateinit var handler: CoroutineExceptionHandler

    @Before
    fun setUp() {
        useCase = GetCharacterListUseCase(
            repository = repository,
            mapper = mapper
        )
        handler = CoroutineExceptionHandler { _, _ ->

        }
    }

    @Test
    fun `WHEN response is Success THEN return CharacterListUiModel`() = runBlocking {
        val expected = characterListUiModel
        coEvery { repository.getCharacterList(1) }.returns(Result.Success(baseResponse))
        coEvery { mapper.map(baseResponse) }.returns(characterListUiModel)

        val actual = useCase.run(GetCharacterListUseCase.Params(1))

        assertEquals(expected, actual)
    }

    @Test
    fun `WHEN response is Error THEN throw Exception`() = runBlocking(handler) {
        var exceptionThrown = false

        coEvery { repository.getCharacterList(1) }.returns(Result.Error("Error"))

        try {
            useCase.run(GetCharacterListUseCase.Params(1))
        } catch (e: Exception) {
            exceptionThrown = true
        }

        assertTrue(exceptionThrown)
    }
}