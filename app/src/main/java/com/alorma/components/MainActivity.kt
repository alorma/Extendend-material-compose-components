package com.alorma.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    FilledButtons()
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedButtons()
                    Spacer(modifier = Modifier.height(16.dp))
                    TextButtons()
                }
            }
        }
    }
}

@Composable
fun FilledButtons() {
    Row {
        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            onClick = {},
        ) {
            Text(text = "Primary")
        }
        Spacer(modifier = Modifier.width(8.dp))
        SecondaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            onClick = {},
        ) {
            Text(text = "Secondary")
        }
        Spacer(modifier = Modifier.width(8.dp))
        ErrorButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            onClick = {},
        ) {
            Text(text = "Error")
        }
    }
}

@Composable
fun OutlinedButtons() {
    Row {
        PrimaryOutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            onClick = {},
        ) {
            Text(text = "Primary")
        }
        Spacer(modifier = Modifier.width(8.dp))
        SecondaryOutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            onClick = {},
        ) {
            Text(text = "Secondary")
        }
        Spacer(modifier = Modifier.width(8.dp))
        ErrorOutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            onClick = {},
        ) {
            Text(text = "Error")
        }
    }
}

@Composable
fun TextButtons() {
    Row {
        PrimaryTextButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            onClick = {},
        ) {
            Text(text = "Primary")
        }
        Spacer(modifier = Modifier.width(8.dp))
        SecondaryTextButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            onClick = {},
        ) {
            Text(text = "Secondary")
        }
        Spacer(modifier = Modifier.width(8.dp))
        ErrorTextButton(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            onClick = {},
        ) {
            Text(text = "Error")
        }
    }
}