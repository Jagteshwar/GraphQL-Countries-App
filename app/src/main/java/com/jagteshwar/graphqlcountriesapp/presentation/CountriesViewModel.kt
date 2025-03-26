package com.jagteshwar.graphqlcountriesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jagteshwar.graphqlcountriesapp.domain.GetCountriesUseCase
import com.jagteshwar.graphqlcountriesapp.domain.GetCountryUseCase
import com.jagteshwar.graphqlcountriesapp.domain.model.DetailedCountry
import com.jagteshwar.graphqlcountriesapp.domain.model.SimpleCountry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getCountryUseCase: GetCountryUseCase,
    private val getCountriesUseCase: GetCountriesUseCase
): ViewModel() {

    private val _state = MutableStateFlow(CountriesState())
    val state: StateFlow<CountriesState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update { it.copy(
                isLoading = true
            ) }
            _state.update { it.copy(
                countries = getCountriesUseCase.execute(),
                isLoading = false
            ) }
        }
    }

    fun selectedCountry(code: String){
        viewModelScope.launch {
            _state.update { it.copy(
                selectedCountry = getCountryUseCase.execute(code)
            ) }
        }
    }

    fun dismissCountryDialog(){
        _state.update { it.copy(
            selectedCountry = null
        ) }
    }
    data class CountriesState(
        val countries: List<SimpleCountry> = emptyList(),
        val selectedCountry: DetailedCountry? = null,
        val isLoading: Boolean = false
    )
}