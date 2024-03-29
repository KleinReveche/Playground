package com.kleinreveche.playground.ui.nav.features

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureScaffold(
    topBarTitle: String,
    color: Color,
    onClick: () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = { 
            FeatureTopAppBar(
                title = topBarTitle,
                color = color,
                onClick = onClick
                ) },
        content = content
    )

}
