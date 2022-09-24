package com.kleinreveche.playground.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kleinreveche.playground.core.util.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(val appContext: Application) : AndroidViewModel(appContext) {
   
    companion object{
        const val IS_ONBOARDING_DONE = "is_onboarding_done"
    }

    fun saveOnboardingProgress(done: Boolean) {
        viewModelScope.launch(Dispatchers.IO) { 
            appContext.writeBool(IS_ONBOARDING_DONE, done)
        }
    }
    
    val getOnboardingProgress = appContext.readBool(IS_ONBOARDING_DONE).asLiveData()

}
