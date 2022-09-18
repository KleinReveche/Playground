package com.kleinreveche.playground.features.main.model

data class AgeCalculators(
    val id: Int,
    val name: String,
    val artifact: String,
    val date: String
)

private const val artifact = "com.kleinreveche.playground.features.age_calculator"

val AgeCalculatorLegacy = AgeCalculators(
    id = 1,
    name = "Age Calculator Legacy (XML)",
    artifact = artifact,
    date = "08/19/2022"
)

val AgeCalculatorMaterial = AgeCalculators(
    id = 2,
    name = "Age Calculator (Material - XML)",
    artifact = artifact,
    date = "08/25/2022"
)

val AgeCalculatorsListOf = listOf(
    AgeCalculatorLegacy,
    AgeCalculatorMaterial
    )

