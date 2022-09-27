package com.kleinreveche.playground.features.newtonstimer

import androidx.compose.animation.animateColorAsState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.kleinreveche.playground.features.newtonstimer.timer.NewtonsTimerScreen

@Composable
fun NewtonsTimer() {
    val backgroundColor by animateColorAsState(MaterialTheme.colorScheme.background)
    Surface(color = backgroundColor) {
        NewtonsTimerScreen()
    }
}

const val NewtonsTimerFeatureRoute = "newtonsTimerFeature"