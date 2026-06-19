package com.example.weatherglance.domain

data class WeatherSnapshot(
    val city: City,
    val temperature: Double,
    val apparentTemperature: Double,
    val humidity: Int,
    val precipitation: Double,
    val windSpeed: Double,
    val weatherCode: Int,
    val updatedTime: String,
    val unit: TemperatureUnit
) {
    val condition: String = weatherCode.toWeatherCondition()
}

fun Int.toWeatherCondition(): String = when (this) {
    0 -> "Clear sky"
    1, 2, 3 -> "Partly cloudy"
    45, 48 -> "Foggy"
    51, 53, 55 -> "Light drizzle"
    56, 57 -> "Freezing drizzle"
    61, 63, 65 -> "Rain"
    66, 67 -> "Freezing rain"
    71, 73, 75 -> "Snowfall"
    77 -> "Snow grains"
    80, 81, 82 -> "Rain showers"
    85, 86 -> "Snow showers"
    95 -> "Thunderstorm"
    96, 99 -> "Thunderstorm with hail"
    else -> "Weather update"
}
