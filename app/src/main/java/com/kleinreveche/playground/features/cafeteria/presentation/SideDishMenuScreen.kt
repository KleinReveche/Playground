package com.kleinreveche.playground.features.cafeteria.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.kleinreveche.playground.features.cafeteria.datasource.DataSource
import com.kleinreveche.playground.features.cafeteria.model.MenuItem
import com.kleinreveche.playground.features.cafeteria.model.MenuItem.SideDishItem

@Suppress("UNCHECKED_CAST")
@Composable
fun SideDishMenuScreen(
    options: List<SideDishItem>,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit,
    onSelectionChanged: (SideDishItem) -> Unit
) {
    BaseMenuScreen(
        options = options,
        onCancelButtonClicked = onCancelButtonClicked,
        onNextButtonClicked = onNextButtonClicked,
        onSelectionChanged = onSelectionChanged as (MenuItem) -> Unit
    )
}

@Preview
@Composable
fun SideDishMenuPreview() {
    SideDishMenuScreen(
        options = DataSource.sideDishMenuItems,
        onNextButtonClicked = {},
        onCancelButtonClicked = {},
        onSelectionChanged = {}
    )
}
