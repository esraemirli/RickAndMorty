package com.emirli.rickandmorty.util

interface UseCase<Params, Result> {
    suspend fun run(params: Params): Result
}