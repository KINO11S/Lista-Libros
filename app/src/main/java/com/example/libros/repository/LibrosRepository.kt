package com.example.libros.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.libros.room.LibrosDao
import com.example.libros.room.Librosmodel

class LibrosRepository constructor(
    private val LibrosDao: LibrosDao
){
    fun ObtenerTodosLibros(): LiveData<List<Librosmodel>> = LibrosDao.obtenerLibros().asLiveData()

    suspend fun guardarLibros(libro: Librosmodel){
        LibrosDao.guardarLibros(libro)
    }
}
