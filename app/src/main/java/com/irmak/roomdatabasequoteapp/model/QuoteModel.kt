package com.irmak.roomdatabasequoteapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quote_table")
data class Quote(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id_column")
    val id: Long,

    @ColumnInfo("text_column")
    val text: String
)