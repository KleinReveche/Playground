package com.kleinreveche.playground.ui.nav.model

data class AgeCalculatorsList(
    val id: Int,
    val name: String,
    val artifact: String,
    val date: String
)
private const val basePackage = "com.kleinreveche.playground"

val AgeCalculatorLegacyFeature = AgeCalculatorsList(
    id = 1,
    name = "Age Calculator Legacy",
    artifact = "$basePackage.features.age_calculator",
    date = "08/19/2022"
)

val AgeCalculatorFeature = AgeCalculatorsList(
    id = 2,
    name = "Age Calculator (Material)",
    artifact = "$basePackage.features.age_calculator",
    date = "08/25/2022"
)

val AgeCalculatorComposeFeature = AgeCalculatorsList(
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

