package com.example.weatherglance.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherglance.data.repository.WeatherRepository
import com.example.weatherglance.domain.City
import com.example.weatherglance.domain.TemperatureUnit
import com.example.weatherglance.domain.WeatherUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    private var weatherJob: Job? = null

    init {
        refreshWeather()
    }

    fun refreshWeather() {
        weatherJob?.cancel()
        weatherJob = viewModelScope.launch {
            val city = _uiState.value.selectedCity
            val unit = _uiState.value.unit
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }

            runCatching { weatherRepository.fetchCurrentWeather(city, unit) }
                .onSuccess { snapshot ->
                    _uiState.update {
                        it.copy(
                            weather = snapshot,
                            isLoading = false,
                            errorMessage = null
                        )
                    }
                }
                .onFailure { throwable ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = throwable.message ?: "Weather could not be loaded. Check your connection and try again."
                        )
                    }
                }
        }
    }

    fun selectCity(city: City) {
        _uiState.update { it.copy(selectedCity = city) }
        refreshWeather()
    }

    fun selectUnit(unit: TemperatureUnit) {
        _uiState.update { it.copy(unit = unit) }
        refreshWeather()
    }

    fun setShowDetails(showDetails: Boolean) {
        _uiState.update { it.copy(showDetails = showDetails) }
    }
}
