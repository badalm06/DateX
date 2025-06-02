package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.StatusBar


@Composable
fun CupidArrowScreen(
    onMainImageClick: () -> Unit,
    onLikeClick: () -> Unit,
    onBottomMainClick: () -> Unit,
    onBottomHeartClick: () -> Unit,
    onChatClick: () -> Unit,
    onProfileClick: () -> Unit,
    onFilterClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFEF9F5))
    ) {
        Image(
            painter = painterResource(id = R.drawable.curve8),
            contentDescription = "Background curve",
            modifier = Modifier
                .size(width = 385.dp, height = 280.dp)
                .align(Alignment.BottomCenter)
        )

        // Bottom Buttons Frame
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .height(55.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StoryFrame(R.drawable.ca_btm_img1, Color.Transparent, true, modifier = Modifier.clickable { onBottomMainClick() })
            StoryFrame(R.drawable.ca_btm_img2, Color.Transparent, modifier = Modifier.clickable { onBottomHeartClick() })
            StoryFrame(R.drawable.ca_btm_img3, Color.Transparent, modifier = Modifier.clickable { onChatClick() })
            StoryFrame(R.drawable.ca_btm_img4, Color.Transparent, modifier = Modifier.clickable { onProfileClick() })
        }

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(121.dp)
                .offset(x = 127.dp)
        )

        // Background Rectangles behind the image (drawn first so they appear behind)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 435.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(width = 319.dp, height = 200.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color(0xCCF64F8B))
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 441.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(width = 303.dp, height = 200.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color(0x7DF64F8B))
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 451.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(width = 287.dp, height = 200.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color(0x33EDAEB7))
            )
        }



// Main image drawn after, so it appears on top
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 236.dp)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(width = 335.dp, height = 390.dp)
                    .clip(RoundedCornerShape(24.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ca_main_image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                        .clickable { onMainImageClick() }

                )
            }
        }



        // Profile Name and Location
        Text(
            text = "Kalvin, 23",
            fontFamily = FontFamily(Font(R.font.manrope_semi_boldddd)),
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp,
            modifier = Modifier.offset(x = 40.dp, y = 549.dp),
            color = Color.White
        )

        Text(
            text = "MALIBU • 20 KMS AWAY",
            fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 12.sp,
            modifier = Modifier.offset(x = 40.dp, y = 591.dp),
            color = Color(0xCCFFFFFF)
        )

        // Like Button
        Box(
            modifier = Modifier
                .offset(x = 147.dp, y = 665.dp)
                .size(80.dp)
                .clip(CircleShape)
                .background(Color(0xFFF64F8B))
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.like),
                contentDescription = null,
                modifier = Modifier.size(41.2.dp)
                    .clickable { onLikeClick() }

            )
        }

        // Dislike Left Button
        Box(
            modifier = Modifier
                .offset(x = 59.dp, y = 671.dp)
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.White)
                .padding(18.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.cross),
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        }

        // Star Button (Middle)
        Box(
            modifier = Modifier
                .offset(x = 255.dp, y = 669.dp)
                .size(60.dp)
                .clip(CircleShape)
                .background(Color(0xFFF8CE61))
                .padding(18.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = null,
                modifier = Modifier.size(38.dp)
            )
        }

        // Top Story Group (Frame 54)
        Row(
            modifier = Modifier
                .offset(x = 25.dp, y = 96.dp)
                .height(115.dp).width(405.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            StoryItem(imageRes = R.drawable.demo_image, name = "Add Story", border = true)
            StoryItem(imageRes = R.drawable.ca_top_img2, name = "Jessica", border = false)
            StoryItem(imageRes = R.drawable.ca_top_img3, name = "Micheal", border = false)
            StoryItem(imageRes = R.drawable.ca_top_img2, name = "Scarlet", border = false)
        }

        // Back Arrow Left
        Box(
            modifier = Modifier
                .offset(x = 20.dp, y = 30.dp)
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

        // Back Arrow Right
        Box(
            modifier = Modifier
                .offset(x = 339.dp, y = 30.dp)
                .size(32.dp)
                .clip(CircleShape)
                .clickable{onFilterClick()}
                .background(Color(0xFFFFDBE0)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ca_vector_right),
                contentDescription = null,
                modifier = Modifier.width(16.dp).height(18.dp)
            )
        }
    }
}

@Composable
fun StoryFrame(
    imageRes: Int,
    backgroundColor: Color,
    hasBorder: Boolean = false,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(width = 94.dp, height = 55.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .then(if (hasBorder) Modifier.border(1.dp, Color.White, RoundedCornerShape(10.dp)) else Modifier),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }
}


@Composable
fun StoryItem(
    imageRes: Int,
    name: String,
    border: Boolean = false
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(width = 90.dp, height = 90.dp)
                .clip(RoundedCornerShape(12.dp))
                .then(
                    if (border) Modifier.border(
                        width = 2.dp,
                        color = Color.Magenta,
                        shape = RoundedCornerShape(12.dp)
                    ) else Modifier
                )
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(name, style = MaterialTheme.typography.bodyMedium)
    }
}


@Preview(showBackground = true)
@Composable
fun CupidArrowScreenPreview() {
    CupidArrowScreen(
        onMainImageClick = {},
        onLikeClick = {},
        onBottomMainClick = {},
        onBottomHeartClick = {},
        onChatClick = {},
        onProfileClick = {},
        onFilterClick = {}
    )
}
