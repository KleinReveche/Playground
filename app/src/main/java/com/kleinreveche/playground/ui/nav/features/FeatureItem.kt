package com.kleinreveche.playground.ui.nav.features

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kleinreveche.playground.ui.nav.model.AgeCalculatorsList
import com.kleinreveche.playground.ui.nav.model.FeatureListsData
import com.kleinreveche.playground.ui.nav.model.Features

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureItem(
    feature: Features? = null,
    featureList: FeatureListsData? = null,
    ageCalculatorsList: AgeCalculatorsList? = null,
    onClickFeature: ((feature: Features) -> Unit)? = null,
    onClickFeatureList: ((featureList: FeatureListsData) -> Unit)? = null,
    onClickAgeCalculatorsFeatureList: ((ageCalculatorList: AgeCalculatorsList) -> Unit)? = null,
    ) {
    OutlinedCard(
        onClick = {
            if (feature != null && onClickFeature != null) {
                onClickFeature(feature)
            }
            if (featureList != null && onClickFeatureList != null) {
                onClickFeatureList(featureList)
            }
            if (ageCalculatorsList != null && onClickAgeCalculatorsFeatureList != null) {
                onClickAgeCalculatorsFeatureList(ageCalculatorsList)
            }
        },
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(FeatureItemPadding),
            horizontalArrangement = Arrangement.spacedBy(FeatureItemPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f, fill = true),
                verticalArrangement = Arrangement.spacedBy(FeatureItemTextPadding)
            ) {
                if (feature != null) {
                    Text(
                        text = feature.name,
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = feature.artifact,
                        style = MaterialTheme.typography.bodySmall,
                    )
                    Text(
                        text = feature.date,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                if (featureList != null) {
                    Text(
                        text = featureList.name,
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = featureList.artifact,
                        style = MaterialTheme.typography.bodySmall,
                    )
                }

                if (ageCalculatorsList != null) {
                    Text(
                        text = ageCalculatorsList.name,
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        text = ageCalculatorsList.artifact,
                        style = MaterialTheme.typography.bodySmall,
                    )
                    Text(
                        text = ageCalculatorsList.date,
                        style = MaterialTheme.typography.bodySmall
                    )
                }

        }
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

private val FeatureItemPadding = 16.dp
private val FeatureItemTextPadding = 8.dp
