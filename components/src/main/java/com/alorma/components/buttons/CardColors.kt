package com.alorma.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SecondaryCard(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    border: BorderStroke? = null,
    elevation: Dp = 1.dp,
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier,
        shape = shape,
        backgroundColor = MaterialTheme.colors.secondary,
        border = border,
        elevation = elevation,
        content = content,
    )
}

@Composable
fun ErrorCard(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    border: BorderStroke? = null,
    elevation: Dp = 1.dp,
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier,
        shape = shape,
        backgroundColor = MaterialTheme.colors.error,
        border = border,
        elevation = elevation,
        content = content,
    )
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PrimaryCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    shape: Shape = MaterialTheme.shapes.medium,
    border: BorderStroke? = null,
    elevation: Dp = 1.dp,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    indication: Indication? = LocalIndication.current,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    content: @Composable () -> Unit,
) {
    if (onClick == null) {
        Card(
            backgroundColor = MaterialTheme.colors.primary,
            modifier = modifier,
            shape = shape,
            border = border,
            elevation = elevation,
            content = content,
        )
    } else {
        Card(
            backgroundColor = MaterialTheme.colors.primary,
            onClick = onClick,
            modifier = modifier,
            shape = shape,
            border = border,
            elevation = elevation,
            interactionSource = interactionSource,
            indication = indication,
            enabled = enabled,
            onClickLabel = onClickLabel,
            role = role,
            content = content,
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SecondaryCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    shape: Shape = MaterialTheme.shapes.medium,
    border: BorderStroke? = null,
    elevation: Dp = 1.dp,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    indication: Indication? = LocalIndication.current,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    content: @Composable () -> Unit,
) {
    if (onClick == null) {
        Card(
            backgroundColor = MaterialTheme.colors.secondary,
            modifier = modifier,
            shape = shape,
            border = border,
            elevation = elevation,
            content = content,
        )
    } else {
        Card(
            backgroundColor = MaterialTheme.colors.secondary,
            onClick = onClick,
            modifier = modifier,
            shape = shape,
            border = border,
            elevation = elevation,
            interactionSource = interactionSource,
            indication = indication,
            enabled = enabled,
            onClickLabel = onClickLabel,
            role = role,
            content = content,
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ErrorCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    shape: Shape = MaterialTheme.shapes.medium,
    border: BorderStroke? = null,
    elevation: Dp = 1.dp,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    indication: Indication? = LocalIndication.current,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    content: @Composable () -> Unit,
) {
    if (onClick == null) {
        Card(
            backgroundColor = MaterialTheme.colors.error,
            modifier = modifier,
            shape = shape,
            border = border,
            elevation = elevation,
            content = content,
        )
    } else {
        Card(
            backgroundColor = MaterialTheme.colors.error,
            onClick = onClick,
            modifier = modifier,
            shape = shape,
            border = border,
            elevation = elevation,
            interactionSource = interactionSource,
            indication = indication,
            enabled = enabled,
            onClickLabel = onClickLabel,
            role = role,
            content = content,
        )
    }
}
