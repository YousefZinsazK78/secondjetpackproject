package com.yousefzk.focusnotes.ui.screens

import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yousefzk.focusnotes.ui.components.drawer.DrawerBody
import com.yousefzk.focusnotes.ui.components.drawer.DrawerHeader

@Preview
@Composable
fun FocusNoteApp() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val navController = rememberNavController()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(240.dp),
                drawerContentColor = MaterialTheme.colorScheme.onSurface,
                drawerShape = MaterialTheme.shapes.large,
            ) {
                DrawerHeader()
                DrawerBody()
            }
        },
        content = {
            NavHost(navController = navController, startDestination = "note_list") {
                composable(route = "note_list") {
                    NoteListScreen(
                        drawerState,
                        onClickFab = {
                            navController.navigate("add_note")
                        })
                }

                composable(route = "add_note") {
                    AddNoteScreen(drawerState)
                }

            }
        }
    )
}