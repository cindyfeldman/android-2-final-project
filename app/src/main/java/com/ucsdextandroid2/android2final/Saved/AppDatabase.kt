package com.ucsdextandroid2.android2final.Saved

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ucsdextandroid2.android2final.Data.DatabaseChord
import com.ucsdextandroid2.android2final.Data.SongsterrChordItem


@Database(entities = [DatabaseChord::class], version = 1)

abstract class AppDatabase : RoomDatabase() {

    abstract fun chordDao(): ChordsDao

    companion object {

        private const val DB_NAME = "chordsapp.db"

        @Volatile private var INSTANCE: AppDatabase? = null

        fun get(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }



        private fun buildDatabase(context: Context): AppDatabase {
            return Room
                .databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                .allowMainThreadQueries()
                .build()
        }
    }

}