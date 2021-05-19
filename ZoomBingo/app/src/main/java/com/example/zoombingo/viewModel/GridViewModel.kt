package com.example.zoombingo.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.zoombingo.data.Event
import com.example.zoombingo.data.EventRepository
import com.example.zoombingo.data.ZoomBingoDatabase

class GridViewModel(application: Application): AndroidViewModel(application) {

    private val eventRepository: EventRepository
    private val readAll: LiveData<List<Event>>

    init {
        val eventDao = ZoomBingoDatabase
            .getDatabase(application)
            .eventDao()
        eventRepository = EventRepository(eventDao)
        readAll = eventRepository.getAll()
    }
}