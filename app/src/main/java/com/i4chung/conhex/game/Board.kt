package com.i4chung.conhex.game

import androidx.compose.runtime.Composable
import com.i4chung.conhex.game.tiles.GroundTile
import com.i4chung.conhex.game.tiles.PlayerTile
import com.i4chung.conhex.game.tiles.Tile
import kotlin.math.abs

class Board {
    var groundCells = mutableMapOf<HexCord, Tile>()

    fun reset(){
        // create 6*6*6 hex cell board
        // iterate x+y+z = 0 for  -6 <= x,y,z <=6
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
        Direction.values().forEach {
            if (groundCells[cord.getNeighbor(it)] is PlayerTile) return true
        }
        return false
    }

    @Composable
    fun GameBoard() {
        groundCells.forEach { (cord, tile) -> tile.DrawTile(cord) }
    }

    companion object {
        const val BOARD_MAX_INDEX = 5
    }
}
