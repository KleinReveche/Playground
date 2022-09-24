package com.kleinreveche.playground

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.lifecycle.observe
import com.kleinreveche.playground.core.helpers.*
import com.kleinreveche.playground.features.main.NavGraph
import com.kleinreveche.playground.features.main.onboarding.OnboardingActivity
import com.kleinreveche.playground.ui.theme.PlaygroundAppTheme
import dagger.hilt.android.AndroidEntryPoint
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    /* public val mainVm by viewModels<MainActivityViewModel>() */

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
                    systemUiController.setSystemBarsColor(
                        color = systemBarColor,
                        darkIcons = useDarkIcons
                    )
                    /*
		    if(isOnboardingDone == false) 
                        mainVm.saveOnboardingProgress(false)
                    mainVm.getOnboardingProgress.observe(this){
                        isOnboardingDone = it
                    }
                    */
                    
                }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val isBoardingDone = PreferenceHelper.get(Preferences.IS_ONBOARDING_DONE, false)
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
