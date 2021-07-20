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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.alorma.components.buttons.backgroundButtonColors
import com.alorma.components.buttons.backgroundOutlinedButtonColors
import com.alorma.components.buttons.backgroundTextButtonColors
import com.alorma.components.buttons.errorButtonColors
import com.alorma.components.buttons.errorOutlinedButtonColors
import com.alorma.components.buttons.errorTextButtonColors
import com.alorma.components.buttons.onBackgroundButtonColors
import com.alorma.components.buttons.onBackgroundOutlinedButtonColors
import com.alorma.components.buttons.onBackgroundTextButtonColors
import com.alorma.components.buttons.onErrorButtonColors
import com.alorma.components.buttons.onErrorOutlinedButtonColors
import com.alorma.components.buttons.onErrorTextButtonColors
import com.alorma.components.buttons.onPrimaryButtonColors
import com.alorma.components.buttons.onPrimaryOutlinedButtonColors
import com.alorma.components.buttons.onPrimaryTextButtonColors
import com.alorma.components.buttons.onSecondaryButtonColors
import com.alorma.components.buttons.onSecondaryOutlinedButtonColors
import com.alorma.components.buttons.onSecondaryTextButtonColors
import com.alorma.components.buttons.onSurfaceButtonColors
import com.alorma.components.buttons.onSurfaceOutlinedButtonColors
import com.alorma.components.buttons.onSurfaceTextButtonColors
import com.alorma.components.buttons.primaryButtonColors
import com.alorma.components.buttons.primaryOutlinedButtonColors
import com.alorma.components.buttons.primaryTextButtonColors
import com.alorma.components.buttons.primaryVariantButtonColors
import com.alorma.components.buttons.primaryVariantOutlinedButtonColors
import com.alorma.components.buttons.primaryVariantTextButtonColors
import com.alorma.components.buttons.secondaryButtonColors
import com.alorma.components.buttons.secondaryOutlinedButtonColors
import com.alorma.components.buttons.secondaryTextButtonColors
import com.alorma.components.buttons.secondaryVariantButtonColors
import com.alorma.components.buttons.secondaryVariantOutlinedButtonColors
import com.alorma.components.buttons.secondaryVariantTextButtonColors
import com.alorma.components.buttons.surfaceButtonColors
import com.alorma.components.buttons.surfaceOutlinedButtonColors
import com.alorma.components.buttons.surfaceTextButtonColors
import com.alorma.components.ui.theme.ExtendedMaterialComposecomponentsTheme

class MainActivity : ComponentActivity() {

    private val buttonColors: List<Pair<String, ButtonColors>>
        @Composable
        get() = listOf(
            "primary" to ButtonDefaults.primaryButtonColors(),
            "primaryVariant" to ButtonDefaults.primaryVariantButtonColors(),
            "secondary" to ButtonDefaults.secondaryButtonColors(),
            "secondaryVariant" to ButtonDefaults.secondaryVariantButtonColors(),
            "background" to ButtonDefaults.backgroundButtonColors(),
            "surface" to ButtonDefaults.surfaceButtonColors(),
            "error" to ButtonDefaults.errorButtonColors(),
            "onPrimary" to ButtonDefaults.onPrimaryButtonColors(),
            "onSecondary" to ButtonDefaults.onSecondaryButtonColors(),
            "onBackground" to ButtonDefaults.onBackgroundButtonColors(),
            "onSurface" to ButtonDefaults.onSurfaceButtonColors(),
            "onError" to ButtonDefaults.onErrorButtonColors(),
        )

    private val outlinedButtonColors: List<Pair<String, ButtonColors>>
        @Composable
        get() = listOf(
            "primary" to ButtonDefaults.primaryOutlinedButtonColors(),
            "primaryVariant" to ButtonDefaults.primaryVariantOutlinedButtonColors(),
            "secondary" to ButtonDefaults.secondaryOutlinedButtonColors(),
            "secondaryVariant" to ButtonDefaults.secondaryVariantOutlinedButtonColors(),
            "background" to ButtonDefaults.backgroundOutlinedButtonColors(),
            "surface" to ButtonDefaults.surfaceOutlinedButtonColors(),
            "error" to ButtonDefaults.errorOutlinedButtonColors(),
            "onPrimary" to ButtonDefaults.onPrimaryOutlinedButtonColors(),
            "onSecondary" to ButtonDefaults.onSecondaryOutlinedButtonColors(),
            "onBackground" to ButtonDefaults.onBackgroundOutlinedButtonColors(),
            "onSurface" to ButtonDefaults.onSurfaceOutlinedButtonColors(),
            "onError" to ButtonDefaults.onErrorOutlinedButtonColors(),
        )


    private val textButtonColors: List<Pair<String, ButtonColors>>
        @Composable
        get() = listOf(
            "primary" to ButtonDefaults.primaryTextButtonColors(),
            "primaryVariant" to ButtonDefaults.primaryVariantTextButtonColors(),
            "secondary" to ButtonDefaults.secondaryTextButtonColors(),
            "secondaryVariant" to ButtonDefaults.secondaryVariantTextButtonColors(),
            "background" to ButtonDefaults.backgroundTextButtonColors(),
            "surface" to ButtonDefaults.surfaceTextButtonColors(),
            "error" to ButtonDefaults.errorTextButtonColors(),
            "onPrimary" to ButtonDefaults.onPrimaryTextButtonColors(),
            "onSecondary" to ButtonDefaults.onSecondaryTextButtonColors(),
            "onBackground" to ButtonDefaults.onBackgroundTextButtonColors(),
            "onSurface" to ButtonDefaults.onSurfaceTextButtonColors(),
            "onError" to ButtonDefaults.onErrorTextButtonColors(),
        )

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
                    FilledButtons(enabled = enabledStated, colors = buttonColors)
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedButtons(enabled = enabledStated, colors = outlinedButtonColors)
                    Spacer(modifier = Modifier.height(16.dp))
                    TextButtons(enabled = enabledStated, colors = textButtonColors)
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
fun FilledButtons(
    enabled: Boolean,
    colors: List<Pair<String, ButtonColors>>,
) {
    LazyRow {
        items(colors) { (name, colors) ->
            Column(
                modifier = Modifier.width(140.dp)
            ) {
                Text(
                    text = name,
                    color = MaterialTheme.colors.onSurface,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    enabled = enabled,
                    onClick = {},
                    colors = colors,
                ) {
                    Text(text = "Button")
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun OutlinedButtons(
    enabled: Boolean,
    colors: List<Pair<String, ButtonColors>>,
) {
    LazyRow {
        items(colors) { (name, colors) ->
            Column(
                modifier = Modifier.width(140.dp)
            ) {
                Text(
                    text = name,
                    color = MaterialTheme.colors.onSurface,
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    enabled = enabled,
                    onClick = {},
                    colors = colors,
                ) {
                    Text(text = "Button")
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun TextButtons(
    enabled: Boolean,
    colors: List<Pair<String, ButtonColors>>,
) {
    LazyRow {
        items(colors) { (name, colors) ->
            Column(
                modifier = Modifier.width(140.dp)
            ) {
                Text(
                    text = name,
                    color = MaterialTheme.colors.onSurface,
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextButton(
                    modifier = Modifier.fillMaxWidth(),
                    enabled = enabled,
                    onClick = {},
                    colors = colors,
                ) {
                    Text(text = "Button")
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}