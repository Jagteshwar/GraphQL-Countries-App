package com.jagteshwar.graphqlcountriesapp.domain

import com.jagteshwar.graphqlcountriesapp.domain.model.DetailedCountry
import com.jagteshwar.graphqlcountriesapp.domain.model.SimpleCountry

interface CountryClient {

    suspend fun getCountries(): List<SimpleCountry>
    suspend fun getCountry(code: String): DetailedCountry?
}