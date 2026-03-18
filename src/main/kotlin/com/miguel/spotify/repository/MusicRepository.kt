//Where this interface stays
package com.miguel.spotify.repository

import com.miguel.spotify.entity.Music
import org.springframework.data.jpa.repository.JpaRepository

//My Entity + Type
interface MusicRepository : JpaRepository<Music, Long>
