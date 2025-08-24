package com.yousefzk.focusnotes.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun observeAll(): Flow<List<LocalNote>>

    @Query("SELECT * FROM notes WHERE id = :noteId")
    fun observeById(noteId: Int): Flow<LocalNote>

    @Insert
    suspend fun InsertNote(note: LocalNote)

    @Query("SELECT * FROM notes")
    suspend fun getAll(): List<LocalNote>

    @Query("SELECT * FROM notes WHERE id = :noteId")
    suspend fun getById(noteId: Int): LocalNote?

    @Upsert
    suspend fun upsert(note: LocalNote)

    @Upsert
    suspend fun upsertAll(notes: List<LocalNote>)

    @Query("DELETE FROM notes WHERE id = :noteId")
    suspend fun deleteById(noteId: Int) : Int

    @Query("DELETE FROM notes")
    suspend fun deleteAll()

}