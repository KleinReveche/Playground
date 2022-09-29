package com.kleinreveche.playground

import android.app.Application
import android.widget.Toast
import com.kleinreveche.playground.core.util.helpers.PreferenceHelper
//import com.kleinreveche.playground.core.util.helpers.PreferenceHelper
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Playground : Application()  {

    init {
        instance = this
    }

    companion object {
        lateinit var instance: Playground
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        PreferenceHelper.initPrefs(this)
    }

    fun showToast(message: String) {
        Toast.makeText(this, message,
            Toast.LENGTH_SHORT).show()
    }


}
