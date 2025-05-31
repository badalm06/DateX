package com.dating.datexapp.ui.screens

import androidx.compose.ui.draw.clip
import com.dating.datexapp.ui.common.IconButtonBox
import com.dating.datexapp.ui.common.StatusBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dating.datexapp.R

@Composable
fun BlockedUsersScreen(
    onBackClick: () -> Unit
) {
    var query by remember { mutableStateOf("") }

    val blockedUsers = listOf(
        User("Robert Fox", R.drawable.blocked_user1),
        User("Devon Lane", R.drawable.blocked_user2)
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {

            // Top bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
                    .border(1.dp, Color(0xFFD4D4D4))
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
                        text = "Blocked Users",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF333333),
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Search Bar
            SearchBar(query = query, onQueryChanged = { query = it })

            Spacer(modifier = Modifier.height(28.dp))

            // User list
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                items(blockedUsers) { user ->
                    BlockedUserItem(user = user)
                    Spacer(modifier = Modifier.height(10.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(10.dp))

                }
            }
        }

        // Background curve
        Image(
            painter = painterResource(id = R.drawable.curve4),
            contentDescription = "Curve Background",
            modifier = Modifier
                .size(width = 375.dp, height = 408.dp)
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
fun BlockedUserItem(user: User) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(54.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = user.imageRes),
            contentDescription = user.name,
            modifier = Modifier
                .size(54.dp)
                .clip(RoundedCornerShape(10.dp))
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = user.name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.weight(1f),
            color = Color(0xFF212121)
        )

        Box(
            modifier = Modifier
                .width(60.dp)
                .height(21.dp)
                .border(
                    width = 1.5.dp,
                    color = Color(0x54949494),
                    shape = RoundedCornerShape(4.dp)
                )
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "UNBLOCK",
                fontSize = 10.sp,
                color = Color(0xFF949494),
                fontWeight = FontWeight.Medium
            )
        }
    }
}



data class User(val name: String, val imageRes: Int)

@Preview(showBackground = true)
@Composable
fun BlockedUsersScreenPreview() {
    BlockedUsersScreen(
        onBackClick = {}
    )
}
