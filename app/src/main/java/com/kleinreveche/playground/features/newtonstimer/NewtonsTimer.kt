package com.kleinreveche.playground.features.newtonstimer

import androidx.compose.animation.animateColorAsState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kleinreveche.playground.ui.theme.PlaygroundAppTheme
import com.kleinreveche.playground.ui.theme.ThemeUtils
import com.kleinreveche.playground.features.newtonstimer.timer.NewtonsTimerScreen
import com.kleinreveche.playground.features.newtonstimer.timer.TimerViewModel

@Composable
fun NewtonsTimer() {
    val backgroundColor by animateColorAsState(MaterialTheme.colorScheme.background)
    val viewModel: TimerViewModel = viewModel()
    val themeUtils: ThemeUtils = viewModel()

    PlaygroundAppTheme (
        darkTheme = themeUtils.darkMode
    ) {
       viewModel.darkMode = themeUtils.darkMode
       Surface(color = MaterialTheme.colorScheme.background) {
            NewtonsTimerScreen()
        } 
    }
}

const val NewtonsTimerFeatureRoute = "newtonsTimerFeature"