package com.kleinreveche.playground.ui.nav

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
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
import com.kleinreveche.playground.features.newtonstimer.NewtonsTimer
import com.kleinreveche.playground.features.newtonstimer.NewtonsTimerFeatureRoute
import com.kleinreveche.playground.ui.theme.settings.SettingsRoute
import com.kleinreveche.playground.ui.theme.settings.SettingsScreen
import com.kleinreveche.playground.features.notes.NotesApp
import com.kleinreveche.playground.features.notes.NotesFeatureRoute
import com.kleinreveche.playground.features.tictactoe.TicTacToe
import com.kleinreveche.playground.features.tictactoe.TicTacToeFeatureRoute
import com.kleinreveche.playground.features.unscramble.ui.UnscrambleFeatureRoute
import com.kleinreveche.playground.features.unscramble.ui.UnscrambleGameScreen
import com.kleinreveche.playground.ui.nav.features.Feature
import com.kleinreveche.playground.ui.nav.features.lists.AgeCalculatorsFeatureListRoute
import com.kleinreveche.playground.ui.nav.features.lists.AgeCalculatorsListNav
import com.kleinreveche.playground.ui.nav.model.*
import com.kleinreveche.playground.ui.theme.PlaygroundAppTheme
import com.kleinreveche.playground.ui.theme.isLight
import com.kleinreveche.playground.ui.theme.ThemeUtils

@Composable
fun NavGraph(color: Color = MaterialTheme.colorScheme.background) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = FeatureRoute
    ) {
        composable(FeatureRoute) {
            Feature(
                color = color,
                featureLists = FeatureListsOf,
                onFeatureListClick = { featureList: FeatureListsData ->
                    when (featureList) {
                        AgeCalculatorsFeatureList -> navController.navigate(AgeCalculatorsFeatureListRoute)
                    }
                },
                features = FeatureList,
                onFeatureClick = { feature: Features ->
                    when (feature) {
                        DiceRollerFeature -> navController.navigate(DiceRollerFeatureRoute)
                        DessertClickerFeature -> navController.navigate(DessertClickerFeatureRoute)
                        CupcakeFeature -> navController.navigate(CupcakeFeatureRoute)
                        CafeteriaFeature -> navController.navigate(CafeteriaFeatureRoute)
                        NotesFeature -> navController.navigate(NotesFeatureRoute)
                        LemonadeFeature -> navController.navigate(LemonadeFeatureRoute)
                        UnscrambleFeature -> navController.navigate(UnscrambleFeatureRoute)
                        TicTacToeFeature -> navController.navigate(TicTacToeFeatureRoute)
                        NewtonsTimerFeature -> navController.navigate(NewtonsTimerFeatureRoute)
                        else -> throw IllegalArgumentException("Unknown Feature")
                    }
                },
                onClick = { navController.navigate(SettingsRoute) }
            )

        }
        composable(AgeCalculatorsFeatureListRoute) {startFeature({AgeCalculatorsListNav()})}
        composable(DiceRollerFeatureRoute) {startFeature({DiceRollerApp()})}
        composable(DessertClickerFeatureRoute) {startFeature({DessertClickerApp(desserts = Datasource.dessertList)})}
        composable(CupcakeFeatureRoute) {startFeature({CupcakeApp()})}
        composable(CafeteriaFeatureRoute) {startFeature({CafeteriaApp()})}
        composable(NotesFeatureRoute) {startFeature({NotesApp()})}
        composable(LemonadeFeatureRoute) {startFeature({LemonApp() })}
        composable(UnscrambleFeatureRoute) { startFeature({UnscrambleGameScreen()}) }
        composable(SettingsRoute) { startFeature({SettingsScreen(navController) })}
        composable(TicTacToeFeatureRoute) { startFeature({TicTacToe()}) }
        composable(NewtonsTimerFeatureRoute) { NewtonsTimer() }
    }
}

@Composable
fun startFeature( feature:  @Composable () -> Unit ) {
    val themeUtils: ThemeUtils = viewModel()
    PlaygroundAppTheme (
        darkTheme = themeUtils.darkMode,
        dynamicColor = themeUtils.materialYou
    ) {
        val systemUiController = rememberSystemUiController()
        val useDarkIcons = MaterialTheme.colorScheme.isLight()
        val systemBarColor = MaterialTheme.colorScheme.surface   
        systemUiController.setSystemBarsColor(
            color = systemBarColor,
            darkIcons = useDarkIcons 
        )
        feature()
    }
}

private const val FeatureRoute = "feature"
