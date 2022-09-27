package com.kleinreveche.playground.ui.nav.features.lists

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kleinreveche.playground.R
import com.kleinreveche.playground.features.age_calculator.*
import com.kleinreveche.playground.features.age_calculator.legacy.AgeCalculatorComposable
import com.kleinreveche.playground.features.age_calculator.legacy.AgeCalculatorLegacyComposable
import com.kleinreveche.playground.features.age_calculator.legacy.AgeCalculatorLegacyFeatureRoute
import com.kleinreveche.playground.features.age_calculator.legacy.AgeCalculatorMaterialFeatureRoute
import com.kleinreveche.playground.ui.nav.features.FeatureItem
import com.kleinreveche.playground.ui.nav.features.FeatureScaffold
import com.kleinreveche.playground.ui.nav.model.*
import com.kleinreveche.playground.ui.theme.settings.SettingsRoute
import com.kleinreveche.playground.ui.theme.settings.SettingsScreen

@Composable
fun AgeCalculatorsListNav(
    navController: NavController,
    startDestination: String,
) {
    NavHost(
    navController = navController as NavHostController,
    startDestination = startDestination
    ) {
        composable(AgeCalculatorsFeatureListRoute) {
            AgeCalculatorListComponent(
                ageCalculatorFeatureList = AgeCalculatorList,
                ageCalculatorFeatureClick = { ageCalculatorFeatureList: AgeCalculatorsList ->
                    when (ageCalculatorFeatureList) {
                        AgeCalculatorFeature -> navController.navigate(AgeCalculatorMaterialFeatureRoute)
                        AgeCalculatorLegacyFeature -> navController.navigate(AgeCalculatorLegacyFeatureRoute)
                        AgeCalculatorComposeFeature -> navController.navigate(AgeCalculatorComposeFeatureRoute)
                    }
                },
                onClick = { navController.navigate(SettingsRoute) }
            )

        }
        composable(AgeCalculatorMaterialFeatureRoute) { AgeCalculatorComposable(navController) }
        composable(AgeCalculatorLegacyFeatureRoute) { AgeCalculatorLegacyComposable(navController) }
        composable(SettingsRoute) { SettingsScreen(navController) }
        composable(AgeCalculatorComposeFeatureRoute) { AgeCalculator() }
    }

}

@Composable
fun AgeCalculatorListComponent(
    ageCalculatorFeatureList: List<AgeCalculatorsList>,
    ageCalculatorFeatureClick: (featureList: AgeCalculatorsList) -> Unit,
    onClick: () -> Unit = {}
) {
    FeatureScaffold(
        topBarTitle = stringResource(id = R.string.app_name),
        onClick = onClick
    ) { paddingValues ->
        LazyColumn(
            content = {
                item {
                    Text(
                        text = stringResource(id = R.string.age_calc_list),
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.height(FeaturePadding))
                }
                items(ageCalculatorFeatureList) { ageCalculatorFeatureList ->
                    FeatureItem(
                        ageCalculatorsList = ageCalculatorFeatureList,
                        onClickAgeCalculatorsFeatureList = ageCalculatorFeatureClick
                    )
                    Spacer(modifier = Modifier.height(FeatureItemListPadding))
                }
            },
            contentPadding = WindowInsets.safeDrawing
                .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
                .add(
                    WindowInsets(
                        left = FeaturePadding,
                        top = FeaturePadding,
                        right = FeaturePadding,
                    )
                )
                .asPaddingValues(),
            modifier = Modifier.padding(paddingValues)
        )
    }
}

private val FeaturePadding = 16.dp
private val FeatureItemListPadding = 8.dp

const val AgeCalculatorsFeatureListRoute = "ageCalculatorList"