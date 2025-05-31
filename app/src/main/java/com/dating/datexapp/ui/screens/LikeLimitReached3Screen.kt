package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.GradientButton
import com.dating.datexapp.ui.common.StatusBar

@Composable
fun LikeLimitReached3Screen(
    onChangeFiltersClick: () -> Unit = {},
    onBottomMainClick: () -> Unit,
    onBottomHeartClick: () -> Unit,
    onChatClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {

        // Background Curve
        Image(
            painter = painterResource(id = R.drawable.curve8),
            contentDescription = "Background curve",
            modifier = Modifier
                .size(width = 385.dp, height = 401.dp)
                .align(Alignment.BottomCenter)
        )

        // Status bar
        StatusBar()

        // Center Card
        Box(
            modifier = Modifier
                .offset(y = 145.dp)
                .align(Alignment.TopCenter)
                .size(width = 344.dp, height = 478.dp)
                .clip(RoundedCornerShape(30.dp))
                .border(2.dp, Color(0x80ADAFBB), RoundedCornerShape(30.dp))
                .background(Color.White),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 50.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)
            ) {

                // Double Heart Image
                Image(
                    painter = painterResource(id = R.drawable.double_heart),
                    contentDescription = "Communication",
                    modifier = Modifier.size(128.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Title
                Text(
                    text = "Chat with your date!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.manrope_semi_bold)),
                    color = Color(0xFF161616),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(311.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Subtitle
                Text(
                    text = "Messages will appear here.\nStart swiping to get matches!",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.manrope_regular)),
                    color = Color(0xFF808080),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(278.dp)
                )

                Spacer(modifier = Modifier.height(36.dp))

                // Change Filters Button
                GradientButton(
                    text = "Boost Profile",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    onClick = onChangeFiltersClick
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Start Swiping",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.manrope_regular)),
                    color = Color(0xFF161616),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(311.dp)
                )
            }
        }

        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(121.dp)
                .offset(x = 127.dp, y = 19.dp)
        )

        // Top Left Icon
        Box(
            modifier = Modifier
                .offset(x = 20.dp, y = 49.dp)
                .size(32.dp)
                .clip(CircleShape)
                .background(Color(0xFFFFDBE0)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ca_vector_left),
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        }

        // Top Right Icon
        Box(
            modifier = Modifier
                .offset(x = 339.dp, y = 49.dp)
                .size(32.dp)
                .clip(CircleShape)
                .background(Color(0xFFFFDBE0)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ca_vector_right),
                contentDescription = null,
                modifier = Modifier
                    .width(16.dp)
                    .height(18.dp)
            )
        }

        // Bottom Buttons Frame
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .height(55.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StoryFrame(R.drawable.llr_btm_img, Color.Transparent, true, modifier = Modifier.clickable{onBottomMainClick})
            StoryFrame(R.drawable.ca_btm_img2, Color.Transparent, modifier = Modifier.clickable{onBottomHeartClick})
            StoryFrame(R.drawable.chat_btm_img3, Color.Transparent, modifier = Modifier.clickable{onChatClick})
            StoryFrame(R.drawable.ca_btm_img4, Color.Transparent, modifier = Modifier.clickable{onProfileClick})
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LikeLimitReached3ScreenPreview() {
    LikeLimitReached3Screen(
        onBottomMainClick = {},
        onBottomHeartClick = {},
        onChatClick = {},
        onProfileClick = {}
    )
}
