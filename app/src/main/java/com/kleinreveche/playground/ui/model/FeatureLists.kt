package com.kleinreveche.playground.ui.model

data class FeatureListsData(
    val id: Int,
    val name: String,
    val artifact: String
)

private const val basePackage = "com.kleinreveche.playground"

val AgeCalculatorsFeatureList = FeatureListsData(
    id = 1,
    name = "Age Calculators",
    artifact = "$basePackage.features"
)

val FeatureListsOf = listOf(
    AgeCalculatorsFeatureList
    )
