package com.kleinreveche.playground.features.main.model

data class FeatureLists(
    val id: Int,
    val name: String,
    val artifact: String
)

private const val basePackage = "com.kleinreveche.playground"

val AgeCalculatorsList = FeatureLists(
    id = 1,
    name = "Age Calculators",
    artifact = "$basePackage.features.age_calculator"
)

val AndroidEasterEggList = FeatureLists(
    id = 2,
    name = "Android Easter Eggs",
    artifact = "$basePackage.features.android_easter_eggs"
)

val FeatureListsOf = listOf(
    AgeCalculatorsList,
    AndroidEasterEggList
)

