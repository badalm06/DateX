@file:OptIn(ExperimentalMaterial3Api::class)

package com.dating.datexapp.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.*
import com.dating.datexapp.ui.navigation.EditProfileScreen
import com.dating.datexapp.ui.navigation.IPhone13Mini5Screen

@Composable
fun Premium2Screen(
    navController: NavController,
    onBackClick: () -> Unit = {},
    onBottomMainClick: () -> Unit,
    onBottomHeartClick: () -> Unit,
    onChatClick: () -> Unit,
    onProfileClick: () -> Unit,
    onFirstDownArrowClick: () -> Unit,
    onSecondDownArrowClick: () -> Unit
    ) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF9F8))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            StatusBar()

            // Header Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp, start = 25.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButtonBox(
                    iconResId = R.drawable.back_arrow,
                    contentDescription = "Back",
                    onClick = { onBackClick() },
                )
                Spacer(modifier = Modifier.width(75.dp))
                Text(
                    text = "Choose Your Plan",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                )
            }

            ProfileHeader(onEditButtonClick = {})

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
                    ),
                    onGetClick = {navController.navigate(IPhone13Mini5Screen)}
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
                    ),
                    onGetClick = {navController.navigate(IPhone13Mini5Screen)}
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
                    .height(180.dp)
                    .clickable { onFirstDownArrowClick() }
            )
            Spacer(modifier = Modifier.height(16.dp))


            ComparisonTable()

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
                    .height(180.dp)
                    .clickable { onSecondDownArrowClick() }
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
            StoryFrame(R.drawable.llr_btm_img, Color.Transparent, true, modifier = Modifier.clickable{onBottomMainClick()})
            StoryFrame(R.drawable.ca_btm_img2, Color.Transparent, modifier = Modifier.clickable{onBottomHeartClick()})
            StoryFrame(R.drawable.chat_btm_img3, Color.Transparent, modifier = Modifier.clickable{onChatClick()})
            StoryFrame(R.drawable.ca_btm_img4, Color.Transparent, modifier = Modifier.clickable{onProfileClick()})
        }
    }
}

@Composable
fun ComparisonTable() {
    val features = listOf(
        "Unlimited likes",
        "See who likes you",
        "1 Super like per day",
        "1 Free boost per week",
        "Incognito mode",
        "Advance filters",
        "Unlimited rewinds",
        "Remove ads"
    )

    val premium = listOf(true, true, true, true, true, true, true, true)
    val plus = listOf(true, false, false, false, false, true, true, true)

    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .background(Color(0xFFFDF9F8))
    ) {
        // Header row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "What you get",
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color(0xFF161616)
            )
            Text(
                text = "Premium",
                modifier = Modifier.weight(0.5f),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color(0xFF161616),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Plus",
                modifier = Modifier.weight(0.5f),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color(0xFF161616),
                textAlign = TextAlign.Center
            )
        }

        // Feature rows
        features.forEachIndexed { index, feature ->
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = feature,
                            fontSize = 13.sp,
                            color = Color(0xFF161616)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_info), // your info icon
                            contentDescription = "Info",
                            tint = Color(0xFFF64F8B),
                            modifier = Modifier.size(14.dp)
                        )
                    }

                    Text(
                        text = if (premium[index]) "✓" else "—",
                        modifier = Modifier.weight(0.5f),
                        color = if (premium[index]) Color(0xFFF64F8B) else Color(0xFFBDBDBD),
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp
                    )
                    Text(
                        text = if (plus[index]) "✓" else "—",
                        modifier = Modifier.weight(0.5f),
                        color = if (plus[index]) Color(0xFFF64F8B) else Color(0xFFBDBDBD),
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp
                    )
                }

                // Dashed Divider
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .padding(vertical = 4.dp)
                ) {
                    val dashWidth = 10.dp.toPx()
                    val gapWidth = 6.dp.toPx()
                    var startX = 0f
                    while (startX < size.width) {
                        drawLine(
                            color = Color.Black,
                            start = Offset(startX, 0f),
                            end = Offset(startX + dashWidth, 0f),
                            strokeWidth = size.height
                        )
                        startX += dashWidth + gapWidth
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Premium2ScreenPreview() {
    val navController = rememberNavController()
    Premium2Screen(
        navController = navController,
        onBottomMainClick = {},
        onBottomHeartClick = {},
        onChatClick = {},
        onProfileClick = {},
        onFirstDownArrowClick = {},
        onSecondDownArrowClick = {}
    )
}
