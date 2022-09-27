/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kleinreveche.playground.features.newtonstimer.timer

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kleinreveche.playground.features.newtonstimer.utils.setupAngles
import java.util.concurrent.TimeUnit

class TimerViewModel(application: Application) : AndroidViewModel(application) {

    private val hitSoundPlayer = HitSoundPlayer(application)
    private val ticker = TimerTicker(
        viewModelScope = viewModelScope,
        timerStateProvider = ::state,
        onTick = ::refreshRemainingMillis,
        onBallHit = hitSoundPlayer::playHitSound,
        onTimerFinished = { setNewState(TimerState.NotConfigured()) }
    )
    private var _state: TimerState by mutableStateOf(TimerState.NotConfigured())

    var darkMode by mutableStateOf(true)
    var displayedMillis by mutableStateOf(_state.remainingMillis)
    val state get() = _state
    val angles = mutableStateListOf(*Array(BALLS_COUNT) { 0f })
    val isConfigured get() = state is TimerState.Configured

    fun configureStartAngle(startAngle: Float) {
        if (state is TimerState.Configured) return
        setNewState(TimerState.NotConfigured(startAngle.coerceAtLeast(0f).coerceAtMost(MAX_ANGLE)))
    }

    fun play() {
        val state = state
        when {
            !state.canBeStarted() -> return
            state is TimerState.NotConfigured -> setNewState(state.started())
            state is TimerState.Configured.Paused -> setNewState(state.resumed())
        }
    }

    fun pause() {
        val runningState = state as? TimerState.Configured.Running ?: return
        setNewState(runningState.paused())
    }

    fun reset() {
        setNewState(TimerState.NotConfigured())
    }

    fun refreshAngles() {
        when (val state = _state) {
            is TimerState.Configured -> with(state.swingAnimation) { angles.setupAngles(state) }
            else -> angles.setupAngles(firstBallAngle = state.startAngle)
        }
    }

    override fun onCleared() {
        super.onCleared()
        ticker.cancel()
        hitSoundPlayer.release()
    }

    private fun refreshRemainingMillis() {
        displayedMillis = _state.remainingMillis
    }

    private fun setNewState(newState: TimerState) {
        ticker.onStateChange(newState)
        _state = newState
        refreshRemainingMillis()
    }

    companion object {
        const val MAX_ANGLE = 50f
        val MAX_DURATION_MILLIS = TimeUnit.SECONDS.toMillis(60)
        private const val BALLS_COUNT = 5
    }
}
