package com.kleinreveche.playground

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kleinreveche.playground.core.util.helpers.PreferenceHelper
import com.kleinreveche.playground.core.util.helpers.Preferences
import com.kleinreveche.playground.features.main.NavGraph
import com.kleinreveche.playground.features.main.onboarding.OnboardingActivity
import com.kleinreveche.playground.ui.theme.PlaygroundAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        
        setContent {
            PlaygroundAppTheme {

                val systemUiController = rememberSystemUiController()
                val useDarkIcons = MaterialTheme.colorScheme.isLight()
                val systemBarColor = MaterialTheme.colorScheme.surface
               
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = systemBarColor,
                        darkIcons = useDarkIcons
                    )
                    
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val isBoardingDone = PreferenceHelper[Preferences.IS_ONBOARDING_DONE, false]
                    if(isBoardingDone as Boolean) {
                        NavGraph()
                    } else {
                        val context = LocalContext.current
                        context.startActivity(Intent(context, OnboardingActivity::class.java))
                        finish()
                    }
                }

            }
        }
    }
}

@Composable
fun ColorScheme.isLight() = this.background.luminance() > 0.5

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PlaygroundAppTheme {
        NavGraph()
    }
}
