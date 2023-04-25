package com.irmak.roomdatabasequoteapp.UI.quote

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.irmak.roomdatabasequoteapp.Quote
import com.irmak.roomdatabasequoteapp.repository.QuoteRepository
import kotlinx.coroutines.launch

class QuoteViewModel(private val repository: QuoteRepository) : ViewModel() {
    //    private val mutableQuoteList:MutableLiveData<List<Quote>> = MutableLiveData()
//    val quoteList: LiveData<List<Quote>>      //eğer view ayağı kalkerken data elimizde yoksa ve uzak sunucudan alacaksak mutable ile kullanmamız gerekir.
//    get() = mutableQuoteList

    val quoteList: LiveData<List<Quote>> = repository.getAllQuote()  // eğer data zaten elimizde data varsa uzak sunucudan almayacaksak bunu kullanabiliriz

    fun insert(quote: Quote) {
        viewModelScope.launch {
            repository.insertQuote(quote)
        }
    }

    fun updateQuote(quote: Quote) {
        viewModelScope.launch {
            repository.updateQuote(quote)
        }
    }

    fun deleteQoute(quote: Quote) {
        viewModelScope.launch {
            repository.deleteQuote(quote)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            repository.deleteAll()
        }

    }

//    fun getAllQuote(){
//        viewModelScope.launch {
//            mutableQuoteList.value = repository.getAllQuote().value
//        }
//    }

}

