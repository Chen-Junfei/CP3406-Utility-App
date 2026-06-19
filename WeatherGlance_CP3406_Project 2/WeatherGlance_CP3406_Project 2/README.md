# WeatherGlance - CP3406 Assessment 1 Utility App

WeatherGlance is a focused utility-style Android app built with Kotlin and Jetpack Compose. It gives rapid, at-a-glance current weather information for a selected city. The app has two screens: a main utility screen and a settings screen. The settings screen controls the city, temperature unit, and whether detailed weather metrics are displayed on the main screen.

## Core features

- **At-a-glance utility screen:** current temperature, condition, apparent temperature, update time, and optional humidity/wind/rain metrics.
- **Settings screen:** changes the city, Celsius/Fahrenheit unit, and compact/detailed display mode.
- **Networking:** fetches live weather data from the Open-Meteo Forecast API using Retrofit and Moshi.
- **Modern Android architecture:** ViewModel, Repository pattern, Hilt dependency injection, StateFlow UI state, and lifecycle-aware Compose collection.
- **Jetpack Compose + Material Design 3:** modular Composables, Material3 cards, bottom navigation, chips, switch controls, and responsive spacing.

## Technical mapping to CP3406 Weeks 1-5

| Week | Topic | Implementation in this project |
| --- | --- | --- |
| 1 | Kotlin and Android Studio setup | Kotlin source code, Gradle Kotlin DSL project structure |
| 2 | Layouts using Jetpack Compose | `UtilityScreen`, `SettingsScreen`, reusable cards and rows |
| 3 | Material Design 3 principles | `MaterialTheme`, `Scaffold`, `NavigationBar`, `ElevatedCard`, `FilterChip`, `Switch` |
| 4 | App architecture | `WeatherViewModel`, `WeatherRepository`, Hilt DI modules, immutable UI state |
| 5 | Web APIs using Retrofit | `WeatherApi` interface and repository data mapping |

## How to run

1. Open the project folder in Android Studio.
2. Allow Gradle to sync.
3. Run the `app` configuration on an emulator or Android device.
4. Ensure the device/emulator has internet access.

## Main source files

- `MainActivity.kt` - app entry point and Compose content setup.
- `UtilityApp.kt` - scaffold and bottom navigation.
- `UtilityScreen.kt` - main weather utility screen.
- `SettingsScreen.kt` - settings controls that update the main screen.
- `WeatherViewModel.kt` - state management and user actions.
- `WeatherRepository.kt` / `WeatherRepositoryImpl.kt` - data access abstraction and implementation.
- `WeatherApi.kt` - Retrofit API interface.
- `AppModule.kt` - Hilt dependency injection setup.

## Notes for submission

Create a GitHub repository, commit the project regularly, and replace this section with your repository URL before submission. The assignment requires the repository link to be shared with teaching staff.

Example placeholder: `https://github.com/YOUR_USERNAME/WeatherGlance`

## AI use declaration

This project package includes `AI_Declaration.md`. Edit it so it accurately describes your own use of AI tools and submit it if required by the subject instructions.
