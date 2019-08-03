package com.ucsdextandroid2.android2final.Data

import androidx.room.Database
import androidx.room.Entity
import com.ucsdextandroid2.android2final.ChordItemInterface


data class SongsterrChordItem(
    val id: Int,
    val type: String,
    val title: String,
    val artist: Artist,
    val chordsPresent: Boolean,
    val tabTypes: List<String>
): ChordItemInterface
{
    override fun getChordArtist(): String? {
        return artist.name;
    }

    override fun getChordTitle(): String? {
        return title;
    }

    fun toDatabaseChord(): DatabaseChord {
        return DatabaseChord(id, type, title, artist.name)
    }

}
