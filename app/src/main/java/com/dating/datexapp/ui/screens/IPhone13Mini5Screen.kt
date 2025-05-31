package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.GradientButton
import com.dating.datexapp.ui.common.IconButtonBox
import com.dating.datexapp.ui.common.StatusBar

@Composable
fun IPhone13Mini5Screen(
    onButtonClick: () -> Unit,
    onAnyOtherClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x80000000))
            .clickable{onAnyOtherClick()}
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
                    onClick = {},
                )
                Spacer(modifier = Modifier.width(75.dp))
                Text(
                    text = "Choose Your Plan",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                )
            }

            ProfileHeader1()

            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                GradientBorderBox1(
                    width = 162.5.dp,
                    iconId = R.drawable.ps_like_img,
                    title = "Get\nSuper Likes",
                    gradient = Brush.verticalGradient(
                        listOf(Color(0x805558FF), Color(0x8000C0FF))
                    ),
                    backgroundGradient = Brush.verticalGradient(
                        listOf(Color(0x59ADDCFF), Color(0x59EAF6FF))
                    )
                )

                GradientBorderBox1(
                    width = 162.5.dp,
                    iconId = R.drawable.ps_boost_img,
                    title = "Get\nBoosts",
                    gradient = Brush.verticalGradient(
                        listOf(Color(0x80A93AFF), Color(0x80FF81FF))
                    ),
                    backgroundGradient = Brush.verticalGradient(
                        listOf(Color(0x59FFBEF9), Color(0x59FFF1FF), Color(0x59FFF1FF))
                    )
                )
            }


        }

            Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(488.dp)
                .align(Alignment.BottomCenter)
                .background(Color.White, shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 44.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Profile Image
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.im_img),
                        contentDescription = "User Photo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ps_boost_img),
                        contentDescription = "Boost Icon",
                        modifier = Modifier
                            .size(32.dp)
                            .align(Alignment.BottomEnd)
                            .offset(x = 6.dp, y = 6.dp)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Get more matches",
                    color = Color(0xFF161616),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 30.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Extend your Boosts to be seen first\nand get up to 10x more matches.",
                    color = Color(0xFF808080),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    lineHeight = 22.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Gradient Button
                Box(
                    modifier = Modifier
                        .width(325.dp)
                        .height(50.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(
                            brush = Brush.horizontalGradient(
                                listOf(Color(0xFFFF5858), Color(0xFFFF1681))
                            )
                        )
                        .clickable { onButtonClick()}
                        .shadow(elevation = 4.dp, shape = RoundedCornerShape(30.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    GradientButton(
                        text = "Use 2 Boosts for 150 mins",
                        modifier = Modifier
                            .width(337.dp)
                            .height(50.dp),
                        onClick = {onButtonClick()}
                    )

                }

                Spacer(modifier = Modifier.height(16.dp))

                // Outlined Button
                Box(
                    modifier = Modifier
                        .width(302.dp)
                        .height(52.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color(0x1FFF006B))
                        .border(1.dp, Color(0x4DF64F8B), shape = RoundedCornerShape(30.dp))
                        .clickable { onButtonClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Use 1 Boosts for 30 mins",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}


@Composable
fun ProfileHeader1() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(165.dp)
                .padding(top = 35.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(130.dp)
                    .offset(x = 0.dp, y = (-15).dp)
                    .align(Alignment.TopCenter)
                    .clip(CircleShape)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_indicator),
                    contentDescription = null,
                    modifier = Modifier.matchParentSize()
                )

                // Dark circular overlay
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(Color.Black.copy(alpha = 0.2f), shape = CircleShape)
                )
            }



            // Darkened profile image using overlay
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .align(Alignment.TopCenter)
                    .offset(y = 3.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.im_img),
                    contentDescription = null,
                    modifier = Modifier
                        .matchParentSize()
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .background(Color.Black.copy(alpha = 0.2f), shape = CircleShape)
                )
            }

            // Dark gray edit icon bubble
            Box(
                modifier = Modifier
                    .size(35.dp)
                    .offset(x = -22.dp, y = -5.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFBDBDBD))
                    .shadow(1.dp, shape = CircleShape)
                    .align(Alignment.TopEnd)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_edit_profile),
                    contentDescription = null,
                    modifier = Modifier
                        .size(17.dp)
                        .align(Alignment.Center),
                    colorFilter = ColorFilter.tint(Color(0xFF757575)) // darker icon
                )
            }

            // Darkened progress bar
            Box(
                modifier = Modifier
                    .offset(y = -14.dp)
                    .size(width = 165.dp, height = 30.dp)
                    .background(Color(0xFF990046), shape = RoundedCornerShape(1000.dp))
                    .align(Alignment.BottomCenter)
            ) {
                Text(
                    text = "25% COMPLETE",
                    color = Color(0xB3FFFFFF),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        // Crisp name
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
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.width(4.dp))

            Image(
                painter = painterResource(id = R.drawable.ic_not_verified),
                contentDescription = "Not Verified",
                modifier = Modifier.size(16.dp),
                colorFilter = ColorFilter.tint(Color(0xFFBDBDBD))
            )
        }

        Box(
            modifier = Modifier
                .padding(top = 6.dp)
                .offset(y = -14.dp)
                .size(width = 148.dp, height = 24.dp)
                .background(
                    color = Color(0xFFA2446E).copy(alpha = 0.2f), // Adjust alpha to darken
                    shape = RoundedCornerShape(1000.dp)
                )
        ) {
            Text(
                text = "Complete my profile",
                color = Color(0xFF424242),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}



@Composable
fun GradientBorderBox1(
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
                modifier = Modifier
                    .size(44.dp)
                    .graphicsLayer {
                        alpha = 0.5f  // ✅ Soft fade
                    }
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


@Preview(showBackground = true)
@Composable
fun PreviewIPhone13Mini5Screen() {
    IPhone13Mini5Screen(
        onButtonClick = {},
        onAnyOtherClick = {}
    )
}
