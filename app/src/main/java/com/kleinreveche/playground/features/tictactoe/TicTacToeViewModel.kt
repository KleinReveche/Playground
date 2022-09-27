package com.kleinreveche.playground.features.tictactoe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.kleinreveche.playground.core.util.helpers.*
import com.kleinreveche.playground.features.tictactoe.engine.GameUtils
import com.kleinreveche.playground.features.tictactoe.engine.GameUtils.PLAYER_O
import com.kleinreveche.playground.features.tictactoe.engine.GameUtils.PLAYER_X
import com.kleinreveche.playground.features.tictactoe.engine.GameUtils.isBoardFull
import com.kleinreveche.playground.features.tictactoe.engine.GameUtils.isGameWon

class TicTacToeViewModel {

    var singleplayer by mutableStateOf(true)
        private set

    var isGameOver by mutableStateOf(false)
        private set

    var winner by mutableStateOf("")
        private set

    var board by mutableStateOf(arrayListOf("", "", "", "", "", "", "", "", ""))
        private set

    var playerWinCount by mutableStateOf( PreferenceHelper[Preferences.TTC_PLAYER_WINS, 0] as Int ) 
    var aiWinCount by mutableStateOf( PreferenceHelper[Preferences.TTC_AI_WINS, 0] as Int ) 
    var drawCount by mutableStateOf( PreferenceHelper[Preferences.TTC_DRAWS_COUNT, 0] as Int )
    var showDraw by mutableStateOf( PreferenceHelper[Preferences.TTC_SHOW_DRAWS_COUNT, false] as Boolean )
    var playerXWinCount by mutableStateOf(0)
    var playerOWinCount by mutableStateOf(0)
    var multiplayerDrawCount by mutableStateOf(0)

    private var currentPlayer = PLAYER_X

    fun play(move: Int) {
        if (isGameOver) return
        
        if (board[move] == "") {
            if (currentPlayer == PLAYER_X) {
                board = ArrayList(board.toMutableList().also {
                    it[move] = PLAYER_X
                })
                currentPlayer = PLAYER_O

                if (singleplayer) {
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

                if (singleplayer) {
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
        updateWinCounters(board, singleplayer)
        winner = GameUtils.gameResult(board, singleplayer)
    }

    fun reset() {
        isGameOver = false
        board = arrayListOf("", "", "", "", "", "", "", "", "")
        currentPlayer = PLAYER_X
    }

    fun resetMultiplayerStats() {
        reset()
        playerXWinCount = 0
        playerOWinCount = 0
        multiplayerDrawCount = 0
    }
    fun updatePlayerMode(singleplayer: Boolean) {
        reset()
        this.singleplayer = singleplayer
    }

    private fun updateWinCounters(board: ArrayList<String>, singlePlayer: Boolean) {
        GameUtils.saveGameResult(board, singlePlayer, playerWinCount, aiWinCount, drawCount)
        if(singlePlayer) {
            when {
                isGameWon(board, PLAYER_X) -> this.playerWinCount++
                isGameWon(board, PLAYER_O) -> this.aiWinCount++
                isBoardFull(board) -> this.drawCount++
             }
        }
       if(!singlePlayer) {
            when {
                isGameWon(board, PLAYER_X) -> this.playerXWinCount++
                isGameWon(board, PLAYER_O) -> this.playerOWinCount++
                isBoardFull(board) -> this.multiplayerDrawCount++
             }
        }
    }
}
