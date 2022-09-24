package com.kleinreveche.playground

import android.app.Application
import android.content.Context
import com.kleinreveche.playground.core.helpers.PreferenceHelper
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Playground : Application()  {

    init {
        instance = this
    }

    companion object {
        private var instance: Playground? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        PreferenceHelper.init(this)
        val context: Context = Playground.applicationContext()
    }
}
