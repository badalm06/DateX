@file:OptIn(ExperimentalFoundationApi::class)

package com.dating.datexapp.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.StatusBar

@Composable
fun ChatsScreen(
    onBottomMainClick: () -> Unit,
    onBottomHeartClick: () -> Unit,
    onChatClick: () -> Unit,
    onProfileClick: () -> Unit,
    onPartiChatClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Scrollable content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 70.dp) // Leave space for bottom bar
        ) {

            // Logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(121.dp)
                    .offset(x = 127.dp, y = 19.dp)
            )

            // Matches Section
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = "Matches",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.height(80.dp)
                ) {
                    MatchItem(
                        imageRes = R.drawable.total_likes,
                        label = "Likes",
                        bgColor = Color(0xFFF64F8B),
                        showBorder = true,
                        contentScale = ContentScale.Crop
                    )

                    MatchItem(
                        imageRes = R.drawable.chat_img4,
                        label = "Matched",
                        bgColor = Color.Transparent,
                        showBorder = true,
                        online = true,
                        contentScale = ContentScale.Crop
                    )

                    // Empty circles
                    repeat(3) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Box(
                                modifier = Modifier
                                    .size(60.dp)
                                    .border(1.dp, Color.Gray, CircleShape)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text("", fontSize = 12.sp) // Placeholder if needed
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Search Bar
            var query by remember { mutableStateOf("") }
            SearchBar(
                query = query,
                onQueryChanged = { query = it }
            )


            Spacer(modifier = Modifier.height(20.dp))

            // Chats
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                ChatItem("Kristin Watson", "You: Hii", "03:16 PM", R.drawable.chat_img1, true, onPartiChatClick)
                ChatItem("Cody Fisher", "Wanna go for a date💞", "11:44 AM", R.drawable.chat_img2, true, onPartiChatClick)
                ChatItem("Jenny Wilson", "Hey What’s up, long time...", "Yesterday", R.drawable.chat_img3, false, onPartiChatClick)
                ChatItem("Brooklyn Simmons", "Typing...", "May 29", R.drawable.chat_img4, true, onPartiChatClick)
                ChatItem("Floyd Miles", "I'll be there in 2 mins", "May 16", R.drawable.chat_img5, true, onPartiChatClick)
                ChatItem("Jane Cooper", "Hii", "April 24", R.drawable.chat_img6, true, onPartiChatClick)

            }
        }

        // Bottom Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .height(55.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StoryFrame(R.drawable.llr_btm_img, Color.Transparent, true, modifier = Modifier.clickable{onBottomMainClick()})
            StoryFrame(R.drawable.ca_btm_img2, Color.Transparent, modifier = Modifier.clickable{onBottomHeartClick()})
            StoryFrame(R.drawable.chat_btm_img3, Color.Transparent, modifier = Modifier.clickable{onChatClick()})
            StoryFrame(R.drawable.ca_btm_img4, Color.Transparent, modifier = Modifier.clickable{onProfileClick()})
        }
    }
}

@Composable
fun SearchBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChanged,
        placeholder = {
            Text(
                text = "Search",
                color = Color.Gray
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.magnifier),
                contentDescription = "Search Icon",
                tint = Color.Black,
                modifier = Modifier.size(20.dp)
            )
        },
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .padding(horizontal = 20.dp)
            .height(50.dp)
            .fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0x1AF64F8B),
            focusedContainerColor = Color(0x1AF64F8B),
            focusedIndicatorColor = Color(0xFFF64F8B),
            unfocusedIndicatorColor = Color(0x4DF64F8B),
            cursorColor = Color(0xFFF64F8B),
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedPlaceholderColor = Color.Gray,
            unfocusedPlaceholderColor = Color.Gray
        ),
        singleLine = true
    )
}

@Composable
fun MatchItem(
    imageRes: Int,
    label: String?,
    bgColor: Color,
    showBorder: Boolean = false,
    online: Boolean = false,
    contentScale: ContentScale
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(60.dp)
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(bgColor, CircleShape)
                .border(
                    width = if (showBorder) 2.dp else 0.dp,
                    color = Color.White,
                    shape = CircleShape
                )
                .padding(3.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape)
            )

            if (online) {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(Color.Green, CircleShape)
                        .align(Alignment.TopEnd)
                        .border(1.dp, Color.White, CircleShape)
                )
            }
        }

        if (!label.isNullOrEmpty()) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = label,
                fontSize = 12.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun ChatItem(name: String, message: String, time: String, imageRes: Int, online: Boolean, onPartiChatClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable{onPartiChatClick()}
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape)
            )
            if (online) {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(Color.Green, CircleShape)
                        .align(Alignment.TopEnd)
                        .border(1.dp, Color.White, CircleShape)
                )
            }
            else {
                Box(
                    modifier = Modifier
                        .size(12.dp)
                        .background(Color.Gray, CircleShape)
                        .align(Alignment.TopEnd)
                        .border(1.dp, Color.White, CircleShape)
                )
            }
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(
                text = message,
                fontSize = 14.sp,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Text(
            text = time,
            fontSize = 12.sp,
            color = Color.Gray
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ChatsScreenPreview() {
    ChatsScreen(
        onBottomMainClick = {},
        onBottomHeartClick = {},
        onChatClick = {},
        onProfileClick = {},
        onPartiChatClick = {}
    )
}
