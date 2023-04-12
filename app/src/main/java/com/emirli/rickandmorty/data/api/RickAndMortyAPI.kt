package com.emirli.rickandmorty.data.api

import com.emirli.rickandmorty.data.entity.BaseResponse
import com.emirli.rickandmorty.data.entity.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyAPI {

    @GET("character")
    suspend fun getCharacterList(
        @Query("page") page: Int?
    ): Response<BaseResponse<List<Character>>>

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/api/"
    }
}