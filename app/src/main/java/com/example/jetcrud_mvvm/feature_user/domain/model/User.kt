package com.example.jetcrud_mvvm.feature_user.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dagger.hilt.EntryPoint

@Entity
data class User(

    @PrimaryKey(autoGenerate = true) val userId: Int? = null,
    @ColumnInfo(name = "nombre_usuario")
    val name:String,
    @ColumnInfo(name = "correo_usuario")
    val correo:String,
    @ColumnInfo(name = "telefono_usuario")
    val telefono:String,
    @ColumnInfo(name = "password_usuario")
    val password:String,
    @ColumnInfo(name = "ICCID_usuario")
    val ICCID: String,

)