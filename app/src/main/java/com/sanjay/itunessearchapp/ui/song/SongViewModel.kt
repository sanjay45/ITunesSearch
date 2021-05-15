package com.sanjay.itunessearchapp.ui.song

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanjay.itunessearchapp.model.Song
import com.sanjay.itunessearchapp.utils.NetworkStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SongViewModel @Inject constructor(private val songRepository: SongRepository): ViewModel() {

    private val _status = MutableLiveData<NetworkStatus>()
    val status:LiveData<NetworkStatus> = _status

    val songList:LiveData<List<Song>> = songRepository.getSongList()

    fun fetchFromNetwork(name:String) = viewModelScope.launch {
        _status.postValue(NetworkStatus.Loading)
        try {
            songRepository.fetchFromNetwork(name)
            _status.postValue(NetworkStatus.Success)
        } catch (e:Exception) {
            _status.postValue(NetworkStatus.Error)
        }

    }

    fun deleteAllSongs() = viewModelScope.launch {
        songRepository.deleteAllSongs()
    }

}