package com.sanjay.itunessearchapp.di

import android.content.Context
import androidx.room.Room
import com.sanjay.itunessearchapp.database.SongDao
import com.sanjay.itunessearchapp.database.SongDatabase
import com.sanjay.itunessearchapp.network.ITunesApi
import com.sanjay.itunessearchapp.utils.Constants.Companion.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): SongDatabase =
        Room.databaseBuilder(context,SongDatabase::class.java,"song_database")
            .build()

    @Provides
    fun providesDao(songDatabase: SongDatabase): SongDao =
       songDatabase.getDao()

    @Provides
    @Singleton
    fun providesMoshiInstance() : Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


    @Provides
    @Singleton
    fun providesRetrofitInstance(moshi: Moshi) : Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides
    @Singleton
    fun providesITunesApi(retrofit: Retrofit) : ITunesApi =
        retrofit.create(ITunesApi::class.java)
}