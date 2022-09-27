package com.kleinreveche.playground.features.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kleinreveche.playground.R
import com.kleinreveche.playground.ui.theme.PlaygroundAppTheme
import kotlinx.coroutines.launch

class TicTacToeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundAppTheme {
                TicTacToe()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicTacToe(){
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val ticTacToeViewModel = TicTacToeViewModel()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
        TicTacAppBar(ticTacToeViewModel.singleplayer) {
            ticTacToeViewModel.updatePlayerMode(it)
        }}
    ) {
        it.calculateBottomPadding()
        
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center, 
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AnimatedVisibility(
                    visible = ticTacToeViewModel.singleplayer,
                    enter = fadeIn() + slideInVertically(),
                    exit = fadeOut() + slideOutVertically()
                ) {
                    StatsCounter(
                        playerXWinCount = ticTacToeViewModel.playerWinCount,
                        playerOWinCount = ticTacToeViewModel.aiWinCount,
                        drawCount = ticTacToeViewModel.drawCount,
                        singleplayer = true,
                        showDraw = ticTacToeViewModel.showDraw
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                }
                AnimatedVisibility(
                    visible = !ticTacToeViewModel.singleplayer,
                    enter = fadeIn() + slideInVertically(),
                    exit = fadeOut() + slideOutVertically()
                ) {
                    StatsCounter(
                        playerXWinCount = ticTacToeViewModel.playerXWinCount,
                        playerOWinCount = ticTacToeViewModel.playerOWinCount,
                        drawCount = ticTacToeViewModel.multiplayerDrawCount,
                        singleplayer = false,
                        showDraw = ticTacToeViewModel.showDraw
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                }

                ButtonGrid(board = ticTacToeViewModel.board, ticTacToeViewModel::play)

                AnimatedVisibility(
                    visible = ticTacToeViewModel.isGameOver,
                    enter = fadeIn() + slideInVertically(),
                    exit = fadeOut() + slideOutVertically()
                ) {
                    LaunchedEffect(ticTacToeViewModel.isGameOver) {
                        scope.launch {
                            val result = snackbarHostState.showSnackbar(
                                message = "Game-over: ${ticTacToeViewModel.winner}",
                                actionLabel = "Restart",
                                withDismissAction = false,
                                duration = SnackbarDuration.Indefinite
                            )
                            when (result) {
                                SnackbarResult.Dismissed -> TODO()
                                SnackbarResult.ActionPerformed -> { ticTacToeViewModel.reset() }
                            }
                        }
                    }

                    Box {
                        Text(
                            text = "Game-over: ${ticTacToeViewModel.winner}",
                            fontSize = 20.sp
                        )
                    }
                }
Row(
    modifier = Modifier.fillMaxWidth(),
horizontalArrangement = Arrangement.Center
    ){
                GameButton(buttonName = stringResource(R.string.restart), onClick = ticTacToeViewModel::reset)
                AnimatedVisibility(
                    visible = !ticTacToeViewModel.singleplayer,
                    enter = fadeIn() + slideInHorizontally(),
                    exit = fadeOut() + slideOutHorizontally()
                ) {
                    GameButton(buttonName = stringResource(R.string.ttc_reset_multiplayer_stats), onClick = ticTacToeViewModel::resetMultiplayerStats)
                }
            }
}
AnimatedVisibility(
                    visible = ticTacToeViewModel.singleplayer,
                    enter = fadeIn() + slideInHorizontally(),
                    exit = fadeOut() + slideOutHorizontally()
                ) {
                    GameButton(buttonName = stringResource(R.string.ttc_reset_multiplayer_stats), onClick = ticTacToeViewModel::resetMultiplayerStats)
                }
        }
    }
}

const val TicTacToeFeatureRoute = "tictactoe"
