package com.sanjay.itunessearchapp.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "song_table")
@Parcelize
data class Song(
    val trackName: String?,
    val artistName:String,
    @ColumnInfo(name = "image_url")
    val artworkUrl100: String,
    val collectionName:String,
    @ColumnInfo(name = "genre_name")
    val primaryGenreName:String
): Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}
