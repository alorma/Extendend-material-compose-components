package com.alorma.components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.alorma.components.buttons.ActionItem
import com.alorma.components.buttons.Banner
import com.alorma.components.buttons.TopAppBar
import com.alorma.components.ui.theme.ExtendedMaterialComposecomponentsTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExtendedMaterialComposecomponentsTheme {
                var bannerState by remember { mutableStateOf<BannerMessage?>(fakeBanner { }) }
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
                                DemoBanner(it)
                            }
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
    text = "Your internet connection was lost. Check network connection",
    icon = Icons.Default.Wifi,
    firstButton = BannerButton(
        text = "FIX IT",
        onClick = onClick,
    ),
    secondButton = BannerButton(text = "LEARN MORE", onClick = onClick),
)

data class BannerMessage(
    val text: String,
    val icon: ImageVector? = null,
    val firstButton: BannerButton,
    val secondButton: BannerButton? = null,
)

data class BannerButton(
    val text: String,
    val onClick: () -> Unit,
)

@Composable
fun DemoBanner(bannerState: BannerMessage) {
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
        if (bannerState.icon != null) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(color = MaterialTheme.colors.primary)
                        .size(48.dp)
                        .padding(8.dp),
                    imageVector = bannerState.icon,
                    contentDescription = null,
                    tint = MaterialTheme.colors.onPrimary,
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = bannerState.text)
            }
        } else {
            Box(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(top = 8.dp),
            ) {
                Text(text = bannerState.text)
            }
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