package com.example.zoombingo.data

import androidx.lifecycle.LiveData

class EventRepository(private val eventDao: EventDao) {
    val getAll: LiveData<List<Event>> = eventDao.getAll()
}