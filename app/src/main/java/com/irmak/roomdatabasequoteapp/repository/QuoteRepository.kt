package com.irmak.roomdatabasequoteapp.repository

import androidx.lifecycle.LiveData
import com.irmak.roomdatabasequoteapp.Quote
import com.irmak.roomdatabasequoteapp.data.local.dao.QuoteDao

class QuoteRepository(private val quoteDao: QuoteDao) {
    fun getAllQuote():LiveData<List<Quote>> = quoteDao.getAllQuote()
    suspend fun insertQuote(quote: Quote)=quoteDao.insertQoute(quote)
    suspend fun updateQuote(quote: Quote)=quoteDao.updateQuote(quote)
    suspend fun deleteQuote(quote: Quote) = quoteDao.deleteQuote(quote)
    suspend fun deleteAll()=quoteDao.deleteAll()


}