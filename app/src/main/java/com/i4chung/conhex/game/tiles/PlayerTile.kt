package com.i4chung.conhex.game.tiles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import com.i4chung.conhex.R

class PlayerTile: Tile {
    override val tileImage: Int = R.drawable.hexagon_tile
    override var onClick: (()->Unit)? = null
    override fun getColor(): ColorFilter = ColorFilter.tint(Color.Magenta)
}