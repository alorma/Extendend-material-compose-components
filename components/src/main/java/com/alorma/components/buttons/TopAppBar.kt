package com.alorma.components.buttons

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun OverflowMenu(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    contentDescription: String? = null,
    actions: List<ActionItem>,
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            actions.forEach { action ->
                DropdownMenuItem(onClick = {
                    val consumed = action.onClick(action)
                    if (consumed) {
                        expanded = false
                    }
                }) {
                    Text(text = action.title)
                }
            }
        }
        IconButton(
            onClick = { expanded = true },
            modifier = modifier,
            enabled = enabled,
            interactionSource = interactionSource,
        ) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = contentDescription
            )
        }
    }
}

data class ActionItem(
    val id: Int,
    val title: String,
    val contentDescription: String? = null,
    val onClick: (ActionItem) -> Boolean,
)