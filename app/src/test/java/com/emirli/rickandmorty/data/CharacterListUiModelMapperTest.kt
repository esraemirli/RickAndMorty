package com.emirli.rickandmorty.data

import com.emirli.rickandmorty.data.entity.mapper.CharacterListUiModelMapper
import com.emirli.rickandmorty.data.entity.mapper.CharacterUiModelMapper
import com.emirli.rickandmorty.util.BaseUnitTest
import com.emirli.rickandmorty.util.baseResponse
import com.emirli.rickandmorty.util.characterListUiModel
import com.emirli.rickandmorty.util.characterUiModel
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterListUiModelMapperTest : BaseUnitTest() {

    private val characterUiModelMapper: CharacterUiModelMapper = mockk()

    private lateinit var characterListUiModelMapper: CharacterListUiModelMapper

    @Before
    fun setUp() {
        characterListUiModelMapper = CharacterListUiModelMapper(
            characterUiModelMapper
        )
    }

    @Test
    fun `Map baseResponse to CharacterListUiModel`() {
        val expected = characterListUiModel
        every { characterUiModelMapper.map(baseResponse.items.first()) }.returns(characterUiModel)

        val actual = characterListUiModelMapper.map(baseResponse)
        assertEquals(expected, actual)
    }
}