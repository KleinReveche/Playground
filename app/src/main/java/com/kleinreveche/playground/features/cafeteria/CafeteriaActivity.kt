package com.kleinreveche.playground.features.cafeteria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kleinreveche.playground.ui.theme.PlaygroundAppTheme

class CafeteriaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundAppTheme {
                CafeteriaApp()
            }
        }
    }

}

const val CafeteriaFeatureRoute = "Cafeteria"
