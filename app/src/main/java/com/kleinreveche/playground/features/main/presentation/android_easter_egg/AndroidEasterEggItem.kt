package com.kleinreveche.playground.features.main.presentation.android_easter_egg

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kleinreveche.playground.features.main.model.AndroidEasterEggs

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AndroidEasterEggItem(
    androidEasterEggs: AndroidEasterEggs,
    onClick: (androidEasterEggs: AndroidEasterEggs) -> Unit
) {
    OutlinedCard(
        onClick = { onClick(androidEasterEggs) },
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(AndroidEasterEggItemPadding),
            horizontalArrangement = Arrangement.spacedBy(AndroidEasterEggItemPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f, fill = true),
                verticalArrangement = Arrangement.spacedBy(AndroidEasterEggItemTextPadding)
            ) {
                Text(
                    text = androidEasterEggs.name,
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = androidEasterEggs.artifact,
                    style = MaterialTheme.typography.bodySmall,
                )
                Text(
                    text = androidEasterEggs.date,
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

private val AndroidEasterEggItemPadding = 16.dp
private val AndroidEasterEggItemTextPadding = 8.dp
