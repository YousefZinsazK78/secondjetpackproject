package com.yousefzk.focusnotes.data.repository

import com.yousefzk.focusnotes.data.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    fun getNotesStream(): Flow<List<Note>>
    suspend fun createNote(title: String, content: String): String
    suspend fun refresh()
    suspend fun updateNote(noteId: String, title: String, content: String, isStarred: Boolean)
    suspend fun getNote(noteId: String, forceUpdate: Boolean = false): Note?
}