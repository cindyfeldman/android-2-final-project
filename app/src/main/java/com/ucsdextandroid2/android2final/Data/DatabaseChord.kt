package com.ucsdextandroid2.android2final.Data

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import com.ucsdextandroid2.android2final.ChordItemInterface

@Entity(tableName = "favorites")
@Parcelize

data class DatabaseChord(

//    val id: Int,
//    val type: String,
//    val title: String,
//    val artistName: String
    @ColumnInfo(name = "id") @PrimaryKey val id: Int,
    @ColumnInfo(name = "type") val type: String?,
    @ColumnInfo(name = "title")val title: String?,
    @ColumnInfo(name = "artistName")val artistName: String?

): Parcelable, ChordItemInterface {
    override fun getChordArtist(): String? {
        return artistName;
    }

    override fun getChordTitle(): String? {
      return title;
    }



}
