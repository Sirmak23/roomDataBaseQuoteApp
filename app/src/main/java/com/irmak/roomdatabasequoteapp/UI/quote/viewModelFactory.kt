package com.irmak.roomdatabasequoteapp.UI.quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.irmak.roomdatabasequoteapp.repository.QuoteRepository

class viewModelFactory(
    val newsRepository: QuoteRepository
):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuoteViewModel(newsRepository) as T
    }
}