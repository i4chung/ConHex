package com.i4chung.conhex.game.tiles

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.i4chung.conhex.game.HexCord
import com.i4chung.conhex.game.TurnDirection

/**
 * Set of distinct Tiles represented in their relative positions
 */
class TileGroup {
    var tiles = mutableStateMapOf<HexCord, PlayerTile>()

    init {
        generateTiles(0)
    }

    /**
     * randomly generate tiles of n tiles
     */
    private fun generateTiles(n: Int){
        TESTSET2()
    }

    private fun TESTSET1(){
        // TODO: place holder straight tileGroup
        tiles[HexCord()] = PlayerTile()
        tiles[HexCord(-1,0,1)] = PlayerTile()
        tiles[HexCord(-2,0,2)] = PlayerTile()
        tiles[HexCord(-3,0,3)] = PlayerTile()
    }

    private fun TESTSET2(){
        // TODO: place holder straight tileGroup
        tiles[HexCord()] = PlayerTile()
        tiles[HexCord(1,-1,0)] = PlayerTile()
        tiles[HexCord(1,-2,1)] = PlayerTile()
//        tiles[HexCord(2,-3,1)] = PlayerTile()
    }

    /**
     * Rotates tile group clockwise
     */
    private fun rotateGroup(){
        val new = mutableMapOf<HexCord, PlayerTile>()

        tiles.forEach { (cord, tile) ->
            new[cord.rotate(TurnDirection.Clockwise)] = tile
        }

        tiles.clear()
        tiles.putAll(new)
    }

    @Composable
    fun Draw(){
        // TODO: find a way to wrap all tiles just enough amount
        // TODO: THEN align tiles in the way that they don't overlap
        // TODO: THEN make the group draggable
        // TODO: THEN while dragging if additional tap is entered, rotate the group
        // TODO: THEN make the tile placeable on the board with rules applied
        // TODO: THEN make the game state machine
        var max = 0
        var min = 0
//        val width =
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .width(50.dp)
                .background(Color.Yellow)
                .clickable {
                    // TODO: TEST VERIFICATION FUNCTION
                    rotateGroup()
                }
        ) {
            tiles.forEach { (cord, tile) -> tile.Draw(cord) }
        }
    }
}