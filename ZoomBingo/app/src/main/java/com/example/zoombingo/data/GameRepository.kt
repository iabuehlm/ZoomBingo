package com.example.zoombingo.data

import android.content.Context
import androidx.lifecycle.LiveData

class GameRepository(context: Context) {
    private val eventDao: EventDao = ZoomBingoDatabase
        .getDatabase(context)
        .eventDao()

    val events: LiveData<List<Event>> = eventDao.getAll()
}