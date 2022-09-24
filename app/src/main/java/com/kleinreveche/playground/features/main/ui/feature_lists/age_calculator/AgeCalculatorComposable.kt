package com.kleinreveche.playground.features.main.ui.feature_lists.age_calculator

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.kleinreveche.playground.features.age_calculator.AgeCalculatorLegacyActivity
import com.kleinreveche.playground.features.age_calculator.MaterialAgeCalculatorActivity

@Composable
fun AgeCalculatorComposable(){
    val context = LocalContext.current
    context.startActivity(Intent(context, MaterialAgeCalculatorActivity::class.java))
    AgeCalculatorListNavGraph()
}

@Composable
fun AgeCalculatorLegacyComposable(){
    val context = LocalContext.current
    context.startActivity(Intent(context, AgeCalculatorLegacyActivity::class.java))
    AgeCalculatorListNavGraph()
}


const val AgeCalculatorFeatureRoute = "ageCalculator"