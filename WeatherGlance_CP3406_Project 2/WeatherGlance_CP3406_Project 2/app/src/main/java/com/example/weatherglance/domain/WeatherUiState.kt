package com.example.weatherglance.domain

data class WeatherUiState(
    val cities: List<City> = supportedCities,
    val selectedCity: City = supportedCities.first(),
    val unit: TemperatureUnit = TemperatureUnit.CELSIUS,
    val showDetails: Boolean = true,
    val isLoading: Boolean = false,
    val weather: WeatherSnapshot? = null,
    val errorMessage: String? = null
)
