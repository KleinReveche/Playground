package com.kleinreveche.playground.ui.nav.model

import com.kleinreveche.playground.Playground
import com.kleinreveche.playground.R

data class Features(
    val id: Int,
    val name: String,
    val artifact: String,
    val date: String
)

private const val basePackage = "com.kleinreveche.playground"
private val applicationContext = Playground.instance

val DiceRollerFeature = Features(
    id = 1,
    name = applicationContext.getString(R.string.dice_roller),
    artifact = "$basePackage.features.dice",
    date = "08/28/2022"
)

val DessertClickerFeature = Features(
    id = 2,
    name = applicationContext.getString(R.string.dessert_clicker),
    artifact = "$basePackage.features.dessert",
    date = "08/28/2022"
)

val CupcakeFeature = Features(
    id = 3,
    name = applicationContext.getString(R.string.cupcakes),
    artifact = "$basePackage.features.cupcake",
    date = "08/30/2022"
)

val CafeteriaFeature = Features(
    id = 4,
    name = applicationContext.getString(R.string.cafeteria),
    artifact = "$basePackage.features.cafeteria",
    date = "08/30/2022"
)

val NotesFeature = Features(
    id = 5,
    name = applicationContext.getString(R.string.notes),
    artifact = "$basePackage.features.notes",
    date = "08/30/2022"
)

val LemonadeFeature = Features(
    id = 6,
    name = applicationContext.getString(R.string.lemonade),
    artifact = "$basePackage.features.lemonade",
    date = "09/01/2022"
)

val UnscrambleFeature = Features(
    id = 7,
    name = applicationContext.getString(R.string.unscramble),
    artifact = "$basePackage.features.unscramble",
    date = "09/02/2022"
)

val TicTacToeFeature = Features(
    id = 8,
    name = applicationContext.getString(R.string.tictactoe),
    artifact = "$basePackage.features.tictactoe",
    date = "09/24/2022"
)

val NewtonsTimerFeature = Features(
    id = 9,
    name = applicationContext.getString(R.string.newtons_timer),
    artifact = "$basePackage.features.newtonstimer",
    date = "09/27/2022"
)

val FeatureList = listOf(
    DiceRollerFeature,
    DessertClickerFeature,
    CupcakeFeature,
    CafeteriaFeature,
    NotesFeature,
    LemonadeFeature,
    UnscrambleFeature,
    TicTacToeFeature,
    NewtonsTimerFeature
    )

