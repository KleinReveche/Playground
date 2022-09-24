package com.kleinreveche.playground.features.main.ui.feature_lists.age_calculator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kleinreveche.playground.features.age_calculator.AgeCalculatorLegacyFeatureRoute
import com.kleinreveche.playground.features.main.model.AgeCalculatorFeature
import com.kleinreveche.playground.features.main.model.AgeCalculatorLegacyFeature
import com.kleinreveche.playground.features.main.model.AgeCalculatorList
import com.kleinreveche.playground.features.main.settings.SettingsScreen
import com.kleinreveche.playground.features.main.settings.SettingsRoute

@Composable
fun AgeCalculatorListNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AgeCalculatorsFeatureListRoute
    ) {
        composable(AgeCalculatorsFeatureListRoute) {
            AgeCalculatorListComponent(
                ageCalculatorFeatureList = AgeCalculatorList,
                onSpecificationClick = { feature ->
                    when (feature) {
                        AgeCalculatorFeature -> navController.navigate(AgeCalculatorFeatureRoute)
                        AgeCalculatorLegacyFeature -> navController.navigate(
                            AgeCalculatorLegacyFeatureRoute
                        )
                        else -> throw IllegalArgumentException("Unknown Feature")
                    }
                },
                onClick = { navController.navigate(SettingsRoute) }
            )
        }
        composable(AgeCalculatorFeatureRoute) { AgeCalculatorComposable() }
        composable(AgeCalculatorLegacyFeatureRoute) { AgeCalculatorLegacyComposable() }
        composable(SettingsRoute) { SettingsScreen() }
    }
}

const val AgeCalculatorsFeatureListRoute = "ageCalculatorList"
