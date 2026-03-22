package com.miguel.spotify.service

import com.miguel.spotify.dto.MusicRequest
import com.miguel.spotify.dto.MusicResponse
import com.miguel.spotify.entity.Music
import com.miguel.spotify.repository.MusicRepository
import org.springframework.stereotype.Service

//Creating the class and getting "MusicRepository" finished inside it
@Service
class MusicService(private val musicRepository: MusicRepository){

    //Creating a function that enter in Table "Music" and bring all of them
    // Simplifying fun listMusic() = musicRepository.findAll()

    fun listMusic(): List<MusicResponse> {
        val musics = musicRepository.findAll()

        return musics.map { music ->
            MusicResponse(
                id = music.id!!,
                title = music.title!!,
                artist = music.artist!!,
                durationMs = music.durationMs!!
            )
        }
    }
    fun saveMusic(request: MusicRequest): MusicResponse {
        val music = Music()

        music.title = request.title
        music.artist = request.artist
        music.durationMs = request.durationMs

        val saved = musicRepository.save(music)

        return MusicResponse(
            id = saved.id!!,
            title = saved.title!!,
            artist = saved.artist!!,
            durationMs = saved.durationMs!!
        )
    }

    //If gets music return music, else return Null

    fun getMusicById(id: Long): MusicResponse? {
        val music = musicRepository.findById(id).orElse(null)?: return null
        return MusicResponse(
            id = music.id!!,
            title = music.title!!,
            artist = music.artist!!,
            durationMs = music.durationMs!!
        )
    }

    fun deleteMusicById(id: Long): Boolean {
          val exists = musicRepository.existsById(id)
          if (!exists) return false
        musicRepository.deleteById(id)
        return true
    }

    fun updateMusic(id: Long, request: MusicRequest): MusicResponse? {
          val existing = musicRepository.findById(id).orElse(null) ?: return null

        existing.title = request.title
        existing.artist = request.artist
        existing.durationMs = request.durationMs

        val saved = musicRepository.save(existing)
        return MusicResponse(
            id = saved.id!!,
            title = saved.title!!,
            artist = saved.artist!!,
            durationMs = saved.durationMs!!
        )
    }


}


