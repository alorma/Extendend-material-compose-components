package com.alorma.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alorma.components.buttons.Banner
import com.alorma.components.samples.ButtonColorsSample
import com.alorma.components.samples.CardColorsSample
import com.alorma.components.samples.SampleTopAppBar
import com.alorma.components.ui.theme.ExtendedMaterialComposecomponentsTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExtendedMaterialComposecomponentsTheme {
                val scaffoldState = rememberScaffoldState()

                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = { DemoAppBar(scaffoldState) }
                ) {
                    Column {
                        OnLineBanner()
                        Spacer(modifier = Modifier.size(64.dp))
                        TwoLineBanner()
                        Spacer(modifier = Modifier.size(120.dp))
                        TwoLineSingleButtonBanner()
                    }
                }
            }
        }
    }

}


@Composable
fun OnLineBanner() {
    Banner(
        buttons = {
            TextButton(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Button 1")
            }
            TextButton(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Button 2")
            }
        }
    ) {
        Text(text = "Banner content")
    }
}

@Composable
fun TwoLineBanner() {
    Banner(
        buttons = {
            TextButton(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Button 1")
            }
            TextButton(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Button 2")
            }
        }
    ) {
        Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer justo ligula, lacinia vitae massa vel, bibendum porttitor tortor.")
    }
}

@Composable
fun TwoLineSingleButtonBanner() {
    Banner(
        buttons = {
            TextButton(
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Button 1")
            }
        }
    ) {
        Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer justo ligula, lacinia vitae massa vel, bibendum porttitor tortor.")
    }
}

@Composable
fun DemoAppBar(
    scaffoldState: ScaffoldState,
) {
    val coroutineScope = rememberCoroutineScope()
    SampleTopAppBar(
        onActionClick = { action ->
            coroutineScope.launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    message = "Clicked: ${action.contentDescription}"
                )
            }
            true
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Demo() {
    val scrollState = rememberScrollState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .scrollable(
                state = scrollState,
                orientation = Orientation.Vertical,
            ),
    ) {
        stickyHeader {
            Title(text = "Buttons")
        }
        item {
            ButtonColorsSample()
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        stickyHeader {
            Title(text = "Cards")
        }
        item {
            CardColorsSample()
        }
    }
}

@Composable
fun Title(text: String) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        elevation = 2.dp,
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
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
}
