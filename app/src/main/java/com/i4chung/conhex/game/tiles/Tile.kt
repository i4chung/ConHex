package com.i4chung.conhex.game.tiles

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.i4chung.conhex.game.HexCord

interface Tile {
    @get:DrawableRes
    val tileImage: Int

    @Composable
    fun DrawTile(cord: HexCord){
        val disposition = cord.toDisposition()

        Image(
            painter = painterResource(id = tileImage),
            contentDescription = "${this.javaClass.name}: $cord",
            modifier = Modifier
                .offset((disposition.first * 25).dp, (disposition.second * 23).dp)
        )
    }
}