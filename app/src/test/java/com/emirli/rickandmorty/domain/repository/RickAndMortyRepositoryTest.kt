package com.emirli.rickandmorty.domain.repository

import com.emirli.rickandmorty.util.BaseUnitTest
import com.emirli.rickandmorty.data.api.RickAndMortyAPI
import com.emirli.rickandmorty.data.repository.RickAndMortyRepository
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import com.emirli.rickandmorty.util.Result
import com.emirli.rickandmorty.util.baseResponse
import io.mockk.coEvery
import kotlinx.coroutines.*
import retrofit2.Response

@ExperimentalCoroutinesApi
class RickAndMortyRepositoryTest : BaseUnitTest() {

    private val api: RickAndMortyAPI = mockk()

    private lateinit var repository: RickAndMortyRepository

    @Before
    fun setUp() {
        repository = RickAndMortyRepositoryImpl(api = api)
    }

    @Test
    fun `WHEN fetch character list AND network call is success THEN return result success`() =
        runBlocking {
            val expected = Result.Success(baseResponse)
            coEvery { api.getCharacterList(1) }.returns(Response.success(baseResponse))

            val actual = repository.getCharacterList(1)
            assertEquals(expected, actual)
        }

    @Test
    fun `WHEN fetch character list AND network call is fail THEN return error`() = runBlocking {
        val expected = Result.Error<String>("Network Error")
        coEvery { api.getCharacterList(1).isSuccessful }.returns(false)

        val actual = repository.getCharacterList(1)
        assertEquals(expected, actual)
    }


    @Test
    fun `WHEN fetch character detail AND network call is success THEN return result success`() =
        runBlocking {
            val expected = Result.Success(baseResponse.items.first())
            coEvery {
                api.getCharacterDetail(1)
            }.returns(
                Response.success(baseResponse.items.first())
            )

            val actual = repository.getCharacterDetail(1)
            assertEquals(expected, actual)
        }

    @Test
    fun `WHEN fetch character detail AND network call is fail THEN return error`() = runBlocking {
        val expected = Result.Error<String>("Network Error")
        coEvery { api.getCharacterDetail(1).isSuccessful }.returns(false)

        val actual = repository.getCharacterDetail(1)
        assertEquals(expected, actual)
    }
}