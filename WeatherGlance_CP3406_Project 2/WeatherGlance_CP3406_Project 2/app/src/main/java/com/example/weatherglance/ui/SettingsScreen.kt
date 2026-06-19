package com.example.weatherglance.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.weatherglance.domain.City
import com.example.weatherglance.domain.TemperatureUnit
import com.example.weatherglance.domain.WeatherUiState

@Composable
fun SettingsScreen(
    uiState: WeatherUiState,
    onCitySelected: (City) -> Unit,
    onUnitSelected: (TemperatureUnit) -> Unit,
    onShowDetailsChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "These controls update the main utility screen immediately. Settings are kept in memory for this assessment build.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        SettingsGroup(title = "Location") {
            FlowRowLike {
                uiState.cities.forEach { city ->
                    FilterChip(
                        selected = city == uiState.selectedCity,
                        onClick = { onCitySelected(city) },
                        label = { Text(city.displayName) }
                    )
                }
            }
        }

        SettingsGroup(title = "Temperature unit") {
            FlowRowLike {
                TemperatureUnit.entries.forEach { unit ->
                    FilterChip(
                        selected = unit == uiState.unit,
                        onClick = { onUnitSelected(unit) },
                        label = { Text(unit.label) }
                    )
                }
            }
        }

        SettingsGroup(title = "Display") {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("Show detail metrics", style = MaterialTheme.typography.titleMedium)
                    Text(
                        "Humidity, wind and rainfall are useful but can be hidden for a more compact at-a-glance card.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Switch(
                    checked = uiState.showDetails,
                    onCheckedChange = onShowDetailsChanged
                )
            }
        }
    }
}

@Composable
private fun SettingsGroup(title: String, content: @Composable () -> Unit) {
    ElevatedCard(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
            content()
        }
    }
}

@Composable
private fun FlowRowLike(content: @Composable () -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        content()
    }
}
