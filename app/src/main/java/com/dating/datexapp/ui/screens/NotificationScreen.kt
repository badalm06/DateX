package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.IconButtonBox
import com.dating.datexapp.ui.common.StatusBar

@Composable
fun NotificationScreen(
    onBackClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top AppBar-like box with border-bottom
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFD4D4D4),
                        shape = RectangleShape
                    )
            ) {
                StatusBar()
                Row(
                    modifier = Modifier
                        .padding(top = 40.dp, start = 25.dp, end = 20.dp)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButtonBox(
                        iconResId = R.drawable.back_arrow,
                        contentDescription = "Back",
                        onClick = { onBackClick() }
                    )
                    Text(
                        text = "Notification",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF333333),
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            var isItem1Enabled by remember { mutableStateOf(true) }  // ON
            var isItem2Enabled by remember { mutableStateOf(true) }  // ON
            var isItem3Enabled by remember { mutableStateOf(false) } // OFF
            var isItem4Enabled by remember { mutableStateOf(false) } // OFF
            var isItem5Enabled by remember { mutableStateOf(false) } // OFF

            NotificationItem(
                title = "New Messages",
                subtitle = "Get updates about new messages",
                isEnabled = isItem1Enabled,
                onToggleChange = { isItem1Enabled = it }
            )
            HorizontalLine()

            NotificationItem(
                title = "Matches",
                subtitle = "Get updates about new matches",
                isEnabled = isItem2Enabled,
                onToggleChange = { isItem2Enabled = it }
            )
            HorizontalLine()

            NotificationItem(
                title = "Liked You",
                subtitle = "Get updates about people who like you",
                isEnabled = isItem3Enabled,
                onToggleChange = { isItem3Enabled = it }
            )
            HorizontalLine()

            NotificationItem(
                title = "Profile Visitors",
                subtitle = "Get updates about people who visit your profile",
                isEnabled = isItem4Enabled,
                onToggleChange = { isItem4Enabled = it }
            )
            HorizontalLine()

            NotificationItem(
                title = "Other Notifications",
                subtitle = "Get updates about every new messages",
                isEnabled = isItem5Enabled,
                onToggleChange = { isItem5Enabled = it }
            )
            HorizontalLine()
        }

        // Background curve image at the bottom
        Image(
            painter = painterResource(id = R.drawable.curve4),
            contentDescription = "Curve Background",
            modifier = Modifier
                .size(width = 375.dp, height = 408.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun CustomSwitch(
    isEnabled: Boolean,
    onToggleChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Switch(
        checked = isEnabled,
        onCheckedChange = { onToggleChange(it) },
        modifier = modifier.scale(0.8f),
        enabled = enabled,
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.White,
            checkedTrackColor = Color(0xFFF64F8B),
            uncheckedThumbColor = Color.White,
            uncheckedTrackColor = Color.LightGray
        )
    )
}


@Composable
fun NotificationItem(
    title: String,
    subtitle: String,
    isEnabled: Boolean,
    onToggleChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        ) {
            Text(
                text = title,
                color = Color(0xFF212121),
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = subtitle,
                color = Color(0xFF9E9E9E),
                fontSize = 14.sp
            )
        }

        CustomSwitch(
            isEnabled = isEnabled,
            onToggleChange = onToggleChange
        )

    }
}

@Composable
fun HorizontalLine() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(1.dp)
            .background(Color(0xFFD4D4D4))
    )
}


@Preview(showBackground = true)
@Composable
fun NotificationScreenPreview() {
    NotificationScreen(
        onBackClick = {}
    )
}
