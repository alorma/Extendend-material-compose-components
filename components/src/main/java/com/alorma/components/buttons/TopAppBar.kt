package com.alorma.components.buttons

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import kotlin.math.min

@Composable
fun TopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    maxActions: Int = 2,
    actions: List<ActionItem> = emptyList(),
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = AppBarDefaults.TopAppBarElevation,
) {
    androidx.compose.material.TopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = navigationIcon,
        actions = {
            val showAsActionItems = actions.take(min(3, maxActions))
            val overflowItems = actions.subtract(showAsActionItems)

            showAsActionItems.forEach { action ->
                if (action.icon != null) {
                    IconButton(
                        onClick = { action.onClick(action) },
                    ) {
                        Icon(
                            imageVector = action.icon,
                            contentDescription = action.contentDescription
                        )
                    }
                } else {
                    TextButton(
                        onClick = { action.onClick(action) },
                        content = { action.content() },
                        colors = ButtonDefaults.textButtonColors(contentColor = contentColor)
                    )
                }
            }
            if (overflowItems.isNotEmpty()) {
                OverflowMenu(actions = overflowItems.toList())
            }
        },
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = elevation,
    )
}

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
            modifier = Modifier.wrapContentWidth(),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            actions.forEach { action ->
                DropdownMenuItem(
                    onClick = {
                        val consumed = action.onClick(action)
                        if (consumed) {
                            expanded = false
                        }
                    },
                    content = {
                        action.content()
                    },
                )
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
    val content: @Composable () -> Unit = {},
    val icon: ImageVector? = null,
    val contentDescription: String? = null,
    val onClick: (ActionItem) -> Boolean,
)