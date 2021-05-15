package com.sanjay.itunessearchapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sanjay.itunessearchapp.model.Song

@Database(entities = [Song::class],version = 1,exportSchema = false)
abstract class SongDatabase : RoomDatabase() {

    abstract fun getDao(): SongDao
}