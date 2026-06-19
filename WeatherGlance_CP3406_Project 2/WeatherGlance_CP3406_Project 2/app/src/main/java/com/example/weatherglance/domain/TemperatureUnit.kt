package com.example.weatherglance.domain

enum class TemperatureUnit(
    val label: String,
    val apiValue: String,
    val symbol: String,
    val windApiValue: String,
    val windSymbol: String
) {
    CELSIUS("Celsius", "celsius", "°C", "kmh", "km/h"),
    FAHRENHEIT("Fahrenheit", "fahrenheit", "°F", "mph", "mph")
}
