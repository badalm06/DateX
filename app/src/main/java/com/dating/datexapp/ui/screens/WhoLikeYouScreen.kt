package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.GradientButton
import com.dating.datexapp.ui.common.StatusBar

@Composable
fun WhoLikeYouScreen(
    onGetPremiumClick: () -> Unit,
    onBottomMainScreen: () -> Unit,
    onBottomHeartClick: () -> Unit,
    onChatClick: () -> Unit,
    onProfileClick: () -> Unit,
    onWhomYouLikeClick:() -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF8F8F8))
        ) {
            StatusBar()

            // Logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(121.dp)
                    .align(Alignment.CenterHorizontally)
            )

            // Tabs with line between
            TopTabs(onWhomYouLikeClick = onWhomYouLikeClick)

            Spacer(modifier = Modifier.height(12.dp))

            // Scrollable content starts here
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                // Button as first item
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .height(56.dp)
                    ) {
                        GradientButton(
                            text = "Get Premium",
                            onClick = onGetPremiumClick,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .align(Alignment.Center)
                        )
                    }
                }
                // Small gap after button
                item {
                    Spacer(modifier = Modifier.height(10.dp))
                }
                // Your images rows
                items(3) { groupIndex ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.CenterHorizontally),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        BlurredProfileImageWithBorder(
                            imageRes = R.drawable.aiv_img1,
                            width = 161.dp,
                            height = 213.dp
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        BlurredProfileImageWithBorder(
                            imageRes = R.drawable.im_img,
                            width = 161.dp,
                            height = 213.dp
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }

        // Bottom Navigation Bar (unchanged)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .height(55.dp)
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StoryFrame(R.drawable.llr_btm_img, Color.Transparent, true, modifier = Modifier.clickable{onBottomMainScreen()})
            StoryFrame(R.drawable.llr_heart, Color.Transparent, modifier = Modifier.clickable{onBottomHeartClick()})
            StoryFrame(R.drawable.ca_btm_img3, Color.Transparent, modifier = Modifier.clickable{onChatClick()})
            StoryFrame(R.drawable.ca_btm_img4, Color.Transparent, modifier = Modifier.clickable{onProfileClick()})
        }
    }
}


@Composable
fun TextTab(text: String, isSelected: Boolean) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyLarge.copy(
            color = if (isSelected) Color.Black else Color(0xFFB0B0B0)
        )
    )
}

@Composable
fun BlurredProfileImageWithBorder(
    imageRes: Int,
    width: Dp,
    height: Dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .size(width = 161.dp, height = 213.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .matchParentSize()
                .graphicsLayer {
                    renderEffect = BlurEffect(8f, 8f)
                }
        )
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .border(
                    width = 0.81.dp,
                    color = Color(0xFFF64F8B),
                    shape = RoundedCornerShape(8.dp)
                )
                .background(Color.Transparent)
                .padding(horizontal = 12.dp, vertical = 6.dp)
        ) {
            Text(
                text = "Upgrade to view",
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}


@Composable
fun BottomNavIcon(imageRes: Int) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = null,
        modifier = Modifier.size(32.dp)
    )
}

@Composable
fun TopTabs(
    onWhomYouLikeClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Who like you",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
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
            color = Color.Gray,
            fontSize = 16.sp,
            modifier = Modifier
                .clickable{onWhomYouLikeClick()}

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

@Preview(showBackground = true)
@Composable
fun WhoLikeYouScreenPreview() {
    WhoLikeYouScreen(
        onGetPremiumClick = {  },
        onBottomMainScreen = {},
        onBottomHeartClick = {},
        onChatClick = {},
        onProfileClick = {},
        onWhomYouLikeClick = {}
    )
}
