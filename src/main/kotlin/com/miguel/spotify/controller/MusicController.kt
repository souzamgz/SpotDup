package com.miguel.spotify.controller

import com.miguel.spotify.dto.MusicRequest
import com.miguel.spotify.dto.MusicResponse
import org.springframework.web.bind.annotation.RestController
import com.miguel.spotify.service.MusicService
import com.miguel.spotify.entity.Music
import com.miguel.spotify.repository.MusicRepository
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/musics")
class MusicController(private val musicService: MusicService, private val musicRepository: MusicRepository){

    @GetMapping
    fun listMusic() = musicService.listMusic()

    @PostMapping
    fun saveMusic(@RequestBody request: MusicRequest) = musicService.saveMusic(request)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<MusicResponse> {
        val music = musicService.getMusicById(id)

        return if (music != null) {
            ResponseEntity.ok(music)
        } else {
            ResponseEntity.notFound().build()
        }
    }


    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Void> {
        val deleted = musicService.deleteMusicById(id)
        return if (deleted) {
            ResponseEntity.noContent().build()
        }else{
            ResponseEntity.noContent().build()
        }

    }

    @PutMapping("/{id}")
    fun updateById(@PathVariable id: Long, @RequestBody request: MusicRequest): ResponseEntity<MusicResponse> {
          val updated = musicService.updateMusic(id, request)
        return if (updated != null) {
            ResponseEntity.ok(updated)
        } else{
            ResponseEntity.notFound().build()
        }
    }
}