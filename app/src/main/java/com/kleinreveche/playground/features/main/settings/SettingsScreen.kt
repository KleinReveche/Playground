package com.kleinreveche.playground.features.main.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.kleinreveche.playground.R
import com.kleinreveche.playground.core.helpers.Preferences
import com.kleinreveche.playground.core.helpers.rememberBooleanPreference
import com.kleinreveche.playground.features.main.settings.components.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(){
    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = { Text(stringResource(R.string.settings)) },
                navigationIcon = {
                    IconButton(onClick = { TODO("NavController PopBackStack") }) {
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
                      key = Preferences.MATERIAL_YOU,
                      default = true
                      ),
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
              SettingBooleanItem(
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
