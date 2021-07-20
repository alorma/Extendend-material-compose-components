package com.alorma.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.alorma.components.buttons.ErrorButton
import com.alorma.components.buttons.ErrorOutlinedButton
import com.alorma.components.buttons.ErrorTextButton
import com.alorma.components.buttons.PrimaryButton
import com.alorma.components.buttons.PrimaryOutlinedButton
import com.alorma.components.buttons.PrimaryTextButton
import com.alorma.components.buttons.SecondaryButton
import com.alorma.components.buttons.SecondaryOutlinedButton
import com.alorma.components.buttons.SecondaryTextButton
import com.alorma.components.ui.theme.ExtendedMaterialComposecomponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExtendedMaterialComposecomponentsTheme {

                var enabledStated by remember { mutableStateOf(true) }

                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Title(text = "Buttons")
                    EnabledSwitch(
                        checked = enabledStated,
                        onCheckedChange = { newValue -> enabledStated = newValue }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    FilledButtons(enabled = enabledStated)
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedButtons(enabled = enabledStated)
                    Spacer(modifier = Modifier.height(16.dp))
                    TextButtons(enabled = enabledStated)
                }
            }
        }
    }
}

@Composable
fun Title(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            color = MaterialTheme.colors.onSurface,
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
fun EnabledSwitch(
    checked: Boolean = true,
    onCheckedChange: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier
            .height(48.dp)
            .clip(shape = MaterialTheme.shapes.medium)
            .clickable { onCheckedChange(!checked) }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = MaterialTheme.colors.onSurface,
            text = "Enabled"
        )
        Switch(checked = checked, onCheckedChange = null)
    }
}

@Composable
fun FilledButtons(enabled: Boolean) {
    Row {
        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            enabled = enabled,
            onClick = {},
        ) {
            Text(text = "Primary")
        }
        Spacer(modifier = Modifier.width(8.dp))
        SecondaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            enabled = enabled,
            onClick = {},
        ) {
            Text(text = "Secondary")
        }
        Spacer(modifier = Modifier.width(8.dp))
        ErrorButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            enabled = enabled,
            onClick = {},
        ) {
            Text(text = "Error")
        }
    }
}

@Composable
fun OutlinedButtons(enabled: Boolean) {
    Row {
        PrimaryOutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            enabled = enabled,
            onClick = {},
        ) {
            Text(text = "Primary")
        }
        Spacer(modifier = Modifier.width(8.dp))
        SecondaryOutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            enabled = enabled,
            onClick = {},
        ) {
            Text(text = "Secondary")
        }
        Spacer(modifier = Modifier.width(8.dp))
        ErrorOutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            enabled = enabled,
            onClick = {},
        ) {
            Text(text = "Error")
        }
    }
}

@Composable
fun TextButtons(enabled: Boolean) {
    Row {
        PrimaryTextButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            enabled = enabled,
            onClick = {},
        ) {
            Text(text = "Primary")
        }
        Spacer(modifier = Modifier.width(8.dp))
        SecondaryTextButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            enabled = enabled,
            onClick = {},
        ) {
            Text(text = "Secondary")
        }
        Spacer(modifier = Modifier.width(8.dp))
        ErrorTextButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            enabled = enabled,
            onClick = {},
        ) {
            Text(text = "Error")
        }
    }
}