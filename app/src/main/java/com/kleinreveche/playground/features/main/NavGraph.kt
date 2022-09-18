package com.kleinreveche.playground.features.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kleinreveche.playground.features.cafeteria.CafeteriaApp
import com.kleinreveche.playground.features.cafeteria.CafeteriaFeatureRoute
import com.kleinreveche.playground.features.cupcake.CupcakeApp
import com.kleinreveche.playground.features.cupcake.CupcakeFeatureRoute
import com.kleinreveche.playground.features.dessert.DessertClickerApp
import com.kleinreveche.playground.features.dessert.DessertClickerFeatureRoute
import com.kleinreveche.playground.features.dessert.data.Datasource
import com.kleinreveche.playground.features.dice.DiceRollerApp
import com.kleinreveche.playground.features.dice.DiceRollerFeatureRoute
import com.kleinreveche.playground.features.lemonade.LemonApp
import com.kleinreveche.playground.features.lemonade.LemonadeFeatureRoute
import com.kleinreveche.playground.features.main.model.*
import com.kleinreveche.playground.features.main.presentation.age_calculator.AgeCalculatorListRoute
import com.kleinreveche.playground.features.main.presentation.age_calculator.AgeCalculatorNavGraph
import com.kleinreveche.playground.features.main.presentation.android_easter_egg.AndroidEasterEggListRoute
import com.kleinreveche.playground.features.main.presentation.android_easter_egg.AndroidEasterEggNavGraph
import com.kleinreveche.playground.features.main.presentation.main.MainList
import com.kleinreveche.playground.features.notes.NotesApp
import com.kleinreveche.playground.features.notes.NotesFeatureRoute

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = FeatureRoute
    ) {
        composable(FeatureRoute) {
            MainList(
                features = FeatureList,
                onFeatureClick = { feature ->
                    when (feature) {
                        DiceRollerFeature -> navController.navigate(DiceRollerFeatureRoute)
                        DessertClickerFeature -> navController.navigate(DessertClickerFeatureRoute)
                        CupcakeFeature -> navController.navigate(CupcakeFeatureRoute)
                        CafeteriaFeature -> navController.navigate(CafeteriaFeatureRoute)
                        NotesFeature -> navController.navigate(NotesFeatureRoute)
                        LemonadeFeature -> navController.navigate(LemonadeFeatureRoute)

                        else -> throw IllegalArgumentException("Unknown Feature")
                    }
                },
                featureLists = FeatureListsOf,
                onFeatureListClick = { featureList ->
                    when (featureList) {
                        AgeCalculatorsList -> navController.navigate(AgeCalculatorListRoute)
                        AndroidEasterEggList -> navController.navigate(AndroidEasterEggListRoute)

                        else -> throw IllegalArgumentException("Unknown Feature List")
                    }
                }
            )
        }
        composable(AgeCalculatorListRoute) { AgeCalculatorNavGraph() }
        composable(AndroidEasterEggListRoute) { AndroidEasterEggNavGraph() }
        composable(DiceRollerFeatureRoute) { DiceRollerApp() }
        composable(DessertClickerFeatureRoute) { DessertClickerApp(desserts = Datasource.dessertList) }
        composable(CupcakeFeatureRoute) { CupcakeApp() }
        composable(CafeteriaFeatureRoute) { CafeteriaApp() }
        composable(NotesFeatureRoute) { NotesApp() }
        composable(LemonadeFeatureRoute) { LemonApp() }
    }
}

const val FeatureRoute = "feature"