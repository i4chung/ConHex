package com.i4chung.conhex.game.tiles

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.i4chung.conhex.game.HexCord

interface Tile {

    @get:DrawableRes
    val tileImage: Int

    var onClick: (()->Unit)?

    fun getColor(): ColorFilter? = null

    @Composable
    fun Draw(cord: HexCord){
        val (x, y) = cord.toDisposition()

        Image(
            painter = painterResource(id = tileImage),
            contentDescription = "${this.javaClass.name}: $cord",
            colorFilter = getColor(),
            modifier = Modifier.offset((x * 25).dp, (y * 23).dp)
                .clickable {
                    Log.i(this.javaClass.name, cord.toString())
                    onClick?.invoke()
                }
        )
    }
}