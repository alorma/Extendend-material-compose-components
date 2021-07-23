package com.alorma.components.buttons

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
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
            ProvideTextStyle(value = MaterialTheme.typography.body2, content = content)
            Row(modifier = Modifier.padding(all = 8.dp)) {
                if (secondButton != null) {
                    secondButton()
                    Spacer(modifier = Modifier.size(8.dp))
                    firstButton()
                } else {
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

        if (contentPlaceable.width > buttonsXOffset) {
            buttonsYOffset = contentPlaceable.height
            boxHeight = buttonsYOffset + buttonsPlaceable.height
        }

        val dividerYOffset = boxHeight - dividerPlaceable.height

        layout(constrains.maxWidth, boxHeight) {
            contentPlaceable.place(0, 0)
            buttonsPlaceable.place(buttonsXOffset, buttonsYOffset)
            dividerPlaceable.place(0, dividerYOffset)
        }
    }
}