package es.uji.jvilar.bullsandcows.game

import android.os.Parcel
import android.os.Parcelable

class Guess(val numbers: String, code: String? = null) : Parcelable {
    var bulls = 0
        private set
    var cows = 0
        private set

    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            null) {
        parcel.apply {
            bulls = readInt()
            cows = readInt()
        }
    }

    init {
        if (code != null) {
            val seen = BooleanArray(code.length)
            bulls = 0
            for (i in numbers.indices)
                if (numbers[i] == code[i]) {
                    bulls++
                    seen[i] = true
                }

            cows = 0
            for (n in numbers) {
                for (j in code.indices) {
                    if (!seen[j] && n == code[j]) {
                        cows++
                        seen[j] = true
                    }
                }
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.apply {
            writeString(numbers)
            writeInt(bulls)
            writeInt(cows)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Guess> {
        override fun createFromParcel(parcel: Parcel): Guess {
            return Guess(parcel)
        }

        override fun newArray(size: Int): Array<Guess?> {
            return arrayOfNulls(size)
        }
    }
}