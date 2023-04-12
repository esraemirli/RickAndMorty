package com.emirli.rickandmorty.domain.repository

import com.emirli.rickandmorty.data.api.RickAndMortyAPI
import com.emirli.rickandmorty.data.entity.BaseResponse
import com.emirli.rickandmorty.data.entity.Character
import com.emirli.rickandmorty.data.repository.RickAndMortyRepository
import com.emirli.rickandmorty.util.Result
import retrofit2.Response
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(
    private val api: RickAndMortyAPI
) : RickAndMortyRepository {

    override suspend fun getCharacterList(page: Int): Result<BaseResponse<List<Character>>> {
        val response = api.getCharacterList(page)
        return response.getResults()
    }

    private fun Response<BaseResponse<List<Character>>>.getResults() =
        if (this.isSuccessful) {
            val body = this.body()
            if (body != null) Result.Success(body)
            else Result.Error("Empty response body")
        } else {
            Result.Error("Network Error")
        }
}