package com.jagteshwar.graphqlcountriesapp.data

import com.jagteshwar.CountriesQuery
import com.jagteshwar.CountryQuery
import com.jagteshwar.graphqlcountriesapp.domain.model.DetailedCountry
import com.jagteshwar.graphqlcountriesapp.domain.model.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry = DetailedCountry(
    code = code,
    name = name,
    emoji = emoji,
    capital = capital ?: "No capital",
    currency = currency ?: "No Currency",
    languages = languages.map { it.name },
    continent = continent.name
)

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry = SimpleCountry(
    code = code,
    name = name,
    emoji = emoji,
    capital = capital ?: "No capital"
)