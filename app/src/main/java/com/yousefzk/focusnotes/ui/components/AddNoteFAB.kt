package com.yousefzk.focusnotes.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun CustomAddNoteFAB(modifier: Modifier = Modifier) {
    ExtendedFloatingActionButton(
        text = { Text(text = "Add Note") },
        icon = { Icon(imageVector = Icons.Default.Add, contentDescription = "add note icon") },
        onClick = { },
        modifier = modifier.padding(16.dp)

    )
}