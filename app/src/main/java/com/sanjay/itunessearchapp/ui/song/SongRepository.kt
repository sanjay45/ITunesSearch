package com.sanjay.itunessearchapp.ui.song

import com.sanjay.itunessearchapp.database.SongDao
import com.sanjay.itunessearchapp.network.ITunesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SongRepository @Inject constructor(private val iTunesApi: ITunesApi,
                                         private val songDao: SongDao) {

    fun getSongList() = songDao.getList()

  suspend  fun fetchFromNetwork(artistName:String) {
        withContext(Dispatchers.IO) {
           val response =  iTunesApi.searchSongs(artistName)
            response.body()?.let {
                songDao.insert(it.results)
            }
        }
    }

    suspend fun deleteAllSongs() = songDao.deleteAllSongs()

}