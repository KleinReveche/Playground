package com.kleinreveche.playground.features.tictactoe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.kleinreveche.playground.features.tictactoe.engine.GameUtils
import com.kleinreveche.playground.features.tictactoe.engine.GameUtils.PLAYER_O
import com.kleinreveche.playground.features.tictactoe.engine.GameUtils.PLAYER_X
import com.kleinreveche.playground.features.tictactoe.engine.GameUtils.isBoardFull
import com.kleinreveche.playground.features.tictactoe.engine.GameUtils.isGameWon

class TicTacToeViewModel {

    var singlePlayer by mutableStateOf(true)
        private set

    var isGameOver by mutableStateOf(false)
        private set

    var winner by mutableStateOf("")
        private set

    var board by mutableStateOf(arrayListOf("", "", "", "", "", "", "", "", ""))
        private set

    private var currentPlayer = PLAYER_X

    fun play(move: Int) {
        if (isGameOver) return

        if (board[move] == "") {
            if (currentPlayer == PLAYER_X) {
                board = ArrayList(board.toMutableList().also {
                    it[move] = PLAYER_X
                })
                currentPlayer = PLAYER_O

                if (singlePlayer) {
                    if (!isBoardFull(board) && !isGameWon(board, PLAYER_X)) {
                        val nextMove = GameUtils.computerMove(board)

                        board = ArrayList(board.toMutableList().also {
                            it[nextMove] = PLAYER_O
                        })
                    }
                    currentPlayer = PLAYER_X
                }

            } else {
                board = ArrayList(board.toMutableList().also {
                    it[move] = PLAYER_O
                })
                currentPlayer = PLAYER_X

                if (singlePlayer) {
                    if (!isBoardFull(board) && !isGameWon(board, PLAYER_O)) {
                        val nextMove = GameUtils.computerMove(board)

                        board = ArrayList(board.toMutableList().also {
                            it[nextMove] = PLAYER_X
                        })
                    }
                    currentPlayer = PLAYER_O
                }
            }
        }

        isGameOver = isGameWon(board, PLAYER_X) || isGameWon(board, PLAYER_O) || isBoardFull(board)
        winner = GameUtils.gameResult(board, singlePlayer)

    }

    fun reset() {
        isGameOver = false
        board = arrayListOf("", "", "", "", "", "", "", "", "")
    }

    fun updatePlayerMode(singlePlayer: Boolean) {
        reset()
        this.singlePlayer = singlePlayer
    }
}
