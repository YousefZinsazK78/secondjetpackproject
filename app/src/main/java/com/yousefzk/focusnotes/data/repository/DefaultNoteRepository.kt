package com.yousefzk.focusnotes.data.repository

import com.yousefzk.focusnotes.data.Note
import com.yousefzk.focusnotes.data.source.local.NoteDao
import com.yousefzk.focusnotes.data.toExternal
import com.yousefzk.focusnotes.data.toLocal
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID

class DefaultNoteRepository @Inject constructor(
    private val localDataSource: NoteDao
) : NotesRepository {
    override fun getNotesStream(): Flow<List<Note>> {
        return localDataSource.observeAll().map { notes -> notes.toExternal() }
    }

    override suspend fun createNote(title: String, content: String): String {
        val noteId = UUID.randomUUID()
        val note = Note(
            id = noteId,
            title = title,
            content = content,
            isStarred = false,
        )
        localDataSource.upsert(note.toLocal())
        return ""
    }

    override suspend fun refresh() {
        TODO("Not yet implemented")
    }

    override suspend fun updateNote(
        noteId: String,
        title: String,
        content: String,
        isStarred: Boolean
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun getNote(
        noteId: String,
        forceUpdate: Boolean
    ): Note? {
        TODO("Not yet implemented")
    }

}

