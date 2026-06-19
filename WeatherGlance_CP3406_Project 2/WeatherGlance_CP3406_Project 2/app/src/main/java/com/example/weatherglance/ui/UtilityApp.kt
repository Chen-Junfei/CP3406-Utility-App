package com.example.weatherglance.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

private enum class AppTab(val label: String, val iconLabel: String) {
    Utility("Utility", "☀"),
    Settings("Settings", "⚙")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UtilityApp(viewModel: WeatherViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var selectedTab by rememberSaveable { mutableStateOf(AppTab.Utility) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("WeatherGlance") })
        },
        bottomBar = {
            NavigationBar {
                AppTab.entries.forEach { tab ->
                    NavigationBarItem(
                        selected = selectedTab == tab,
                        onClick = { selectedTab = tab },
                        icon = { Text(tab.iconLabel) },
                        label = { Text(tab.label) }
                    )
                }
            }
        }
    ) { padding ->
        when (selectedTab) {
            AppTab.Utility -> UtilityScreen(
                uiState = uiState,
                onRefresh = viewModel::refreshWeather,
                modifier = Modifier.padding(padding)
            )

            AppTab.Settings -> SettingsScreen(
                uiState = uiState,
                onCitySelected = viewModel::selectCity,
                onUnitSelected = viewModel::selectUnit,
                onShowDetailsChanged = viewModel::setShowDetails,
                modifier = Modifier.padding(padding)
            )
        }
    }
}
