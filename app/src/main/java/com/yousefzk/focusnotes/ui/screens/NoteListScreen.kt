package com.yousefzk.focusnotes.ui.screens

import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.yousefzk.focusnotes.ui.components.CustomAddNoteFAB
import com.yousefzk.focusnotes.ui.components.CustomTopAppBar
import com.yousefzk.focusnotes.ui.components.NoteList

@Composable
fun NoteListScreen(drawerState: DrawerState) {
    Scaffold(
        topBar = { CustomTopAppBar(drawerState = drawerState) },
        floatingActionButton = { CustomAddNoteFAB() }
    ) { innerPadding ->
        NoteList(innerPadding)
    }

}