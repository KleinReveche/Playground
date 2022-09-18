package com.kleinreveche.playground.features.main.presentation.age_calculator

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kleinreveche.playground.features.main.model.*

@Composable
fun AgeCalculatorNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AgeCalculatorListRoute
    ) {
        composable(AgeCalculatorListRoute) {
            AgeCalculatorList(
                ageCalculators = AgeCalculatorsListOf,
                onAgeCalculatorsClick = { ageCalculators ->
                    when (ageCalculators) {
                        AgeCalculatorLegacy -> navController.navigate(AgeCalculatorLegacyFeatureRoute)
                        AgeCalculatorMaterial -> navController.navigate(AgeCalculatorFeatureRoute)

                        else -> throw IllegalArgumentException("Unknown Age Calculator")
                    }
                }
            )
        }

        composable(AgeCalculatorFeatureRoute) { AgeCalculatorComposable(navController) }
        composable(AgeCalculatorLegacyFeatureRoute) { AgeCalculatorLegacyComposable(navController) }
    }
}

const val AgeCalculatorListRoute = "ageCalculatorList"