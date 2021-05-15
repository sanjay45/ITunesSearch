package com.sanjay.itunessearchapp.network

import com.sanjay.itunessearchapp.model.Song

data class ITunesApiResponse(
    val results: List<Song>
    )