package com.alorma.components.samples

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.alorma.components.buttons.ActionItem
import com.alorma.components.buttons.OverflowMenu

@Composable
fun SampleTopAppBar(
    onActionClick: (ActionItem) -> Boolean= { true },
) {
    TopAppBar(
        title = { Text(text = "Sample") },
        actions = {
            val actions = listOf(
                ActionItem(
                    id = 0,
                    title = "Action 1",
                    onClick = onActionClick,
                ),
                ActionItem(
                    id = 1,
                    title = "Action 2",
                    onClick = onActionClick,
                ),
            )
            OverflowMenu(actions = actions)
        }
    )
}