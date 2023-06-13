package com.example.libros.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "Libros")
data class Librosmodel (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "Titulo") var Titulo: String,
    @ColumnInfo(name = "Autor")  val Autor: String,
    @ColumnInfo(name = "estado")  val estado: String
)