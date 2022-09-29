package com.kleinreveche.playground.features.tictactoe

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kleinreveche.playground.R
import com.kleinreveche.playground.features.tictactoe.engine.GameUtils.PLAYER_O
import com.kleinreveche.playground.features.tictactoe.engine.GameUtils.PLAYER_X

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicTacAppBar(singlePlayer: Boolean, onCheckedChange: (Boolean) -> Unit) {
    val checkedState = remember { mutableStateOf(singlePlayer) }
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.tictactoe),
                color = MaterialTheme.colorScheme.primary
                ) },
        actions = {
            Row(modifier = Modifier.padding(end = 16.dp)){
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = if (checkedState.value) "Singleplayer" else "Multiplayer"
                )
                Spacer(modifier = Modifier.width(16.dp))
                Switch(checked = checkedState.value, onCheckedChange = {
                    checkedState.value = it
                    onCheckedChange(it)
                })
            }
        }
    )
}

@Composable
fun StatsCounter(
    playerXWinCount: Int,
    playerOWinCount: Int,
    drawCount: Int,
    singleplayer: Boolean,
    showDraw: Boolean
) {
    val isSingleplayer = remember { mutableStateOf(singleplayer) }
    Row(Modifier.padding(start = 16.dp, end = 16.dp)) {
        Column(
            Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = if(isSingleplayer.value) "You" else "Player X",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "$playerXWinCount",
                fontSize = 32.sp,
            )
        }
        AnimatedVisibility(
            visible = showDraw,
            enter = fadeIn() + slideInHorizontally(),
            exit = fadeOut() + slideOutHorizontally()
        ) {
            Column(
              Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Draw",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "$drawCount",
                    fontSize = 30.sp,
                )
            }
        }
        Column(
            Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = if(isSingleplayer.value) "AI" else "Player O",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "$playerOWinCount",
                fontSize = 32.sp,
            )
        }
    }
}

@Composable
fun GameButton(buttonName: String, onClick: () -> Unit) {
    OutlinedButton(onClick = onClick, modifier = Modifier
        .padding(16.dp)
        .height(50.dp)) {
        Text(
            text = buttonName,
            style = TextStyle(textAlign = TextAlign.Center)
        )
    }
}

@Composable
fun ButtonGrid(board: ArrayList<String>, onclick: (Int) -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(Modifier.padding(vertical = 1.dp)) {
            Row {
                TicTacToeButton(text = board[0]) { onclick(0) }
                TicTacToeButton(text = board[1]) { onclick(1) }
                TicTacToeButton(text = board[2]) { onclick(2) }
            }
            Row {
                TicTacToeButton(text = board[3]) { onclick(3) }
                TicTacToeButton(text = board[4]) { onclick(4) }
                TicTacToeButton(text = board[5]) { onclick(5) }
            }
            Row {
                TicTacToeButton(text = board[6]) { onclick(6) }
                TicTacToeButton(text = board[7]) { onclick(7) }
                TicTacToeButton(text = board[8]) { onclick(8) }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TicTacToeButton(
    text: String,
    onclick: () -> Unit) {
    Box(
        Modifier
            .size(125.dp)
            .padding(8.dp)
            .clip(CircleShape)
            .aspectRatio(1f)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onBackground.copy(),
                shape = CircleShape
            )
            .background(
                color = MaterialTheme.colorScheme.background.copy(),
                shape = CircleShape
            )
            .clickable(
                indication = if (text.isBlank()) LocalIndication.current else null,
                interactionSource = remember { MutableInteractionSource() },
                enabled = text.isBlank()
            ) {
                if (text.isBlank())
                    onclick()
            },
        contentAlignment = Alignment.Center
    ) {
        AnimatedContent(
            targetState = text,
        ) { targetCurrentPiece ->
            Image(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize(),
                painter = painterResource(
                    id = when (targetCurrentPiece) {
                        PLAYER_X -> R.drawable.ic_x
                        PLAYER_O -> R.drawable.ic_o
                        else -> R.drawable.ic_blank
                    }
                ),
                contentDescription = targetCurrentPiece,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
            )
        }
    }
}

@Composable
fun GameOverAlertDialog(
    title: String,
    message: String,
    condition: () -> Unit = {}
) {
    AlertDialog(
        onDismissRequest = {
            condition()
        },
        title = {
            Text(text = title)
        },
        text = {
            Text(message)
        },
        confirmButton = {
            Button(
                onClick = {
                    condition()
                }) {
                Text(stringResource(R.string.reset))
            }
        },
        dismissButton = {}
    )
}


@Preview(showBackground = true)
@Composable
fun ButtonPreview(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ButtonGrid(board = arrayListOf(
            "X", "O", "X",
            "O", "O", "X",
            "",  "X", "O"
        )){}
        
    }
}
