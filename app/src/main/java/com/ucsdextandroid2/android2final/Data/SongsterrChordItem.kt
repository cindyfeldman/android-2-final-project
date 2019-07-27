package com.ucsdextandroid2.android2final.Data

data class SongsterrChordItem(
    val id: Int,
    val type: String,
    val title: String,
    val artist: Artist,
    val chordsPresent: Boolean,
    val tabTypes: List<String>
)
