package com.yousefzk.focusnotes.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.DrawerState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yousefzk.focusnotes.data.source.local.LocalNote
import com.yousefzk.focusnotes.data.source.local.NoteDatabase
import com.yousefzk.focusnotes.ui.components.CustomAddNoteFAB
import com.yousefzk.focusnotes.ui.components.CustomTopAppBar
import kotlinx.coroutines.launch
import java.time.LocalDateTime

@Composable
fun AddNoteScreen(drawerState: DrawerState) {

    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }

    val noteDao = NoteDatabase.getDatabase(LocalContext.current).noteDao()
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            CustomTopAppBar(drawerState)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    val note = LocalNote(
                        title = title,
                        content = content,
                        createdAt = LocalDateTime.now(),
                        updatedAt = LocalDateTime.now()
                    )
                    scope.launch {
                        noteDao.InsertNote(note)
                    }

                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "add icon"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title (Optional)") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = content,
                onValueChange = { content = it },
                label = { Text("content") },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        }
    }
}