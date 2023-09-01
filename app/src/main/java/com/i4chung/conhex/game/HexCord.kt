package com.i4chung.conhex.game

import android.util.Log
import com.i4chung.conhex.game.Board.Companion.BOARD_MAX_INDEX
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin

/**
 * for n*n*n hex board:
 *  - (0,0,0) is center
 *  - (-n,0,n) is top
 *  - (-n,n,0) is top right
 *  - (0,n,-n) is bottom right
 *  - (n,0,-n) is bottom
 *  - (n,-n,0) is bottom left
 *  - (0,-n,n) is top left
 */
data class HexCord(
    val x: Int = 0,
    val y: Int = 0,
    val z: Int = 0
) {
    init {
        if (!isValid()) Log.e(this.javaClass.name, "Coordinate out of constraint: $this")
    }

    fun isValid() = x + y + z == 0 && (
        BOARD_MAX_INDEX == 0 || (
            abs(x) <= BOARD_MAX_INDEX &&
            abs(y) <= BOARD_MAX_INDEX &&
            abs(z) <= BOARD_MAX_INDEX
        )
    )

    /**
     * returns neighboring coordinate of given direction
     * if there is no neighbor in given direction, return null
     */
    fun getNeighbor(direction: Direction): HexCord? {
        val candidate = when (direction) {
            Direction.Top ->            HexCord(x = x - 1, y = y    , z = z + 1)
            Direction.RightTop ->       HexCord(x = x - 1, y = y + 1, z = z    )
            Direction.RightBottom ->    HexCord(x = x    , y = y + 1, z = z - 1)
            Direction.Bottom ->         HexCord(x = x + 1, y = y    , z = z - 1)
            Direction.LeftBottom ->     HexCord(x = x + 1, y = y - 1, z = z    )
            Direction.LeftTop ->        HexCord(x = x    , y = y - 1, z = z + 1)
        }

        return if(candidate.isValid()) candidate else null
    }

    /**
     * If the cord is a neighbor of this, return the direction in which given cord is placed
     * else, return null
     */
    fun isNeighbor(cord: HexCord): Direction? {
        var result: Direction? = null
        Direction.values().forEach{
            if(cord == getNeighbor(it)) result = it
        }
        return result
    }

    operator fun plus(cord: HexCord): HexCord {
        return HexCord(x + cord.x, y + cord.y, z + cord.z)
    }

    fun toDisposition(): Pair<Double, Double> {
        val angle = PI / 3
        val horizontal = (x + z) * cos(angle) - y * sin(angle)
        val vertical = (x - z) * sin(angle)

        return Pair(horizontal, vertical)
    }
}

enum class Direction{
    Top, RightTop, RightBottom, Bottom, LeftBottom, LeftTop,
}