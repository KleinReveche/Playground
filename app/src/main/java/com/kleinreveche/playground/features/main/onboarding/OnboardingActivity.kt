package com.kleinreveche.playground.features.main.onboarding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.kleinreveche.playground.features.main.NavGraph
import com.kleinreveche.playground.ui.theme.PlaygroundAppTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class OnboardingActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)

        setContent {
            PlaygroundAppTheme {

                // Remember a SystemUiController
                val systemUiController = rememberSystemUiController()
                val useDarkIcons = MaterialTheme.colorScheme.isLight()
                val systemBarColor = MaterialTheme.colorScheme.surface

                SideEffect {
                    // Update all of the system bar colors to be transparent, and use
                    // dark icons if we're in light theme
                    systemUiController.setSystemBarsColor(
                        color = systemBarColor,
                        darkIcons = useDarkIcons
                    )

                    // setStatusBarsColor() and setNavigationBarsColor() also exist
                }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Onboarding()
                }

            }
        }
    }
}

@Composable
fun ColorScheme.isLight() = this.background.luminance() > 0.5