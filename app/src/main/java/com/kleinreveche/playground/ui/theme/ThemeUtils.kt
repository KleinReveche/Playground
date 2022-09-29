package com.kleinreveche.playground.ui.theme

import android.app.Application
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.luminance
import androidx.lifecycle.AndroidViewModel
import com.kleinreveche.playground.Playground
import com.kleinreveche.playground.core.util.helpers.PreferenceHelper
import com.kleinreveche.playground.core.util.helpers.Preferences
import com.kleinreveche.playground.core.util.helpers.PreferredMode

class ThemeUtils(application: Application) : AndroidViewModel(application) {

    val preferredMode = PreferenceHelper[Preferences.PREFERRED_MODE, true]
    val isMaterialYouEnabled = PreferenceHelper[Preferences.MATERIAL_YOU, true]

    var darkMode by mutableStateOf(preferredMode as Boolean)
    
    var materialYou by mutableStateOf(isMaterialYouEnabled as Boolean)

    fun updateTheme(isDarkMode: Boolean) {
        this.darkMode = isDarkMode
    }
    
    fun updateMaterialYou(materialYou: Boolean) {
        this.materialYou = materialYou
    }
    
}


@Composable
fun ColorScheme.isLight() = this.background.luminance() > 0.5
