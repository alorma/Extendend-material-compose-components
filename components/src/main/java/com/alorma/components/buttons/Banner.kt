package com.alorma.components.buttons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp

@Composable
fun Banner(
    modifier: Modifier = Modifier,
    firstButton: @Composable () -> Unit,
    secondButton: (@Composable () -> Unit)? = null,
    divider: @Composable () -> Unit = { Divider(modifier = Modifier.fillMaxWidth()) },
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier,
        content = {
            Box(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                contentAlignment = Alignment.CenterStart,
            ) {
                ProvideTextStyle(value = MaterialTheme.typography.body2) {
                    content()
                }
            }
            if (secondButton != null) {
                Row(modifier = Modifier.padding(horizontal = 8.dp)) {
                    firstButton()
                    Spacer(modifier = Modifier.size(8.dp))
                    secondButton()
                }
            } else {
                Box(modifier = Modifier.padding(horizontal = 8.dp)) {
                    firstButton()
                }
            }
            divider()
        },
    ) { measurable, constrains ->

        val noMinConstrains = constrains.copy(
            minWidth = 0,
            minHeight = 0,
        )

        val contentMeasurable = measurable[0]
        val buttonsMeasurable = measurable[1]
        val dividerMeasurable = measurable[2]

        val contentPlaceable = contentMeasurable.measure(noMinConstrains)
        val buttonsPlaceable = buttonsMeasurable.measure(noMinConstrains)
        val dividerPlaceable = dividerMeasurable.measure(noMinConstrains)

        var buttonsYOffset = 0
        val buttonsXOffset = constrains.maxWidth - buttonsPlaceable.width

        var boxHeight = maxOf(
            contentPlaceable.height,
            buttonsPlaceable.height,
        ) + dividerPlaceable.height

        if (contentPlaceable.width > constrains.maxWidth - buttonsXOffset) {
            buttonsYOffset = 8.dp.roundToPx() + contentPlaceable.height
            boxHeight = buttonsYOffset + buttonsPlaceable.height + 8.dp.roundToPx()
        }

        val dividerYOffset = boxHeight - dividerPlaceable.height

        layout(constrains.maxWidth, boxHeight) {
            contentPlaceable.place(0, 0)
            buttonsPlaceable.place(buttonsXOffset, buttonsYOffset)
            dividerPlaceable.place(0, dividerYOffset)
        }
    }
}