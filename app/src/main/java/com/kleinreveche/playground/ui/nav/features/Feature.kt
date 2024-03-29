package com.kleinreveche.playground.ui.nav.features

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kleinreveche.playground.R
import com.kleinreveche.playground.ui.nav.model.FeatureListsData
import com.kleinreveche.playground.ui.nav.model.Features

@Composable
fun Feature(
    color: Color,
    featureLists: List<FeatureListsData>,
    onFeatureListClick: (featureList: FeatureListsData) -> Unit,
    features: List<Features>,
    onFeatureClick: (feature: Features) -> Unit,
    onClick: () -> Unit = {}
) {
    FeatureScaffold(
        topBarTitle = stringResource(id = R.string.app_name),
        color = color,
        onClick = onClick
    ) { paddingValues ->
        Surface(color = color) {
            LazyColumn(
                content = {
                    item {
                        Text(
                           text = stringResource(id = R.string.features),
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Spacer(modifier = Modifier.height(FeaturePadding))
                    }
                    items(featureLists) { featureList ->
                        FeatureItem(
                            featureList = featureList,
                            onClickFeatureList = onFeatureListClick
                        )
                        Spacer(modifier = Modifier.height(FeatureItemPadding))
                    }
                    items(features) { feature ->
                        FeatureItem(
                            feature = feature,
                            onClickFeature = onFeatureClick
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
}

private val FeaturePadding = 16.dp
private val FeatureItemPadding = 8.dp
