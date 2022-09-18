package com.kleinreveche.playground.features.main.presentation.age_calculator

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.kleinreveche.playground.features.age_calculator.AgeCalculatorLegacyActivity
import com.kleinreveche.playground.features.age_calculator.MaterialAgeCalculatorActivity

@Composable
fun AgeCalculatorComposable(navController: NavController){
    val context = LocalContext.current
    context.startActivity(Intent(context, MaterialAgeCalculatorActivity::class.java))
    navController.popBackStack(route = AgeCalculatorListRoute, inclusive = false)
}

@Composable
fun AgeCalculatorLegacyComposable(navController: NavController){
    val context = LocalContext.current
    context.startActivity(Intent(context, AgeCalculatorLegacyActivity::class.java))
    navController.popBackStack(route = AgeCalculatorListRoute, inclusive = false)
}


const val AgeCalculatorFeatureRoute = "ageCalculator"
const val AgeCalculatorLegacyFeatureRoute = "ageCalculatorLegacy"
