package com.i4chung.conhex.game.tiles

import com.i4chung.conhex.game.HexCord

/**
 * Set of distinct Tiles represented in their relative positions
 */
class TileGroup {
    var offset: HexCord? = null
    val tiles = mutableListOf<RelativeTile>()

    init {
        generateTiles(0)
    }

    /**
     * randomly generate tiles of n tiles
     */
    private fun generateTiles(n: Int){
        // TODO: place holder straight tileGroup
        tiles.add(RelativeTile(PlayerTile(), HexCord()))
        tiles.add(RelativeTile(PlayerTile(), HexCord(-1,0,1)))
        tiles.add(RelativeTile(PlayerTile(), HexCord(-2,0,2)))
        tiles.add(RelativeTile(PlayerTile(), HexCord(-3,0,3)))
    }

    inner class RelativeTile(
        var tile: Tile,
        var relativeCord: HexCord
    ){
        fun toAbsoluteCord(): HexCord? = offset?.plus(relativeCord)
    }
}