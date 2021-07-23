package com.alorma.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.unit.dp
import com.alorma.components.buttons.ActionItem
import com.alorma.components.buttons.Banner
import com.alorma.components.buttons.TopAppBar
import com.alorma.components.samples.ButtonColorsSample
import com.alorma.components.samples.CardColorsSample
import com.alorma.components.ui.theme.ExtendedMaterialComposecomponentsTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExtendedMaterialComposecomponentsTheme {
                var bannerState by remember { mutableStateOf<BannerMessage?>(null) }
                val bannerVisibleState by derivedStateOf { bannerState != null }
                val scaffoldState = rememberScaffoldState()

                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        DemoAppBar(
                            action = ActionItem(
                                id = 0,
                                content = { Text(text = "Show banner") },
                                icon = Icons.Default.Info,
                                onClick = {
                                    bannerState = fakeBanner {
                                        bannerState = null
                                    }.takeIf { bannerState == null }
                                    true
                                },
                            )
                        )
                    }
                ) {
                    Column {
                        AnimatedVisibility(visible = bannerVisibleState) {
                            bannerState?.let {
                                TwoLineBanner(it)
                            }
                        }
                        LazyColumn {
                            items(10) { num -> ItemCard(num) }
                        }
                    }
                }
            }
        }
    }
}

private fun fakeBanner(
    onClick: () -> Unit,
): BannerMessage = BannerMessage(
    text = "Your internet connection was lost.\nWe can't upload your photo.",
    firstButton = BannerButton(
        text = "LEARN MORE",
        onClick = onClick,
    ),
    secondButton = BannerButton(
        text = "FIX IT",
        onClick = onClick,
    )
)

data class BannerMessage(
    val text: String,
    val firstButton: BannerButton,
    val secondButton: BannerButton? = null,
)

data class BannerButton(
    val text: String,
    val onClick: () -> Unit,
)

@Composable
fun ItemCard(num: Int) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        Column {
            Image(
                painter = ColorPainter(color = MaterialTheme.colors.background.copy(alpha = 0.12f)),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            ) {
                Text(text = "Item #$num")
            }

        }
    }
}

@Composable
fun TwoLineBanner(bannerState: BannerMessage) {
    Banner(
        firstButton = {
            TextButton(
                onClick = bannerState.firstButton.onClick,
            ) {
                Text(text = bannerState.firstButton.text)
            }
        },
        secondButton = bannerState.secondButton?.let {
            @Composable {
                TextButton(
                    onClick = bannerState.secondButton.onClick,
                ) {
                    Text(text = bannerState.secondButton.text)
                }
            }
        },
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(top = 8.dp),
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .background(color = MaterialTheme.colors.primary)
                    .size(48.dp)
                    .padding(8.dp),
                imageVector = Icons.Default.Wifi,
                contentDescription = null,
                tint = MaterialTheme.colors.onPrimary,
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = bannerState.text)
        }
    }
}

@Composable
fun DemoAppBar(
    action: ActionItem,
) {
    TopAppBar(
        title = { Text(text = "Sample") },
        actions = listOf(action),
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
