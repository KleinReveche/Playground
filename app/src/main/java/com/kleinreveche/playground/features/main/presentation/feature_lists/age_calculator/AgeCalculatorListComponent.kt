package com.kleinreveche.playground.features.main.presentation.feature_lists.age_calculator

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kleinreveche.playground.R
import com.kleinreveche.playground.features.main.model.AgeCalculatorsFeatures
import com.kleinreveche.playground.features.main.presentation.FeatureScaffold

@Composable
fun AgeCalculatorListComponent(
    ageCalculatorFeatureList: List<AgeCalculatorsFeatures>,
    onSpecificationClick: (ageCalculatorFeatureList: AgeCalculatorsFeatures) -> Unit,
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
                    AgeCalculatorListItem(
                        ageCalculatorItem = ageCalculatorFeatureList,
                        onClick = onSpecificationClick
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
