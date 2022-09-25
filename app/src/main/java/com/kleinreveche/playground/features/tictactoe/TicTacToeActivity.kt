package com.kleinreveche.playground.features.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
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
        TicTacAppBar(ticTacToeViewModel.singlePlayer) {
            ticTacToeViewModel.updatePlayerMode(it)
        }}
    ) {
        it.calculateBottomPadding()
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center, 
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ButtonGrid(board = ticTacToeViewModel.board, ticTacToeViewModel::play)

                if (ticTacToeViewModel.isGameOver) {

                    LaunchedEffect(key1 = ticTacToeViewModel.isGameOver) {
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
                ResetButton(onClick = ticTacToeViewModel::reset)
            }

        }
    }
}

const val TicTacToeFeatureRoute = "tictactoe"
