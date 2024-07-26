package com.stanroy.jetdex.presentation.pokemon_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stanroy.jetdex.domain.usecases.GetMonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(private val getMonListUseCase: GetMonListUseCase) :
    ViewModel() {

    private val _pokemonList = MutableStateFlow(
        listOf(
            "pokemon1",
            "pokemon2",
            "pokemon3",
            "pokemon4",
            "pokemon5",
            "pokemon1",
            "pokemon2",
            "pokemon3",
            "pokemon4",
            "pokemon5",
            "pokemon1",
            "pokemon2",
            "pokemon3",
            "pokemon4",
            "pokemon5"
        )
    )
    val pokemonList = _pokemonList.asStateFlow()

    init {

        viewModelScope.launch {
            getMonListUseCase.invoke(50, 0)
        }

    }
}