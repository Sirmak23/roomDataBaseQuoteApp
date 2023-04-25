package com.irmak.roomdatabasequoteapp.UI.quote

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.WorkerThread
import androidx.appcompat.app.AppCompatActivity
import com.irmak.roomdatabasequoteapp.*
import com.irmak.roomdatabasequoteapp.data.local.dao.QuoteDao
import com.irmak.roomdatabasequoteapp.data.local.dao.QuoteDatabase
import com.irmak.roomdatabasequoteapp.repository.QuoteRepository
import kotlin.text.Typography.quote

class QuoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)

        val veriSayisi = findViewById<TextView>(R.id.veri)

        val quoteDao = QuoteDatabase.getDatabase(this).quoteDao()
        val repository = QuoteRepository(quoteDao)
        val viewModel: QuoteViewModel by viewModels <QuoteViewModel> {
            viewModelFactory(repository)
        }

        val deleteQuote = Quote(
            44L,
            "ırmak"
        )

        val updateQuote = Quote(
            8L,
            "süleyman"
        )
        val insert = Quote(
            152L,
            "süleyman ırmak"
        )

        fun addData(){
        viewModel.deleteAll()
        repeat(150) { index ->
            val quote = Quote(
                index.toLong(),
                "süleyman ırmak"
            )

            viewModel.insert(quote)

        }
            }
        findViewById<TextView>(R.id.delete).setOnClickListener{
            viewModel.deleteAll()
        }
        viewModel.updateQuote(updateQuote)
//        viewModel.deleteQoute(deleteQuote)
        veriSayisi.setOnClickListener{
            addData()
//            viewModel.insert(insert)
        }



        viewModel.quoteList.observe(this) {
//            Toast.makeText(this,it.size.toString(),Toast.LENGTH_SHORT).show()
            veriSayisi.text = it.size.toString()

        }



    }

    @WorkerThread
    suspend fun insertQuote(quoteDao: QuoteDao, quote: Quote) {
        quoteDao.insertQoute(quote)
    }
}





