package com.example.zoombingo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Event::class], version = 1, exportSchema = false)
abstract class ZoomBingoDatabase: RoomDatabase() {
    abstract fun eventDao(): EventDao

    companion object {
        @Volatile
        private var INSTANCE: ZoomBingoDatabase? = null

        fun getDatabase(context: Context): ZoomBingoDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            else {
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ZoomBingoDatabase::class.java,
                        "zoomBingoDatabase"
                    ).build()
                    INSTANCE = instance
                    return instance
                }
            }
        }
    }
}