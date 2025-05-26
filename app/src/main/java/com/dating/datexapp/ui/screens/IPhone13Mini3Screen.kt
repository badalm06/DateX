package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.filled.Videocam
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.dating.datexapp.R

@Composable
fun IPhone13Mini3Screen() {
    val messages = listOf(
        Message("Cody Fisher", "Hello", "10:31 AM", isMine = false),
        Message("Momy Doy", "Hi", "10:38 AM", isMine = true),
        Message("Cody Fisher", "Can you help me.", "10:31 AM", isMine = false),
        Message("Momy Doy", "What kind of help?", "10:38 AM", isMine = true),
        Message("Cody Fisher", "I want a build a website", "10:31 AM", isMine = false),
        Message("Momy Doy", "Great!!", "10:38 AM", isMine = true)
    )

    var input by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFCF9))
    ) {
        TopBar()

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 119.dp)) {

            Text(
                text = "TODAY",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = Color.Gray
            )

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(messages) { message ->
                    MessageBubble(message)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ChatInputBar(
                    input = input,
                    onInputChange = { input = it },
                    onSendClick = { /* Handle send */ }
                )

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    painter = painterResource(R.drawable.ic_emoji),
                    contentDescription = "Emoji",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Black
                )
            }

        }

        Image(
            painter = painterResource(id = R.drawable.curve8),
            contentDescription = "Background curve",
            modifier = Modifier
                .size(width = 385.dp, height = 351.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun TopBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        StatusBarChat()

        Spacer(modifier = Modifier.height(18.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )

            Spacer(modifier = Modifier.width(10.dp))

            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = null,
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.White, CircleShape)
            )

            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
            ) {
                Text(
                    "Cody Fisher",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    "Active now",
                    fontSize = 12.sp,
                    color = Color.LightGray
                )
            }

            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "Call",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.Videocam,
                contentDescription = "Video",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More",
                tint = Color.White
            )
        }
    }
}



@Composable
fun StatusBarChat(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 7.33.dp, start = 18.dp, end = 21.dp)
            .height(21.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(R.drawable.ic_time),
            contentDescription = "Time",
            modifier = Modifier.size(54.dp, 21.dp),
            colorFilter = ColorFilter.tint(Color.White)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_cellular),
                contentDescription = "Cellular",
                modifier = Modifier.size(17.dp, 10.66.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Image(
                painter = painterResource(R.drawable.ic_wifi),
                contentDescription = "WiFi",
                modifier = Modifier.size(15.33.dp, 11.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Image(
                painter = painterResource(R.drawable.ic_battery),
                contentDescription = "Battery",
                modifier = Modifier.size(24.33.dp, 11.33.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
        }
    }
}


@Composable
fun MessageBubble(message: Message) {
    val bgColor = if (message.isMine) Color(0xFFFF4081) else Color(0xFFFFEBEE)
    val txtColor = if (message.isMine) Color.White else Color.Black
    val alignment = if (message.isMine) Arrangement.End else Arrangement.Start
    val textColor = if (!message.isMine) Color.Gray else Color.Black
    val bubbleShape = if (message.isMine) {
        RoundedCornerShape(12.dp, 0.dp, 12.dp, 12.dp)
    } else {
        RoundedCornerShape(0.dp, 12.dp, 12.dp, 12.dp)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp),
        horizontalArrangement = alignment
    ) {
        if (!message.isMine) {
            // Profile Image for received message
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "User Profile",
                modifier = Modifier
                    .size(19.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))
        }

        // Message Bubble
        Column(
            modifier = Modifier
                .background(bgColor, bubbleShape)
                .width(161.dp)
                .padding(horizontal = 12.dp, vertical = 8.dp)
                .defaultMinSize(minWidth = 60.dp)
        ) {
                Text(
                    text = message.sender,
                    fontSize = 8.sp,
                    color = if (message.isMine) Color.Black.copy(alpha = 0.9f) else Color.Gray,
                    modifier = Modifier.padding(bottom = 2.dp)
                )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = message.text,
                    fontSize = 11.sp,
                    color = txtColor
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = message.time,
                    fontSize = 8.sp,
                    color = if (message.isMine) Color.White.copy(alpha = 0.7f) else Color.Gray
                )
            }

        }

        if (message.isMine) {
            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}




@Composable
fun ChatInputBar(
    input: String,
    onInputChange: (String) -> Unit,
    onSendClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .width(315.dp)
            .height(65.dp)
            .padding(start = 10.dp, end = 10.dp)
            .border(
                width = 1.dp,
                color = Color(0x4DF64F8B),
                shape = RoundedCornerShape(14.dp)
            )
            .background(Color(0xFFFEDDEB), RoundedCornerShape(14.dp))
            .padding(horizontal = 10.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_camera),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        TextField(
            value = input,
            onValueChange = onInputChange,
            placeholder = { Text("Write a message...") },
            modifier = Modifier.weight(1f),
            maxLines = 1,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color(0xFFF64F8B),
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedPlaceholderColor = Color.Gray,
                unfocusedPlaceholderColor = Color.Gray
            )
        )

        IconButton(onClick = onSendClick) {
            Icon(
                painter = painterResource(R.drawable.btn_send),
                contentDescription = "Send",
                tint = Color.Unspecified,
                modifier = Modifier.size(width = 24.dp, height = 24.dp)
            )
        }

    }
}


data class Message(
    val sender: String,
    val text: String,
    val time: String,
    val isMine: Boolean
)

@Preview(showBackground = true)
@Composable
fun IPhone13Mini3ScreenPreview() {
    IPhone13Mini3Screen()
}
