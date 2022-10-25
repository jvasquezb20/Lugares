package com.lugare_v.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "lugar")

data class Lugar(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name= "nombre")
    val nombre:String,
    @ColumnInfo(name= "correo")
    val correo:String?,
    @ColumnInfo(name= "telefono")
    val telefono:String?,
    @ColumnInfo(name= "Sitio_Web")
    val web:String?,
    @ColumnInfo(name= "latitud")
    val latitud:Double?,
    @ColumnInfo(name= "longitud")
    val longitud:Double?,
    @ColumnInfo(name= "altura")
    val altura:Double?,
    @ColumnInfo(name= "ruta_audio")
    val ruta_audio:String?,
    @ColumnInfo(name= "ruta_imagen")
    val ruta_imagen:String?,
) : Parcelable
