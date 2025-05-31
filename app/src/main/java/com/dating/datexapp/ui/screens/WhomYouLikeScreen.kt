package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dating.datexapp.R
import androidx.compose.foundation.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import com.dating.datexapp.ui.common.StatusBar


@Composable
fun WhomYouLikeScreen(
    onBottomMainScreen: () -> Unit,
    onBottomHeartClick: () -> Unit,
    onChatClick: () -> Unit,
    onProfileClick: () -> Unit,
    onWhoLikeYouClick: () -> Unit,
    onLikeClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Column(modifier = Modifier.fillMaxSize()) {
            StatusBar()
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(121.dp)
                    .align(Alignment.CenterHorizontally)
            )
            TopTabs1(onWhoLikeYouClick = onWhoLikeYouClick)
            ProfileGrid()
            Spacer(modifier = Modifier.weight(1f))
            // Remove BottomNavBar from here
        }

        BottomNavBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            onBottomMainScreen = onBottomMainScreen,
            onBottomHeartClick = onBottomHeartClick,
            onChatClick = onChatClick,
            onProfileClick = onProfileClick
        )

    }
}

@Composable
fun TopTabs1(
    onWhoLikeYouClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Who like you",
            color = Color.Gray,
            fontSize = 16.sp,
            modifier = Modifier.clickable { onWhoLikeYouClick() }
            )
        Image(
            painter = painterResource(id = R.drawable.line1),
            contentDescription = "Tab Divider",
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .height(24.dp)
                .width(2.dp)
        )
        Text(
            text = "Whom you like",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
    }
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        color = Color.LightGray,
        thickness = 1.dp
    )
}


@Composable
fun ProfileGrid() {
    val dummyProfiles = List(8) { "Kristin, 24" }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(dummyProfiles.size) {
            ProfileCard(name = dummyProfiles[it], onLikeClick = {})
        }
    }
}

@Composable
fun ProfileCard(name: String, onLikeClick: () -> Unit) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFFDF6F6))
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.fcv_img2), // Add your drawable here
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .height(150.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 8.dp)
                .background(Color(0xFFF64F8B), shape = RoundedCornerShape(50))
                .padding(horizontal = 10.dp, vertical = 4.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Icon(
                imageVector = Icons.Default.Place,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(14.dp)
            )
            Text(
                text = "Riverside, New Mexico",
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 4.dp)
            )
        }

        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(vertical = 4.dp)
                .align(Alignment.CenterHorizontally)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(39.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFF64F8B))
                    .then(Modifier.clickable { onLikeClick() })
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.like),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
            Box(
                modifier = Modifier
                    .size(39.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cross),
                    contentDescription = null,
                    modifier = Modifier.size(15.dp)
                )
            }
        }
    }
}

@Composable
fun BottomNavBar(modifier: Modifier = Modifier,
                 onBottomMainScreen: () -> Unit,
                 onBottomHeartClick: () -> Unit,
                 onChatClick: () -> Unit,
                 onProfileClick: () -> Unit) {
    Row(
        modifier = modifier
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        StoryFrame(R.drawable.llr_btm_img, Color.Transparent, true, modifier = Modifier.clickable{onBottomMainScreen()})
        StoryFrame(R.drawable.llr_heart, Color.Transparent, modifier = Modifier.clickable{onBottomHeartClick()})
        StoryFrame(R.drawable.ca_btm_img3, Color.Transparent, modifier = Modifier.clickable{onChatClick()})
        StoryFrame(R.drawable.ca_btm_img4, Color.Transparent, modifier = Modifier.clickable{onProfileClick()})
    }
}



@Preview(showBackground = true)
@Composable
fun WhomYouLikeScreenPreview() {
    WhomYouLikeScreen(
        onBottomMainScreen = {},
        onBottomHeartClick = {},
        onChatClick = {},
        onProfileClick = {},
        onWhoLikeYouClick = {},
        onLikeClick = {}
    )
}
