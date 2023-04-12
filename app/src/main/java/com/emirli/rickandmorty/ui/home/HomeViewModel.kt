package com.emirli.rickandmorty.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.emirli.rickandmorty.data.datasource.RickAndMortyDataSource
import com.emirli.rickandmorty.domain.usecase.GetCharacterListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase,
) : ViewModel() {

    val pager = Pager(
        config = PagingConfig(pageSize = 1),
        pagingSourceFactory = {
            RickAndMortyDataSource(getCharacterListUseCase)
        }
    ).flow.cachedIn(viewModelScope)
}
