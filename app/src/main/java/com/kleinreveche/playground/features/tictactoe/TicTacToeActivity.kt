package com.kleinreveche.playground.features.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kleinreveche.playground.R
import com.kleinreveche.playground.ui.theme.PlaygroundAppTheme

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

    val ticTacToeViewModel= TicTacToeViewModel()

    Scaffold(topBar = {
        TicTacAppBar(ticTacToeViewModel.singlePlayer) {
            ticTacToeViewModel.updatePlayerMode(it)
        }
    }) {
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

                    GameOverAlertDialog(
                        title = stringResource(R.string.gameover),
                        message = ticTacToeViewModel.winner,
                        condition = ticTacToeViewModel::reset,
                    )

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
