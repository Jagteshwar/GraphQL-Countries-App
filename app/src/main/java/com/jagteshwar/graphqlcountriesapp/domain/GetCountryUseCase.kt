package com.jagteshwar.graphqlcountriesapp.domain

import com.jagteshwar.graphqlcountriesapp.domain.model.DetailedCountry

class GetCountryUseCase(
    private val countryClient: CountryClient
) {

    suspend fun execute(code: String): DetailedCountry? {
        return countryClient.getCountry(code)
    }
}