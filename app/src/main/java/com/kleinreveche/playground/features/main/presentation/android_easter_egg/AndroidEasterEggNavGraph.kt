package com.kleinreveche.playground.features.main.presentation.android_easter_egg

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kleinreveche.playground.features.main.model.AndroidEasterEggsListOf
import com.kleinreveche.playground.features.main.model.Gingerbread
import com.kleinreveche.playground.features.main.model.Honeycomb

@Composable
fun AndroidEasterEggNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AndroidEasterEggListRoute
    ) {
        composable(AndroidEasterEggListRoute) {
            AndroidEasterEggList(
                androidEasterEggs = AndroidEasterEggsListOf,
                onAndroidEasterEggClick = { androidEasterEggs ->
                    when (androidEasterEggs) {
                        Honeycomb -> navController.navigate(HoneycombFeatureRoute)
                        Gingerbread -> navController.navigate(GingerbreadFeatureRoute)
                        else -> throw IllegalArgumentException("Unknown Android Easter Egg")
                    }
                }
            )
        }
        composable(GingerbreadFeatureRoute) { GingerbreadComposable(navController = navController) }
        composable(HoneycombFeatureRoute) { HoneycombComposable(navController = navController) }
    }
}

const val AndroidEasterEggListRoute = "androidEasterEggList"