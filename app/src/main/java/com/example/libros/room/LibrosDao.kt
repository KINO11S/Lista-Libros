package com.example.libros.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.libros.room.Librosmodel
import kotlinx.coroutines.flow.Flow

@Dao
interface LibrosDao {
    @Query("select * from libros")
    fun obtenerLibros(): Flow<List<Librosmodel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun guardarLibros(librosmodel: Librosmodel)

    @Update
    fun actualizarLibros(librosModel: Librosmodel)

    @Query("DELETE FROM Libros")
    suspend fun eliminarTodosLibros()

    @Delete
    suspend fun eliminarLibros(librosModel: Librosmodel)

}