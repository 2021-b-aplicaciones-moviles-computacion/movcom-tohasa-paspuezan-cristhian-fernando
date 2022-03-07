package com.example.examen2b

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

class OFutbolista (

    var id: Int,
    var nombre: String?,
    var actividad: Boolean,
    var proGPP: Double

): Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readDouble()
    ) {
    }

    override fun toString(): String {
        return "${id} ${nombre} ${actividad} ${proGPP}"
    }

    override fun describeContents(): Int {
        return 0
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeInt( id )
        p0?.writeString( nombre )
        p0?.writeBoolean( actividad )
        p0?.writeDouble( proGPP )
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