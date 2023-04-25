package com.irmak.roomdatabasequoteapp.RelationDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class library(
    @PrimaryKey
    val libraryId:Long,
    val userOwnerId:Long
)