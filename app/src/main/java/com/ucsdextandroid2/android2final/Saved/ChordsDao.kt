package com.ucsdextandroid2.android2final.Saved

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ucsdextandroid2.android2final.Data.DatabaseChord
import com.ucsdextandroid2.android2final.Data.SongsterrChordItem
import com.ucsdextandroid2.android2final.Search.SearchActivity
import com.ucsdextandroid2.android2final.Search.SearchAdapter
import com.ucsdextandroid2.android2final.Search.SearchFragment

@Dao
interface ChordsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertChord(chord: DatabaseChord)

    @Delete
    fun deleteChord(chord: DatabaseChord)



    @Query("SELECT * FROM favorites ORDER BY artistName DESC")
    fun getAllChordsLiveData(): LiveData<List<DatabaseChord>>

}