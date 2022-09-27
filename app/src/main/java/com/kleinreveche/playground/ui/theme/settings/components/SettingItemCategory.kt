package com.kleinreveche.playground.ui.theme.settings.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingItemCategory(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Box(modifier = Modifier.padding(titlePadding)) {
            ProvideTextStyle(
                MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.primary)
            ) {
                title()
            }
        }
        content()
    }
}

private val titlePadding = 16.dp
