package com.kleinreveche.playground.features.tictactoe

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kleinreveche.playground.ui.theme.PlaygroundAppTheme

class TicTacToeActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundAppTheme {
                Scaffold(topBar = {
                    TicTacAppBar(mainViewModel.singlePlayer) {
                        mainViewModel.updatePlayerMode(it)
                    }
                }) {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colorScheme.background) {
                        Column(
                            verticalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier.fillMaxHeight()
                        ) {
                            ButtonGrid(board = mainViewModel.board, mainViewModel::play)

                            if (mainViewModel.isGameOver) {
                                Box {
                                    Text(
                                        text = "Game is Over: ${mainViewModel.winner}",
                                        fontSize = 20.sp
                                    )
                                }
                            }

                            ResetButton(onClick = mainViewModel::reset)

                            //Play with a friend
                            TextButton(
                                onClick = {
                                    Toast.makeText(
                                        this@TicTacToeActivity,
                                        "Coming soon",
                                        Toast.LENGTH_LONG
                                    ).show()
                                },
                                modifier = Modifier.padding(16.dp).height(50.dp),
                            ) {
                                Text(
                                    text = "Play with a friend",
                                    modifier = Modifier.padding(horizontal = 16.dp)
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}

/*
@Composable
fun DefaultPreview() {
    TicTacToeTheme {
        Column(horizontalGravity = Alignment.CenterHorizontally) {
            ButtonGrid(board = arrayListOf("X", "O", "X", "O", "O", "X", "", "X", "O")) {}
            ResetButton {}
        }
    }
}
*/
