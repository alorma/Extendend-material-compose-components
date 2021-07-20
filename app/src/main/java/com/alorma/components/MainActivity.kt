package com.alorma.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alorma.components.samples.ButtonColorsSample
import com.alorma.components.samples.CardColorsSample
import com.alorma.components.ui.theme.ExtendedMaterialComposecomponentsTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExtendedMaterialComposecomponentsTheme {
                Scaffold {
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
            }
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
