package com.kleinreveche.playground.ui.presentation.features

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kleinreveche.playground.ui.model.Features

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureItem(
    feature: Features,
    onClick: (feature: Features) -> Unit
) {
    OutlinedCard(
        onClick = { onClick(feature) },
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