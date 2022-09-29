package com.kleinreveche.playground

import android.app.Activity
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kleinreveche.playground.core.util.helpers.PreferenceHelper
import com.kleinreveche.playground.core.util.helpers.Preferences
import com.kleinreveche.playground.ui.nav.startFeature
import com.kleinreveche.playground.ui.nav.NavGraph
import com.kleinreveche.playground.ui.onboarding.OnboardingActivity
import com.kleinreveche.playground.ui.theme.PlaygroundAppTheme
import com.kleinreveche.playground.ui.theme.ThemeUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        
        setContent {
            PlaygroundApp()
        }
    }
}

@Composable
fun PlaygroundApp() {
    val activity = (LocalContext.current as? Activity)
    val themeUtils: ThemeUtils = viewModel()
        PlaygroundAppTheme (
            darkTheme = themeUtils.darkMode,
            dynamicColor = themeUtils.materialYou
        ) {
            val isBoardingDone = PreferenceHelper[Preferences.IS_ONBOARDING_DONE, false]
            if(isBoardingDone as Boolean) {
                startFeature({NavGraph()})
            } else {
                    val context = LocalContext.current
                    context.startActivity(Intent(context, OnboardingActivity::class.java))
                    activity?.finish()
                }
            }
        }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PlaygroundAppTheme {
        NavGraph()
    }
}
