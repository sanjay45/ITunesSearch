package com.sanjay.itunessearchapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sanjay.itunessearchapp.model.Song


@Dao
interface SongDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(songList:List<Song>)

    @Query("SELECT * FROM song_table ORDER BY id DESC")
    fun getList(): LiveData<List<Song>>

    @Query("DELETE FROM song_table")
    suspend fun deleteAllSongs()


}