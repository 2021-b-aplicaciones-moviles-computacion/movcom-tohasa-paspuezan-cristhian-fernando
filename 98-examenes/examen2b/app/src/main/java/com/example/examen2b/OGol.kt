package com.example.examen2b

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

class OGol (

    var id: Int,
    var tipo: String?,
    var penal: Boolean,
    var minuto: Double,
    var idGol: Int

): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readDouble(),
        parcel.readInt()
    ) {
    }

    override fun toString(): String {
        return "${id} ${tipo} ${penal} ${minuto} ${idGol}"
    }

    override fun describeContents(): Int {
        return 0
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeInt( id )
        p0?.writeString( tipo )
        p0?.writeBoolean( penal )
        p0?.writeDouble( minuto )
        p0?.writeInt( idGol )
    }

    companion object CREATOR : Parcelable.Creator<OGol> {
        override fun createFromParcel(parcel: Parcel): OGol {
            return OGol(parcel)
        }

        override fun newArray(size: Int): Array<OGol?> {
            return arrayOfNulls(size)
        }
    }

}