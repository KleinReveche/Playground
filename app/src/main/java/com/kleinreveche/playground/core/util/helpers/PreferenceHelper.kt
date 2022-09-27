package com.kleinreveche.playground.core.util.helpers

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.*

object PreferenceHelper {

    private const val PLAYGROUND_PREFERENCES = "PlaygroundPreferences"
    lateinit var preferences: SharedPreferences

    fun initPrefs(context: Context) {
        preferences = context.getSharedPreferences(PLAYGROUND_PREFERENCES, Context.MODE_PRIVATE)
        checkPrefs()
    }
    
    private fun checkPrefs() {
       checkForPrefs(Preferences.IS_ONBOARDING_DONE, false)
       checkForPrefs(Preferences.MATERIAL_YOU, true)
       checkForPrefs(Preferences.TTC_PLAYER_WINS, 0)
       checkForPrefs(Preferences.TTC_AI_WINS, 0)
       checkForPrefs(Preferences.TTC_DRAWS_COUNT, 0)
       checkForPrefs(Preferences.TTC_SHOW_DRAWS_COUNT, false)
    }

    private fun checkForPrefs(key: String, defaultValue: Any) {
        if(!preferences.contains(key)) {
             set(key, defaultValue)
        }
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }

    operator fun set(key: String, value: Any?) =
        when (value) {
            is String? -> preferences.edit { it.putString(key, value) }
            is Int -> preferences.edit { it.putInt(key, value) }
            is Boolean -> preferences.edit { it.putBoolean(key, value) }
            is Float -> preferences.edit { it.putFloat(key, value) }
            is Long -> preferences.edit { it.putLong(key, value) }
            else -> throw UnsupportedOperationException("Not yet implemented")
        }

    operator fun get(
        key: String,
        default: Any?
    ) =
        when (default) {
            is String? -> preferences.getString(key, default)
            is Int -> preferences.getInt(key, default)
            is Boolean -> preferences.getBoolean(key, default)
            is Float -> preferences.getFloat(key, default)
            is Long -> preferences.getLong(key, default)
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
}

@Composable
fun rememberBooleanPreference(
    key: String,
    default: Boolean
): MutableState<Boolean> {
    val state = remember {
        mutableStateOf(PreferenceHelper[key, default])
    }
    DisposableEffect(Unit) {
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, s ->
            if(s == key) {
                state.value = sharedPreferences.getBoolean(key, default)
            }
        }
        PreferenceHelper.preferences.registerOnSharedPreferenceChangeListener(listener)
        onDispose {
            PreferenceHelper.preferences.unregisterOnSharedPreferenceChangeListener(listener)
        }
    }
    return object : MutableState<Boolean> {
        override var value: Boolean
            get() = state.value as Boolean
            set(value) {
                state.value = value
                PreferenceHelper[key] = value
            }

        override fun component1(): Boolean = value

        override fun component2(): (Boolean) -> Unit = {
            value = it
        }
    }
}
