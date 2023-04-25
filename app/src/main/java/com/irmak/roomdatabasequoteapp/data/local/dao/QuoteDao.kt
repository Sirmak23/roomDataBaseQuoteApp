package com.irmak.roomdatabasequoteapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.irmak.roomdatabasequoteapp.Quote

@Dao
interface QuoteDao {
    @Query("SELECT * FROM quote_table ORDER BY text_column ASC")
    fun getAllQuote(): LiveData<List<Quote>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertQoute(quote: Quote)

    @Delete
    suspend fun deleteQuote(quote: Quote)

    @Update
    suspend fun updateQuote(quote: Quote)

    @Query("DELETE FROM quote_table")
    suspend fun deleteAll()



}
