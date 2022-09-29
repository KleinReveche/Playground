package com.kleinreveche.playground.ui.theme.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.kleinreveche.playground.R
import com.kleinreveche.playground.core.util.helpers.Preferences
import com.kleinreveche.playground.core.util.helpers.rememberBooleanPreference
import com.kleinreveche.playground.ui.theme.settings.components.SettingBooleanItem
import com.kleinreveche.playground.ui.theme.settings.components.SettingBooleanReverseItem
import com.kleinreveche.playground.ui.theme.settings.components.SettingItemCategory
import com.kleinreveche.playground.ui.theme.ThemeUtils

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navController: NavController
){
    val themeUtils: ThemeUtils = viewModel()
    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = { Text(stringResource(R.string.settings)) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Outlined.ArrowBack, null)
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            SettingItemCategory(
                 title = { Text(stringResource(R.string.settings_appearance)) }
            ) {
              SettingBooleanItem(
                  state = rememberBooleanPreference(
                      key = Preferences.PREFERRED_MODE,
                      default = true),
                  onCheckedChange = { themeUtils.updateTheme(it) },
                  title = {
                      Text("Dark Mode")
                      },
                  icon = {
                      Icon(Icons.Outlined.DarkMode, null)
                      },
                  text = {
                      Text(stringResource(R.string.settings_material_you_description))
                      }
              )
              SettingBooleanItem(
                  state = rememberBooleanPreference(
                      key = Preferences.MATERIAL_YOU,
                      default = true
                      ),
                  onCheckedChange = { themeUtils.updateMaterialYou(it) },
                  title = {
                      Text(stringResource(R.string.settings_material_you))
                      },
                  icon = {
                      Icon(Icons.Outlined.Palette, null)
                      },
                  text = {
                      Text(stringResource(R.string.settings_material_you_description))
                      }
              )
            }
            SettingItemCategory(
                 title = { Text(stringResource(R.string.settings_misc)) }
            ) {
              SettingBooleanReverseItem(
                  state = rememberBooleanPreference(
                      key = Preferences.IS_ONBOARDING_DONE,
                      default = true
                      ),
                  title = {
                      Text(stringResource(R.string.settings_onboarding))
                      },
                  icon = {
                      Icon(Icons.Outlined.Home, null)
                      },
                  text = {
                      Text(stringResource(R.string.settings_onboarding_description))
                      }
              )
            }
         } 
       }
    }

const val SettingsRoute = "settings"
