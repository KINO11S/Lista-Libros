package com.example.libros.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.libros.room.Librosmodel
import com.example.libros.repository.LibrosRepository
import com.example.libros.room.LibrosDao
import com.example.libros.room.RoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LibrosViewModel(application: Application) : AndroidViewModel(application) {
    val listGastos  : LiveData<List<Librosmodel>>
    val repository : LibrosRepository

    init {
        val libroDao = RoomDatabase.getDatabase(application).LibrosDao()
        repository = LibrosRepository(libroDao)
        listGastos = repository.ObtenerTodosLibros()
    }
    fun insertGasto(libros: Librosmodel) =
        viewModelScope.launch(Dispatchers.IO) { repository.guardarLibros(libros) }
}

