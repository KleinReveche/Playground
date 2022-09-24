package com.kleinreveche.playground.features.main.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeatureScaffold(
    topBarTitle: String,
    onClick: () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = { 
            FeatureTopAppBar(
                title = topBarTitle,
                onClick = onClick
                ) },
        content = content
    )

}
