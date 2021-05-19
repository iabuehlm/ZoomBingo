package com.example.zoombingo.data

import androidx.lifecycle.LiveData

class EventRepository(private val eventDao: EventDao) {
    fun getAll(): LiveData<List<Event>> = eventDao.getAll()
}