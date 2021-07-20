package com.alorma.components.buttons

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

/*
    Filled button colors
*/

@Composable
fun ButtonDefaults.primaryButtonColors(): ButtonColors = buttonColors(
    backgroundColor = MaterialTheme.colors.primary
)

@Composable
fun ButtonDefaults.primaryVariantButtonColors(): ButtonColors = buttonColors(
    backgroundColor = MaterialTheme.colors.primaryVariant
)

@Composable
fun ButtonDefaults.secondaryButtonColors(): ButtonColors = buttonColors(
    backgroundColor = MaterialTheme.colors.secondary
)

@Composable
fun ButtonDefaults.secondaryVariantButtonColors(): ButtonColors = buttonColors(
    backgroundColor = MaterialTheme.colors.secondaryVariant
)

@Composable
fun ButtonDefaults.backgroundButtonColors(): ButtonColors = buttonColors(
    backgroundColor = MaterialTheme.colors.background
)

@Composable
fun ButtonDefaults.surfaceButtonColors(): ButtonColors = buttonColors(
    backgroundColor = MaterialTheme.colors.surface
)

@Composable
fun ButtonDefaults.errorButtonColors(): ButtonColors = buttonColors(
    backgroundColor = MaterialTheme.colors.error
)

@Composable
fun ButtonDefaults.onPrimaryButtonColors(): ButtonColors = buttonColors(
    backgroundColor = MaterialTheme.colors.onPrimary,
    contentColor = MaterialTheme.colors.onSurface,
)

@Composable
fun ButtonDefaults.onSecondaryButtonColors(): ButtonColors = buttonColors(
    backgroundColor = MaterialTheme.colors.onSecondary,
    contentColor = if (isSystemInDarkTheme()) {
        MaterialTheme.colors.onSurface
    } else {
        MaterialTheme.colors.surface
    },
)

@Composable
fun ButtonDefaults.onBackgroundButtonColors(): ButtonColors = buttonColors(
    backgroundColor = MaterialTheme.colors.onBackground,
    contentColor = MaterialTheme.colors.background,
)

@Composable
fun ButtonDefaults.onSurfaceButtonColors(): ButtonColors = buttonColors(
    backgroundColor = MaterialTheme.colors.onSurface,
    contentColor = MaterialTheme.colors.surface,
)

@Composable
fun ButtonDefaults.onErrorButtonColors(): ButtonColors = buttonColors(
    backgroundColor = MaterialTheme.colors.onError,
    contentColor = MaterialTheme.colors.onSurface,
)


/*
    Outlined button colors
*/

@Composable
fun ButtonDefaults.primaryOutlinedButtonColors(): ButtonColors = outlinedButtonColors(
    contentColor = MaterialTheme.colors.primary
)

@Composable
fun ButtonDefaults.primaryVariantOutlinedButtonColors(): ButtonColors = outlinedButtonColors(
    contentColor = MaterialTheme.colors.primaryVariant
)

@Composable
fun ButtonDefaults.secondaryOutlinedButtonColors(): ButtonColors = outlinedButtonColors(
    contentColor = MaterialTheme.colors.secondary
)

@Composable
fun ButtonDefaults.secondaryVariantOutlinedButtonColors(): ButtonColors = outlinedButtonColors(
    contentColor = MaterialTheme.colors.secondaryVariant
)

@Composable
fun ButtonDefaults.backgroundOutlinedButtonColors(): ButtonColors = outlinedButtonColors(
    contentColor = MaterialTheme.colors.onBackground,
)

@Composable
fun ButtonDefaults.surfaceOutlinedButtonColors(): ButtonColors = outlinedButtonColors(
    contentColor = MaterialTheme.colors.onSurface,
)

@Composable
fun ButtonDefaults.errorOutlinedButtonColors(): ButtonColors = outlinedButtonColors(
    contentColor = MaterialTheme.colors.error
)

@Composable
fun ButtonDefaults.onPrimaryOutlinedButtonColors(): ButtonColors = outlinedButtonColors(
    contentColor = MaterialTheme.colors.onSurface,
)

@Composable
fun ButtonDefaults.onSecondaryOutlinedButtonColors(): ButtonColors = outlinedButtonColors(
    contentColor = MaterialTheme.colors.onSurface,
)

@Composable
fun ButtonDefaults.onBackgroundOutlinedButtonColors(): ButtonColors = outlinedButtonColors(
    contentColor = MaterialTheme.colors.onBackground
)

@Composable
fun ButtonDefaults.onSurfaceOutlinedButtonColors(): ButtonColors = outlinedButtonColors(
    contentColor = MaterialTheme.colors.onSurface
)

@Composable
fun ButtonDefaults.onErrorOutlinedButtonColors(): ButtonColors = outlinedButtonColors(
    contentColor = MaterialTheme.colors.onSurface,
)


/*
    Text button colors
*/

@Composable
fun ButtonDefaults.primaryTextButtonColors(): ButtonColors = textButtonColors(
    contentColor = MaterialTheme.colors.primary
)

@Composable
fun ButtonDefaults.primaryVariantTextButtonColors(): ButtonColors = textButtonColors(
    contentColor = MaterialTheme.colors.primaryVariant
)

@Composable
fun ButtonDefaults.secondaryTextButtonColors(): ButtonColors = textButtonColors(
    contentColor = MaterialTheme.colors.secondary
)

@Composable
fun ButtonDefaults.secondaryVariantTextButtonColors(): ButtonColors = textButtonColors(
    contentColor = MaterialTheme.colors.secondaryVariant
)

@Composable
fun ButtonDefaults.backgroundTextButtonColors(): ButtonColors = textButtonColors(
    contentColor = MaterialTheme.colors.onBackground,
)

@Composable
fun ButtonDefaults.surfaceTextButtonColors(): ButtonColors = textButtonColors(
    contentColor = MaterialTheme.colors.onSurface,
)

@Composable
fun ButtonDefaults.errorTextButtonColors(): ButtonColors = textButtonColors(
    contentColor = MaterialTheme.colors.error
)

@Composable
fun ButtonDefaults.onPrimaryTextButtonColors(): ButtonColors = textButtonColors(
    contentColor = MaterialTheme.colors.onSurface,
)

@Composable
fun ButtonDefaults.onSecondaryTextButtonColors(): ButtonColors = textButtonColors(
    contentColor = MaterialTheme.colors.onSurface,
)

@Composable
fun ButtonDefaults.onBackgroundTextButtonColors(): ButtonColors = textButtonColors(
    contentColor = MaterialTheme.colors.onBackground
)

@Composable
fun ButtonDefaults.onSurfaceTextButtonColors(): ButtonColors = textButtonColors(
    contentColor = MaterialTheme.colors.onSurface
)

@Composable
fun ButtonDefaults.onErrorTextButtonColors(): ButtonColors = textButtonColors(
    contentColor = MaterialTheme.colors.onSurface,
)
