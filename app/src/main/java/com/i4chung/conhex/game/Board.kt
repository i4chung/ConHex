package com.i4chung.conhex.game

import androidx.compose.runtime.Composable
import com.i4chung.conhex.game.tiles.GroundTile
import com.i4chung.conhex.game.tiles.PlayerTile
import com.i4chung.conhex.game.tiles.Tile
import kotlin.math.abs

class Board {
    // TODO: on tile refresh, empty [groundCells]
    // TODO: once tile flipping animation is done, re-fill the groundCells
    var groundCells = mutableMapOf<HexCord, GroundTile>()
    var placedCells = mutableMapOf<HexCord, Tile>()

    fun reset(){
        // create 6*6*6 hex cell board
        // iterate x+y+z = 0 for  -5 <= x,y,z <=5
        for (x in -BOARD_MAX_INDEX..BOARD_MAX_INDEX) {
            for (y in -BOARD_MAX_INDEX..BOARD_MAX_INDEX) {
                val z = -(x + y)
                if (abs(z) > BOARD_MAX_INDEX) continue

                groundCells[HexCord(x, y, z)] = GroundTile()
            }
        }
    }

    /**
     * returns if player can place a tile on a Cell in the given HexCord
     */
    fun isPlaceable(cord: HexCord): Boolean {
        if(
            groundCells[cord] == null ||
            placedCells[cord] != null ||
            isConnected(cord)
        ) return false
        return false
    }

    private fun isConnected(cord: HexCord): Boolean{
        if(groundCells[cord]?.isStarting == true) return true
        Direction.values().forEach {
            if (placedCells[cord.getNeighbor(it)] is PlayerTile) return true
        }
        return false
    }

    @Composable
    fun GameBoard() {
        groundCells.forEach { (cord, tile) -> tile.Draw(cord) }
        placedCells.forEach { (cord, tile) -> tile.Draw(cord) }
    }

    companion object {
        const val BOARD_MAX_INDEX = 5
    }
}
