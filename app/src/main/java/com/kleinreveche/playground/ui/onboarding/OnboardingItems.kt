package com.kleinreveche.playground.ui.onboarding

import com.kleinreveche.playground.R

class OnboardingItems(
    val image: Int,
    val title: Int,
    val desc: Int
) {
    companion object{
        fun getData(): List<OnboardingItems>{
            return listOf(
                OnboardingItems(R.drawable.intro1, R.string.onboarding_title_1, R.string.onboarding_text_1),
                OnboardingItems(R.drawable.intro2, R.string.onboarding_title_2, R.string.onboarding_text_2),
                OnboardingItems(R.drawable.intro3, R.string.onboarding_title_3, R.string.onboarding_text_3)
            )
        }
    }
}
