package com.kleinreveche.playground.features.main.settings.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Popup

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SettingBaseItem(
    modifier: Modifier = Modifier,
    icon: (@Composable () -> Unit)? = null,
    title: @Composable () -> Unit,
    text: (@Composable () -> Unit)? = null,
    action: (@Composable () -> Unit)? = null,
    onClick: () -> Unit = {}
) {
    Surface(
        onClick = { onClick.invoke() },
        color = Color.Unspecified,
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = modifier
                .padding(
                    horizontal = contentPaddingHorizontal,
                    vertical = contentPaddingVertical
                )
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(elementHorizontalSpace)
        ) {
            icon?.invoke()
            Column(
                modifier = Modifier.weight(1f)
            ) {
                ProvideTextStyle(
                    MaterialTheme.typography.titleLarge.copy(
                        fontSize = 20.sp
                    )
                ) {
                    title()
                }
                ProvideTextStyle(MaterialTheme.typography.bodySmall) {
                    text?.invoke()
                }
            }
            action?.invoke()
        }
    }
}

private val contentPaddingHorizontal = 24.dp
private val contentPaddingVertical = 12.dp
private val elementHorizontalSpace = 24.dp

