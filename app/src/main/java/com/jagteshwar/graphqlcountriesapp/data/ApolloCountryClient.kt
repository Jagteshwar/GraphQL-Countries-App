package com.jagteshwar.graphqlcountriesapp.data

import com.apollographql.apollo3.ApolloClient
import com.jagteshwar.CountriesQuery
import com.jagteshwar.CountryQuery
import com.jagteshwar.graphqlcountriesapp.domain.CountryClient
import com.jagteshwar.graphqlcountriesapp.domain.model.DetailedCountry
import com.jagteshwar.graphqlcountriesapp.domain.model.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
): CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map{ it.toSimpleCountry()}
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}