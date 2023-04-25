package com.irmak.roomdatabasequoteapp.RelationDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class user(
    @PrimaryKey
    val userId:Long,
    val name:String,
    val age:Int
)