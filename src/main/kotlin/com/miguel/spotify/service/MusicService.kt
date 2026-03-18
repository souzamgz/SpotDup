package com.miguel.spotify.service

import com.miguel.spotify.entity.Music
import com.miguel.spotify.repository.MusicRepository
import org.springframework.stereotype.Service

//Creating the class and getting "MusicRepository" finished inside it
@Service
class MusicService(private val musicRepository: MusicRepository){

    //Creating a function that enter in Table "Music" and bring all of them
    // Simplifying fun listMusic() = musicRepository.findAll()

    fun listMusic(): List<Music> {
        return musicRepository.findAll()
    }
    fun saveMusic(music: Music): Music {
        return musicRepository.save(music)
    }

    //If gets music return music, else return Null

    fun getMusicById(id: Long): Music? =
        musicRepository.findById(id).orElse(null)

}


