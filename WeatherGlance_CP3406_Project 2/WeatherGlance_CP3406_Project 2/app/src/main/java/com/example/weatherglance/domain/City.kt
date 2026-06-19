package com.example.weatherglance.domain

data class City(
    val name: String,
    val country: String,
    val latitude: Double,
    val longitude: Double
) {
    val displayName: String = "$name, $country"
}

val supportedCities = listOf(
    City("Townsville", "Australia", -19.2589635, 146.8169483),
    City("Cairns", "Australia", -16.9203338, 145.7708595),
    City("Brisbane", "Australia", -27.4697707, 153.0251235),
    City("Sydney", "Australia", -33.8688197, 151.2092955),
    City("Singapore", "Singapore", 1.352083, 103.819839),
    City("London", "United Kingdom", 51.5072178, -0.1275862)
)
