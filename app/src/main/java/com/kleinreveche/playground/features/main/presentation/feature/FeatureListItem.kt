package com.kleinreveche.playground.features.main.presentation.feature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kleinreveche.playground.features.main.model.FeatureLists

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureListItem(
    featureList: FeatureLists,
    onClick: (feature: FeatureLists) -> Unit
) {
    OutlinedCard(
        onClick = { onClick(featureList) },
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(SpecificationItemPadding),
            horizontalArrangement = Arrangement.spacedBy(SpecificationItemPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f, fill = true),
                verticalArrangement = Arrangement.spacedBy(SpecificationItemTextPadding)
            ) {
                Text(
                    text = featureList.name,
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = featureList.artifact,
                    style = MaterialTheme.typography.bodySmall,
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

private val SpecificationItemPadding = 16.dp
private val SpecificationItemTextPadding = 8.dp
