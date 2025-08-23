package com.yousefzk.focusnotes.data.source.local

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface NoteDao {

    @Insert
    fun InsertNote(note: LocalNote)

}