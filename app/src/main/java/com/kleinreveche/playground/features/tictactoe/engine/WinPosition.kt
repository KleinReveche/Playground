package com.kleinreveche.playground.features.tictactoe.engine

sealed class WinPosition(val places: List<Int>) {
    object H1 : WinPosition(listOf(0, 1, 2))
    object H2 : WinPosition(listOf(3, 4, 5))
    object H3 : WinPosition(listOf(6, 7, 8))

    object V1 : WinPosition(listOf(0, 3, 6))
    object V2 : WinPosition(listOf(1, 4, 7))
    object V3 : WinPosition(listOf(2, 5, 8))

    object D1 : WinPosition(listOf(0, 4, 8))
    object D2 : WinPosition(listOf(2, 4, 6))
}
