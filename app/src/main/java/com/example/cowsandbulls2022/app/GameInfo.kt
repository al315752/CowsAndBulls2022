package com.example.cowsandbulls2022.app

import android.os.Parcel
import android.os.Parcelable

data class GameInfo(val numberOfColors: Int, val numberOfHoles: Int, val repetitionsAllowed: Boolean) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(numberOfColors)
        parcel.writeInt(numberOfHoles)
        parcel.writeByte(if (repetitionsAllowed) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GameInfo> {
        override fun createFromParcel(parcel: Parcel): GameInfo {
            return GameInfo(parcel)
        }

        override fun newArray(size: Int): Array<GameInfo?> {
            return arrayOfNulls(size)
        }
    }
}
