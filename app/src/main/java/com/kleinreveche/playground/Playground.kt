package com.kleinreveche.playground

import android.app.Application
import android.content.Context
import android.widget.Toast
import com.kleinreveche.playground.core.util.helpers.PreferenceHelper
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
        //val context: Context = Playground.applicationContext()
    }
    
    /** Investigate: NULLPOINTER EXCEPTION
    fun showToast(message: String) {
        Toast.makeText(this, message,
                Toast.LENGTH_SHORT).show()
    }
    */
   
}
