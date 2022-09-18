package com.kleinreveche.playground.features.main.model

data class AndroidEasterEggs(
    val id: Int,
    val name: String,
    val artifact: String,
    val date: String
)

private const val basePackage = "com.kleinreveche.playground.features.android_easter_egg"

val Gingerbread = AndroidEasterEggs(
    id = 1,
    name = "Android 2.3.X (Gingerbread)",
    artifact = "$basePackage.gingerbread",
    date = "09/04/2022"
)

val Honeycomb = AndroidEasterEggs(
    id = 2,
    name = "Android 3.X (Honeycomb)",
    artifact = "$basePackage.honeycomb",
    date = "09/05/2022"
)

val AndroidEasterEggsListOf = listOf(
    Honeycomb,
    Gingerbread
    )

