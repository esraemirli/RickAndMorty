package com.emirli.rickandmorty.data.entity.mapper

import com.emirli.rickandmorty.R
import com.emirli.rickandmorty.data.entity.uimodel.CharacterUiModel
import com.emirli.rickandmorty.data.entity.Character
import javax.inject.Inject

class CharacterUiModelMapper @Inject constructor() {

    fun map(data: Character) = CharacterUiModel(
        id = data.id,
        name = data.name,
        image = data.image,
        species = data.species,
        status = data.status,
        locationName = data.location.name,
        genderIcon = data.gender.getIcon(),
        episodes = data.episode.parseEpisodes()
    )

    private fun String.getIcon(): Int {
        return when (this) {
            MALE -> R.drawable.ic_male
            FEMALE -> R.drawable.ic_female
            else -> R.drawable.ic_unknown
        }
    }

    private fun List<String>.parseEpisodes(): List<String> {
        return this.map { episode ->
            val urlTokens = episode.split(URL_SEPARATOR)
            urlTokens[urlTokens.size - 1]
        }
    }

    companion object {
        private const val MALE = "Male"
        private const val FEMALE = "Female"
        private const val URL_SEPARATOR = "/"
    }
}