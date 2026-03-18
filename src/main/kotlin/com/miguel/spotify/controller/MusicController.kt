package com.miguel.spotify.controller

import org.springframework.web.bind.annotation.RestController
import com.miguel.spotify.service.MusicService
import com.miguel.spotify.entity.Music
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/musics")
class MusicController(private val musicService: MusicService){

    @GetMapping
    fun listMusic() = musicService.listMusic()

    @PostMapping
    fun saveMusic(@RequestBody music: Music) = musicService.saveMusic(music)



}