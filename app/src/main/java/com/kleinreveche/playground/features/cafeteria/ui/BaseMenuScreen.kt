package com.kleinreveche.playground.features.cafeteria.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kleinreveche.playground.R
import com.kleinreveche.playground.features.cafeteria.model.MenuItem

@Composable
fun BaseMenuScreen(
    options: List<MenuItem>,
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    onSelectionChanged: (MenuItem) -> Unit,
    modifier: Modifier = Modifier
) {

    var selectedItemName by rememberSaveable { mutableStateOf("") }

    Column (modifier = modifier
        .padding(16.dp)
        .verticalScroll(rememberScrollState())
    ) {
        options.forEach { item ->

            MenuItemRow(
                item = item,
                selectedItemName = selectedItemName,
                onSelectionItemChanged = { selectedItemName = item.name },
                onSelectionChanged = onSelectionChanged
            )
        }

        MenuScreenButtonGroup(
            selectedItemName = selectedItemName,
            onCancelButtonClicked = onCancelButtonClicked,
            onNextButtonClicked = {
                // Assert not null bc next button is not enabled unless selectedItem is not null.
                onNextButtonClicked()
            }
        )
    }
}

@Composable
fun MenuItemRow(
    item: MenuItem,
    selectedItemName: String,
    onSelectionItemChanged: (String) -> Unit,
    onSelectionChanged: (MenuItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier.selectable(
            selected = selectedItemName == item.name,
            onClick = {
                onSelectionItemChanged(item.name)
                onSelectionChanged(item)
            }
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selectedItemName == item.name,
            onClick = {
                onSelectionItemChanged(item.name)
                onSelectionChanged(item)
            }
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = item.description,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = item.getFormattedPrice(),
                style = MaterialTheme.typography.bodyMedium
            )
            Divider(thickness = 1.dp, modifier = modifier.padding(bottom = 16.dp))
        }
    }
}

@Composable
fun MenuScreenButtonGroup(
    selectedItemName: String,
    onCancelButtonClicked: () -> Unit,
    onNextButtonClicked: () -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        OutlinedButton(modifier = Modifier.weight(1f), onClick = onCancelButtonClicked) {
            Text(stringResource(R.string.cancel).uppercase())
        }
        Button(
            modifier = Modifier.weight(1f),
            // the button is enabled when the user makes a selection
            enabled = selectedItemName.isNotEmpty(),
            onClick = onNextButtonClicked
        ) {
            Text(stringResource(R.string.next).uppercase())
        }
    }
}
