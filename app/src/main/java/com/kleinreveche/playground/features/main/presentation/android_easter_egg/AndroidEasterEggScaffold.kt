package com.kleinreveche.playground.features.main.presentation.android_easter_egg

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.kleinreveche.playground.features.main.presentation.main.MainTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AndroidEasterEggScaffold(
    topBarTitle: String,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = { MainTopAppBar(title = topBarTitle) },
        content = content
    )

}