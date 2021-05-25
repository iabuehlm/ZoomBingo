package com.example.zoombingo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event")
data class Event(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val eventText: String
)