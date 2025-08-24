package com.yousefzk.focusnotes.data

import com.yousefzk.focusnotes.data.source.local.LocalNote

fun List<LocalNote>.toExternal() = map(LocalNote::toExternal)
fun LocalNote.toExternal() = Note(
    id = id,
    title = title,
    content = content,
    isStarred = isStarred,
    createdAt = createdAt
)

//toLocal
fun Note.toLocal() = LocalNote(
    id = id,
    title = title,
    content = content,
    isStarred = isStarred,
    createdAt = createdAt
)