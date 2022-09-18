package com.kleinreveche.playground.features.android_easter_eggs.honeycomb

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.kleinreveche.playground.R
import com.kleinreveche.playground.isLight
import com.kleinreveche.playground.ui.theme.PlaygroundAppTheme

class HPlatLogoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
                HoneycombPlatformLogoApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HoneycombPlatformLogoApp(){

    val context = LocalContext.current
    Surface(
        color = Color.Black.copy(alpha = 0f)
    ){
        Scaffold() { paddingValues ->
            Modifier.padding(paddingValues)
            Box {
                Image(
                    modifier = Modifier.fillMaxSize().clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        enabled = true,
                        onClickLabel = R.string.easter_egg_honeycomb_label.toString(),
                        onClick = {
                            Toast
                                .makeText(
                                    context,
                                    R.string.easter_egg_honeycomb_label,
                                    Toast.LENGTH_LONG
                                ).show()
                        }
                    ),
                    painter = painterResource(id = R.drawable.h_platlogo),
                    contentDescription = R.string.easter_egg_honeycomb_label.toString(),
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

const val HoneycombFeatureRoute = "androidEasterEggHoneycomb"