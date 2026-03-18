package com.miguel.spotify.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.GenerationType
import jakarta.persistence.Table

//Entity = Table Model = Persisted int the db
@Entity
@Table(name = "musics")
class Music{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    var id: Long? = null
    @Column
    var title: String? = null
    @Column
    var artist: String? = null
    @Column
    var durationMs: Long? = null

}
