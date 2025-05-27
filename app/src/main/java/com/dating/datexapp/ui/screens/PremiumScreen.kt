@file:OptIn(ExperimentalMaterial3Api::class)

package com.dating.datexapp.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import com.dating.datexapp.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.dating.datexapp.ui.common.IconButtonBox
import com.dating.datexapp.ui.common.ProgressIndicator
import com.dating.datexapp.ui.common.StatusBar


@Composable
fun PremiumScreen(onBackClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF9F8))
    ) {
        StatusBar()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            // Header Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp, start = 25.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButtonBox(
                    iconResId = R.drawable.back_arrow,
                    contentDescription = "Back",
                    onClick = onBackClick,
                )
                Spacer(modifier = Modifier.width(75.dp))
                Text(
                    text = "Choose Your Plan",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                )
            }

            ProfileHeader()

            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                GradientBorderBox(
                    width = 162.5.dp,
                    iconId = R.drawable.ps_like_img,
                    title = "Get\nSuper Likes",
                    gradient = Brush.verticalGradient(
                        listOf(Color(0xFF5558FF), Color(0xFF00C0FF))
                    ),
                    backgroundGradient = Brush.verticalGradient(
                        listOf(Color(0xFFADDCFF), Color(0xFFEAF6FF))
                    )
                )

                GradientBorderBox(
                    width = 162.5.dp,
                    iconId = R.drawable.ps_boost_img,
                    title = "Get\nBoosts",
                    gradient = Brush.verticalGradient(
                        listOf(Color(0xFFA93AFF), Color(0xFFFF81FF))
                    ),
                    backgroundGradient = Brush.verticalGradient(
                        listOf(Color(0xFFFFBEF9), Color(0xFFFFF1FF), Color(0xFFFFF1FF))
                    )
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            // Expanded Plan Card
            PlanCard(
                title = "Dream Friend Plus",
                description = "Get more chances to match and\n" +
                        "boost your profile with extra benefits.",
                price = "Upgrade from 99.99 INR",
                backgroundColor = Color(0xFFF94892),
                iconId = R.drawable.down_arrow,
                isDarkText = true,
                modifier = Modifier
                    .width(360.dp)
                    .height(160.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))


            PlanCard(
                title = "Dream Friend Premium",
                description = "Unlock all possibilities and enjoy a better\n" +
                        "dating experience like never before.",
                price = "Upgrade from 199.99 INR",
                backgroundColor = Color(0xFF00BFFF),
                iconId = R.drawable.down_arrow,
                isDarkText = false,
                modifier = Modifier
                    .width(360.dp)
                    .height(160.dp)
            )

            Spacer(modifier = Modifier.height(70.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .height(55.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StoryFrame(R.drawable.ca_btm_img1, Color.Transparent, true)
            StoryFrame(R.drawable.ca_btm_img2, Color.Transparent)
            StoryFrame(R.drawable.ca_btm_img3, Color.Transparent)
            StoryFrame(R.drawable.ca_btm_img4, Color.Transparent)
        }
    }
}


@Composable
fun ProfileHeader() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(modifier = Modifier.size(165.dp).padding(top = 35.dp)) {
            Image(
                painter = painterResource(id = R.drawable.profile_indicator),
                contentDescription = null,
                modifier = Modifier
                    .size(130.dp)
                    .offset(x = 0.dp, y = (-15).dp)
                    .align(Alignment.TopCenter)
            )

            Image(
                painter = painterResource(id = R.drawable.im_img),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.White, CircleShape)
                    .align(Alignment.TopCenter)
                    .offset(y = 3.dp),
                contentScale = ContentScale.Crop
            )


            Box(
                modifier = Modifier
                    .size(35.dp)
                    .offset(x = -22.dp, y = -5.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .shadow(1.dp, shape = CircleShape)
                    .align(Alignment.TopEnd)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_edit_profile),
                    contentDescription = null,
                    modifier = Modifier
                        .size(17.dp)
                        .align(Alignment.Center)
                )
            }

            Box(
                modifier = Modifier
                    .offset(y = -14.dp)
                    .size(width = 165.dp, height = 30.dp)
                    .background(Color(0xFFF64F8B), shape = RoundedCornerShape(1000.dp))
                    .align(Alignment.BottomCenter)
            ) {
                Text(
                    text = "25% COMPLETE",
                    color = Color.White,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(top = 8.dp)
                .offset(y = (-14).dp)
        ) {
            Text(
                text = "Lucifer, 23",
                color = Color(0xFF161616),
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            )

            Spacer(modifier = Modifier.width(4.dp)) // Optional space between text and icon

            Image(
                painter = painterResource(id = R.drawable.ic_not_verified),
                contentDescription = "Not Verified",
                modifier = Modifier.size(16.dp) // Adjust size as needed
            )
        }

        Box(
            modifier = Modifier
                .padding(top = 6.dp)
                .offset(y = -14.dp)
                .size(width = 148.dp, height = 24.dp)
                .background(Color(0x1AF64F8B), shape = RoundedCornerShape(1000.dp))
        ) {
            Text(
                text = "Complete my profile",
                color = Color(0xFF808080),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}


@Composable
fun GradientBorderBox(
    width: Dp,
    iconId: Int,
    title: String,
    gradient: Brush,
    backgroundGradient: Brush
) {
    Box(
        modifier = Modifier
            .size(width = width, height = 72.dp)
            .border(1.dp, brush = gradient, shape = RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(brush = backgroundGradient)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = iconId),
                contentDescription = null,
                modifier = Modifier.size(44.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        }
    }
}


@Composable
fun PlanCard(
    title: String,
    description: String,
    price: String,
    backgroundColor: Color,
    iconId: Int,
    isDarkText: Boolean,
    modifier: Modifier = Modifier
) {
    val textColor = if (isDarkText) Color.Black else Color.White

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(backgroundColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    color = textColor,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = description,
                    color = textColor,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .height(42.dp)
                        .width(232.dp)
                        .offset(x = 4.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = price,
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center

                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Image(
                painter = painterResource(id = iconId),
                contentDescription = "Arrow",
                modifier = Modifier
                    .size(20.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PremiumScreenPreview() {
    PremiumScreen()
}
