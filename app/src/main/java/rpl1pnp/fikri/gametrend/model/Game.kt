package rpl1pnp.fikri.gametrend.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Game(
    val id: Int,
    val name: String,
    val image: Int,
    val platform: String,
    val info: String,
    val player: String,
    val developer: String,
    val release: String
) : Parcelable