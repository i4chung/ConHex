package com.i4chung.conhex.game

import androidx.compose.runtime.Composable

/**
 * GameMaster is responsible for managing **game state**
 */
class GameMaster {
    var board = Board()
    var state = "some game state enum?"

    init {
        board.reset()
    }

    @Composable
    fun GameDisplay(){
        board.GameBoard()
    }
}