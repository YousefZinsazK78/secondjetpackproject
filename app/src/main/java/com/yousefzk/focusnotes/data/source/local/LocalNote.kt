package com.yousefzk.focusnotes.data.source.local

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.UUID

@Entity(tableName = "notes")
data class LocalNote(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val title: String = "",
    val content: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val isStarred : Boolean,
)