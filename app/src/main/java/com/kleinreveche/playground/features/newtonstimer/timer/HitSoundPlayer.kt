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
import android.media.MediaPlayer
import com.kleinreveche.playground.R

class HitSoundPlayer(application: Application) {

    private val mediaPlayer = MediaPlayer.create(application, R.raw.ball_hit)

    fun playHitSound(volume: Float) {
        mediaPlayer.setVolume(volume, volume)
        mediaPlayer.start()
    }

    fun release() {
        try {
            mediaPlayer.stop()
            mediaPlayer.release()
        } catch (throwable: Throwable) {
            throwable.printStackTrace()
        }
    }
}
