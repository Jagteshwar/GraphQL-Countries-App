package com.jagteshwar.graphqlcountriesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.jagteshwar.graphqlcountriesapp.presentation.CountriesScreen
import com.jagteshwar.graphqlcountriesapp.presentation.CountriesViewModel
import com.jagteshwar.graphqlcountriesapp.ui.theme.GraphQLCountriesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GraphQLCountriesAppTheme {

                val viewModel = hiltViewModel<CountriesViewModel>()
                val state by viewModel.state.collectAsState()

                CountriesScreen(
                    state = state,
                    onSelectCountry = viewModel::selectedCountry,
                    onDismissCountryDialog = viewModel::dismissCountryDialog
                )
            }
        }
    }
}