package com.kleinreveche.playground.features.main.presentation.android_easter_egg

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.kleinreveche.playground.features.age_calculator.AgeCalculatorLegacyActivity
import com.kleinreveche.playground.features.age_calculator.MaterialAgeCalculatorActivity
import com.kleinreveche.playground.features.android_easter_eggs.gingerbread.GPlatLogoActivity
import com.kleinreveche.playground.features.android_easter_eggs.honeycomb.HPlatLogoActivity

@Composable
fun GingerbreadComposable(navController: NavController){
    val context = LocalContext.current
    context.startActivity(Intent(context, GPlatLogoActivity::class.java))
    navController.popBackStack(route = AndroidEasterEggListRoute, inclusive = false)
}


@Composable
fun HoneycombComposable(navController: NavController){
    val context = LocalContext.current
    context.startActivity(Intent(context, HPlatLogoActivity::class.java))
    navController.popBackStack(route = AndroidEasterEggListRoute, inclusive = false)
}


const val GingerbreadFeatureRoute = "androidGingerbread"
const val HoneycombFeatureRoute = "androidHoneycomb"

