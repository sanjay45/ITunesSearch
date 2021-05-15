package com.sanjay.itunessearchapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sanjay.itunessearchapp.databinding.ItemLayoutBinding
import com.sanjay.itunessearchapp.model.Song

class SongAdapter(private val onClick: (Song) -> Unit): ListAdapter<Song,SongAdapter.SongViewHolder>(SongDiffUtilCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val binding = ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false)
        return SongViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val currentSong = getItem(position)
        holder.bind(currentSong)
    }

    inner class SongViewHolder(private val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {

        private var currentSong:Song? = null

        init {
            itemView.setOnClickListener {
                currentSong?.let {
                    onClick(it)
                }
            }
        }


        fun bind(song: Song) {
            currentSong = song
          binding.apply {
              Glide.with(binding.root)
                  .load(song.artworkUrl100)
                  .into(songImage)

              trackName.text = song.trackName
              song.trackName?.let { Log.i("response", it) }
              song.artistName?.let { Log.i("response", it) }
              artistName.text = song.artistName
          }
        }
    }
}

object SongDiffUtilCallback : DiffUtil.ItemCallback<Song>() {
    override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
        return oldItem == newItem
    }

}