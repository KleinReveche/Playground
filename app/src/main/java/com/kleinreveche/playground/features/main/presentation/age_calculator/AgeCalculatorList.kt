package com.kleinreveche.playground.features.main.presentation.age_calculator

import androidx.compose.foundation.ExperimentalFoundationApi
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
import com.kleinreveche.playground.features.main.model.AgeCalculators
import com.kleinreveche.playground.features.main.presentation.main.MainScaffold

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun AgeCalculatorList(
    ageCalculators: List<AgeCalculators>,
    onAgeCalculatorsClick: (feature: AgeCalculators) -> Unit
) {
    MainScaffold(
    topBarTitle = stringResource(id = R.string.app_name)
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
            items(ageCalculators) { feature ->
                AgeCalculatorItem(
                    ageCalculators = feature,
                    onClick = onAgeCalculatorsClick
                )
                Spacer(modifier = Modifier.height(FeatureItemPadding))
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
private val FeatureItemPadding = 8.dp