package com.alorma.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.unit.dp
import kotlin.math.min
import kotlin.math.roundToInt

@Composable
fun Banner(
    modifier: Modifier = Modifier,
    buttons: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    SubcomposeLayout(
        modifier = modifier
    ) { constraints ->
        val layoutWidth = constraints.maxWidth
        val layoutHeight = min(
            constraints.maxHeight, 112.dp.value.roundToInt()
        )

        val looseConstraints = constraints.copy(minWidth = 0, minHeight = 0)

        layout(layoutWidth, layoutHeight) {

            val buttonsPlaceables = subcompose("buttons") {
                buttons()
            }.take(2).map { measurable ->
                measurable.measure(looseConstraints.copy(maxWidth = layoutWidth))
            }
            val buttonSpace = 8.dp.value.roundToInt() * buttonsPlaceables.size
            val buttonsWidth = buttonsPlaceables.sumOf { it.width }
            val buttonsTotalWidth = buttonsWidth + buttonSpace

            val contentAvailableSpace = layoutWidth - buttonsTotalWidth

            val bodyContentPlaceables = subcompose("Banner") {
                ProvideTextStyle(value = MaterialTheme.typography.body2) {
                    content()
                }
            }.map { measurable ->
                measurable.measure(looseConstraints.copy(
                    maxHeight = layoutHeight,
                    maxWidth = layoutWidth - 16.dp.roundToPx() * 2
                ))
            }

            var buttonsYOffset = 10.dp.value.roundToInt()

            bodyContentPlaceables.forEach { placeable ->
                placeable.placeRelative(16.dp.roundToPx(), buttonsYOffset)
                if ((placeable.width + 16.dp.roundToPx()) > contentAvailableSpace) {
                    buttonsYOffset += placeable.height + 12.dp.roundToPx()
                }
            }

            val buttonX = layoutWidth - buttonsTotalWidth
            var buttonXOffset = 0

            val dividerY = buttonsYOffset + buttonsPlaceables.maxOf { it.height } + buttonSpace

            buttonsPlaceables.forEach { placeable ->
                val buttonYPosition = buttonX + buttonXOffset
                placeable.placeRelative(buttonYPosition, buttonsYOffset)
                buttonXOffset = placeable.width + buttonSpace
            }

            val dividerPlaceable = subcompose("divider") {
                Divider(
                    modifier = Modifier.fillMaxWidth()
                )
            }.map { measurable -> measurable.measure(looseConstraints) }

            dividerPlaceable
                .first()
                .placeRelative(0, dividerY)
        }
    }
}