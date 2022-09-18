package com.kleinreveche.playground.features.main.presentation.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kleinreveche.playground.R
import com.kleinreveche.playground.features.main.model.FeatureLists
import com.kleinreveche.playground.features.main.model.Features
import com.kleinreveche.playground.features.main.presentation.feature.FeatureItem
import com.kleinreveche.playground.features.main.presentation.feature.FeatureListItem

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun MainList(
    features: List<Features>,
    onFeatureClick: (feature: Features) -> Unit,
    featureLists: List<FeatureLists>,
    onFeatureListClick: (featureLists: FeatureLists) -> Unit
) {
    MainScaffold(
        topBarTitle = stringResource(id = R.string.app_name)
    ) { paddingValues ->
        LazyColumn(
            content = {
                item {
                    Text(
                        text = stringResource(id = R.string.features),
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.height(FeaturePadding))
                }
                items(featureLists) { featureLists ->
                    FeatureListItem(
                        featureList = featureLists,
                        onClick = onFeatureListClick
                    )
                    Spacer(modifier = Modifier.height(FeatureItemPadding))
                }
                item {
                    Divider(thickness = 1.dp, modifier = Modifier.padding(bottom = 8.dp))
                }
                items(features) { feature ->
                    FeatureItem(
                        feature = feature,
                        onClick = onFeatureClick
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