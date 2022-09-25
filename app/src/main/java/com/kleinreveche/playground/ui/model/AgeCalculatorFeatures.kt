package com.kleinreveche.playground.ui.model

data class AgeCalculatorsFeatures(
    val id: Int,
    val name: String,
    val artifact: String,
    val date: String
)
private const val basePackage = "com.kleinreveche.playground"

val AgeCalculatorLegacyFeature = AgeCalculatorsFeatures(
    id = 1,
    name = "Age Calculator Legacy",
    artifact = "$basePackage.features.age_calculator",
    date = "08/19/2022"
)

val AgeCalculatorFeature = AgeCalculatorsFeatures(
    id = 2,
    name = "Age Calculator (Material)",
    artifact = "$basePackage.features.age_calculator",
    date = "08/25/2022"
)

val AgeCalculatorComposeFeature = AgeCalculatorsFeatures(
    id = 3,
    name = "Age Calculator (Compose)",
    artifact = "$basePackage.features.age_calculator",
    date = "09/25/2022"
)

val AgeCalculatorList = listOf(
    AgeCalculatorLegacyFeature,
    AgeCalculatorFeature,
    AgeCalculatorComposeFeature
)

