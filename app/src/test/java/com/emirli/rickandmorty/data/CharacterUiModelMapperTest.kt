package com.emirli.rickandmorty.data

import com.emirli.rickandmorty.R
import com.emirli.rickandmorty.data.entity.mapper.CharacterUiModelMapper
import com.emirli.rickandmorty.util.characterUiModel
import com.emirli.rickandmorty.util.entityCharacter
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Test

class CharacterUiModelMapperTest {

    private val mapper: CharacterUiModelMapper = mockk()

    @Test
    fun `Map the character to CharacterUiModel`() {
        val expected = characterUiModel
        coEvery { mapper.map(entityCharacter) }.returns(characterUiModel)

        val actual = mapper.map(entityCharacter)
        assertEquals(expected, actual)
    }

    @Test
    fun `WHEN gender is male THEN genderIcon is ic_male`() {
        val entityCharacter = entityCharacter.copy(gender = "Male")
        coEvery { mapper.map(entityCharacter) }
            .returns(characterUiModel.copy(genderIcon = R.drawable.ic_male))

        val actual = mapper.map(entityCharacter)
        assertEquals(R.drawable.ic_male, actual.genderIcon)
    }

    @Test
    fun `WHEN gender is female THEN genderIcon is ic_female`() {
        val entityCharacter = entityCharacter.copy(gender = "Female")
        coEvery { mapper.map(entityCharacter) }
            .returns(characterUiModel.copy(genderIcon = R.drawable.ic_female))

        val actual = mapper.map(entityCharacter)
        assertEquals(R.drawable.ic_female, actual.genderIcon)
    }

    @Test
    fun `WHEN gender is not male or female THEN genderIcon is ic_unknown`() {
        val entityCharacter = entityCharacter
        coEvery { mapper.map(entityCharacter) }
            .returns(characterUiModel.copy(genderIcon = R.drawable.ic_unknown))

        val actual = mapper.map(entityCharacter)
        assertEquals(R.drawable.ic_unknown, actual.genderIcon)
    }

}