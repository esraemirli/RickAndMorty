package com.emirli.rickandmorty.domain.repository

import com.emirli.rickandmorty.data.api.RickAndMortyAPI
import com.emirli.rickandmorty.data.repository.RickAndMortyRepository
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(
    private val api: RickAndMortyAPI
) : RickAndMortyRepository {

}