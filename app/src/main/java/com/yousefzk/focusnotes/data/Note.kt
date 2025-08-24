package com.yousefzk.focusnotes.data

import java.time.LocalDateTime
import java.util.UUID

data class Note(
    val id: UUID,
    val title: String = "",
    val content: String = "",
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val isStarred: Boolean = false,
)
