package com.alorma.components.samples

import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import com.alorma.components.buttons.ActionItem
import com.alorma.components.buttons.TopAppBar

@Composable
fun SampleTopAppBar(
    onActionClick: (ActionItem) -> Boolean = { true },
) {
    val actions = List(7) { value ->
        ActionItem(
            id = value,
            icon = Icons.Default.Person.takeIf { value % 2 == 0 },
            content = { Text(text = "Action $value") },
            contentDescription = "Action $value",
            onClick = onActionClick,
        )
    }

    TopAppBar(
        title = { Text(text = "Sample") },
        actions = actions,
    )
}