package com.emirli.rickandmorty.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emirli.rickandmorty.domain.usecase.GetCharacterDetailUseCase
import com.emirli.rickandmorty.util.navigation.CHARACTER_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase,
    private val savedStateHandle: SavedStateHandle? = null
) : ViewModel() {

    private val _stateFlow = MutableStateFlow<DetailState>(DetailState.Loading)
    val stateFlow: StateFlow<DetailState>
        get() = _stateFlow.asStateFlow()

    private val handler = CoroutineExceptionHandler { _, exception ->
        pushState(DetailState.Error(errorMessage = exception.message.orEmpty()))
    }

    init {
        savedStateHandle?.get<String>(CHARACTER_ID)?.let { id ->
            fetchCharacterDetail(id.toInt())
        }
    }

    private fun fetchCharacterDetail(id: Int) {
        viewModelScope.launch(handler) {
            val uiModel = getCharacterDetailUseCase.run(GetCharacterDetailUseCase.Params(id = id))
            pushState(DetailState.Content(uiModel = uiModel))
        }
    }

    fun retry() {
        savedStateHandle?.get<String>(CHARACTER_ID)?.let { id ->
            fetchCharacterDetail(id.toInt())
        }
    }

    private fun pushState(state: DetailState) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateFlow.value = state
        }
    }
}