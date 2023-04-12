package com.emirli.rickandmorty.data.repository

import com.emirli.rickandmorty.data.entity.BaseResponse
import com.emirli.rickandmorty.data.entity.Character
import com.emirli.rickandmorty.util.Result

interface RickAndMortyRepository {

    suspend fun getCharacterList(page: Int): Result<BaseResponse<List<Character>>>
}