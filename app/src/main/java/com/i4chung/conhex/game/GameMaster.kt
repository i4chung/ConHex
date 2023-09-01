package com.i4chung.conhex.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.i4chung.conhex.game.tiles.TileGroup

/**
 * GameMaster is responsible for managing **game state**
 */
class GameMaster {
    var board = Board()
    var hands = mutableListOf(TileGroup(), TileGroup(), TileGroup(), TileGroup())
    var state = "some game state enum?"

    init {
        board.reset()
    }

    @Composable
    fun GameDisplay() {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            board.GameBoard()
        }

        Box(
            Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Blue)
        ) {
            // TODO: Hands
        }
    }
}