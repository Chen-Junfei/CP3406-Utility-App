package com.example.weatherglance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.weatherglance.ui.UtilityApp
import com.example.weatherglance.ui.theme.WeatherGlanceTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherGlanceTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    UtilityApp()
                }
            }
        }
    }
}
