package com.alorma.components.samples

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alorma.components.buttons.ErrorCard
import com.alorma.components.buttons.PrimaryCard
import com.alorma.components.buttons.SecondaryCard

@Composable
fun CardColorsSample() {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        val cardModifier = Modifier
            .fillMaxWidth()
            .height(120.dp)

        val cardContent: @Composable (String) -> Unit = { text ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = text)
            }
        }
        PrimaryCard(
            modifier = cardModifier,
            onClick = {

            },
            content = { cardContent("Primary") },
        )
        Spacer(modifier = Modifier.height(16.dp))
        SecondaryCard(
            modifier = cardModifier,
            onClick = {

            },
            content = { cardContent("Primary") },
        )
        Spacer(modifier = Modifier.height(16.dp))
        ErrorCard(
            modifier = cardModifier,
            onClick = {

            },
            content = { cardContent("Primary") },
        )
    }
}