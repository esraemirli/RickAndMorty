package com.emirli.rickandmorty.di

import com.emirli.rickandmorty.data.api.RickAndMortyAPI
import com.emirli.rickandmorty.data.api.RickAndMortyAPI.Companion.BASE_URL
import com.emirli.rickandmorty.data.repository.RickAndMortyRepository
import com.emirli.rickandmorty.domain.repository.RickAndMortyRepositoryImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideRickAndMortyAPI(retrofit: Retrofit): RickAndMortyAPI =
        retrofit.create(RickAndMortyAPI::class.java)

    @Provides
    fun providesRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = Gson()

    @Provides
    fun provideRepository(api: RickAndMortyAPI): RickAndMortyRepository =
        RickAndMortyRepositoryImpl(api)

}