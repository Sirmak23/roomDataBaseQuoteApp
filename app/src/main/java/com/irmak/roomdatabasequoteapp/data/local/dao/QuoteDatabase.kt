package com.irmak.roomdatabasequoteapp.data.local.dao

import android.content.Context
import androidx.room.*
import com.irmak.roomdatabasequoteapp.data.local.typeCoverter.DateTimeConverter
import com.irmak.roomdatabasequoteapp.Quote


@Database(entities = arrayOf(Quote::class), version = 1, exportSchema = false)
@TypeConverters(DateTimeConverter::class)
abstract class QuoteDatabase : RoomDatabase() {

    abstract fun quoteDao(): QuoteDao

    companion object {
        @Volatile
        private var INSTANCE: QuoteDatabase? = null

        fun getDatabase(context: Context): QuoteDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuoteDatabase::class.java,
                    "quote_database"
                ).build()
                INSTANCE = instance
                instance

            }
        }

    }

}