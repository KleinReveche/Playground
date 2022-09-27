package com.kleinreveche.playground.features.age_calculator.legacy

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController

@Composable
fun AgeCalculatorComposable(navController: NavHostController) {
    val context = LocalContext.current
    context.startActivity(Intent(context, MaterialAgeCalculatorActivity::class.java))
    navController.popBackStack()

}

@Composable
fun AgeCalculatorLegacyComposable(navController: NavHostController){
    val context = LocalContext.current
    context.startActivity(Intent(context, AgeCalculatorLegacyActivity::class.java))
    navController.popBackStack()
}
