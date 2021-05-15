package com.sanjay.itunessearchapp.ui.song

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.sanjay.itunessearchapp.R
import com.sanjay.itunessearchapp.databinding.FragmentSongDetailsBinding


class SongDetailsFragment : Fragment() {

    private var _binding: FragmentSongDetailsBinding? = null
    private val binding  get() = _binding!!

    private val args: SongDetailsFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentSongDetailsBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentSong = args.song

        binding.apply {
            Glide.with(binding.root)
                .load(currentSong.artworkUrl100)
                .into(songPoster)

            artistName.text = currentSong.artistName
            trackName.text = currentSong.trackName
            genreName.text = currentSong.primaryGenreName
            collectionName.text = currentSong.collectionName
        }


    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}