package com.hienthai.spotifyapp.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.hienthai.spotifyapp.Constants.SONG_COLLECTION
import com.hienthai.spotifyapp.data.entities.Song
import kotlinx.coroutines.tasks.await

class MusicDatabase {
    private val fireStore = FirebaseFirestore.getInstance()

    private val songCollection = fireStore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch(e: Exception) {
            emptyList()
        }
    }
}