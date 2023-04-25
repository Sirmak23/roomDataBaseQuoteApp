package com.irmak.roomdatabasequoteapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Transaction
import com.irmak.roomdatabasequoteapp.RelationDatabase.UserAndLibrary
import com.irmak.roomdatabasequoteapp.RelationDatabase.library
import com.irmak.roomdatabasequoteapp.RelationDatabase.user

@Dao
interface SongDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertUser(user: user)

    @Insert(onConflict = REPLACE)
    suspend fun insertLibrary(library: library)

    @Transaction
    @Query("SELECT * FROM user")
    fun getUserAndLibraries(): List<UserAndLibrary>
}
