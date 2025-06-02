package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun ItsMatchScreen(
    onHelloClick: () -> Unit,
    onNotNowClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        // Bottom Curve Background
        Image(
            painter = painterResource(id = R.drawable.curve8),
            contentDescription = "Background curve",
            modifier = Modifier
                .size(width = 385.dp, height = 261.dp)
                .align(Alignment.BottomCenter)
        )
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Congratulations",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .absoluteOffset(y = 100.dp)

            )
        }


        // Three-layered Hearts
        Image(
            painter = painterResource(id = R.drawable.im_heart3),
            contentDescription = null,
            modifier = Modifier
                .absoluteOffset(x = 10.dp, y = 144.dp)
                .size(width = 356.dp, height = 316.84.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.im_heart2),
            contentDescription = null,
            modifier = Modifier
                .absoluteOffset(x = 62.dp, y = 218.dp)
                .size(width = 255.dp, height = 226.95.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.im_heart1),
            contentDescription = null,
            modifier = Modifier
                .absoluteOffset(x = 95.dp, y = 266.dp)
                .size(width = 185.dp, height = 164.65.dp)
        )

        // Profile Images
        Image(
            painter = painterResource(id = R.drawable.aiv_img1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .absoluteOffset(x = 35.dp, y = 314.dp)
                .size(166.82.dp)
                .clip(CircleShape)
        )
        Image(
            painter = painterResource(id = R.drawable.im_img),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .absoluteOffset(x = 173.84.dp, y = 319.18.dp)
                .size(166.82.dp)
                .clip(CircleShape)
        )

        // "It’s a Match" Label
        Box(
            modifier = Modifier
                .absoluteOffset(x = 124.33.dp, y = 445.31.dp)
                .size(width = 130.23.dp, height = 38.26.dp)
                .background(Color.White, RoundedCornerShape(22.07.dp))
                .border(
                    width = 2.dp,
                    color = Color(0xFF00C566),
                    shape = RoundedCornerShape(22.07.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "It’s a Match",
                color = Color(0xFF00C566),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        // Name and Description
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 510.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Kalvin",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Let’s ask her about something interesting\nor you can just start with “Hello”",
                color = Color.Gray,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            )
        }

        // Gradient Button
        GradientButton(
            text = "Say Hello 👋",
            onClick = { onHelloClick() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .height(56.dp)
                .offset(y = 622.dp)
        )

        // "Not Now" Text
        Text(
            text = "Not Now, I’ll Talk Later",
            fontSize = 14.sp,
            color = Color(0xFF161616),
            modifier = Modifier
                .absoluteOffset(x = 112.dp, y = 693.dp)
                .clickable { onNotNowClick() }
                .width(145.dp),
            textAlign = TextAlign.Center,
            letterSpacing = 0.3.sp,
            lineHeight = 20.sp,
            fontFamily = FontFamily(Font(R.font.manrope_regular))
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ItsMatchScreenPreview() {
    ItsMatchScreen(
        onHelloClick = {},
        onNotNowClick = {}
    )
}
