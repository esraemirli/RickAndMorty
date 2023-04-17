package com.emirli.rickandmorty.domain.usecase

import com.emirli.rickandmorty.data.entity.mapper.CharacterUiModelMapper
import com.emirli.rickandmorty.data.repository.RickAndMortyRepository
import com.emirli.rickandmorty.util.*
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetCharacterDetailUseCaseTest : BaseUnitTest() {

    private val repository: RickAndMortyRepository = mockk()
    private val mapper: CharacterUiModelMapper = mockk()

    private lateinit var useCase: GetCharacterDetailUseCase

    @Before
    fun setUp() {
        useCase = GetCharacterDetailUseCase(
            repository = repository,
            mapper = mapper
        )
    }

    @Test
    fun `WHEN response is Success THEN return CharacterListUiModel`() = runBlocking {
        val expected = characterUiModel
        coEvery { repository.getCharacterDetail(1) }.returns(Result.Success(entityCharacter))
        coEvery { mapper.map(entityCharacter) }.returns(characterUiModel)

        val actual = useCase.run(GetCharacterDetailUseCase.Params(1))

        assertEquals(expected, actual)
    }

    @Test
    fun `WHEN response is Error THEN throw Exception`() = runBlocking {
        var exceptionThrown = false

        coEvery { repository.getCharacterDetail(1) }.returns(Result.Error("Error"))

        try {
            useCase.run(GetCharacterDetailUseCase.Params(1))
        } catch (e: Exception) {
            exceptionThrown = true
        }

        assertTrue(exceptionThrown)
    }
}