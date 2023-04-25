package com.irmak.roomdatabasequoteapp.RelationDatabase

import androidx.room.Embedded
import androidx.room.Relation

data class UserAndLibrary(
    @Embedded val user:user,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userOwnerId"
    )
    val library: library

)
