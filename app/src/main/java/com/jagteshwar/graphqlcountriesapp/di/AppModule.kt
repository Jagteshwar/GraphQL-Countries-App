package com.jagteshwar.graphqlcountriesapp.di

import android.app.Application
import com.apollographql.apollo3.ApolloClient
import com.jagteshwar.graphqlcountriesapp.data.ApolloCountryClient
import com.jagteshwar.graphqlcountriesapp.domain.CountryClient
import com.jagteshwar.graphqlcountriesapp.domain.GetCountriesUseCase
import com.jagteshwar.graphqlcountriesapp.domain.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient = ApolloClient.Builder()
        .serverUrl("https://countries.trevorblades.com/graphql")
        .build()

    @Provides
    @Singleton
    fun providesCountryClient(apolloClient: ApolloClient): CountryClient = ApolloCountryClient(apolloClient)

    @Provides
    @Singleton
    fun providesGetCountriesUseCase(countryClient: CountryClient): GetCountriesUseCase = GetCountriesUseCase(countryClient)

    @Provides
    @Singleton
    fun providesGetCountryUseCase(countryClient: CountryClient): GetCountryUseCase = GetCountryUseCase(countryClient)
}
