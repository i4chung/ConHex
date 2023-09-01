package com.i4chung.conhex.game.tiles

import com.i4chung.conhex.R

class BlockerTile: Tile {
    override val tileImage: Int = R.drawable.hexagon_tile
    override var onClick: (()->Unit)? = null
}