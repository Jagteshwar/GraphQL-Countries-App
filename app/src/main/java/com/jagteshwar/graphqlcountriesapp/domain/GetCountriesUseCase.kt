package com.jagteshwar.graphqlcountriesapp.domain

import com.jagteshwar.graphqlcountriesapp.domain.model.SimpleCountry

class GetCountriesUseCase(
    private val countryClient: CountryClient
) {

    suspend fun execute(): List<SimpleCountry>{
        return countryClient
            .getCountries()
            .sortedBy { it.name }
    }
}