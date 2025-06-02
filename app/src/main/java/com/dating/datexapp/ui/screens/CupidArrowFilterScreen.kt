package com.dating.datexapp.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.GradientButton
import com.dating.datexapp.ui.common.StatusBar


@Composable
fun CupidArrowFilterScreen(
    onCloseClick: () -> Unit,
    onTryAgainClick: () -> Unit,
    onAdvanceFilterClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x80000000),
            )
    ) {


        // Top Row: Stories
        Row(
            modifier = Modifier
                .offset(x = 25.dp, y = 115.dp)
                .height(115.dp)
                .width(405.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            StoryItem1(imageRes = R.drawable.demo_image, name = "Add Story", border = true)
            StoryItem1(imageRes = R.drawable.ca_top_img2, name = "Jessica", border = false)
            StoryItem1(imageRes = R.drawable.ca_top_img3, name = "Micheal", border = false)
            StoryItem1(imageRes = R.drawable.ca_top_img2, name = "Scarlet", border = false)
        }

        // Logo & Title
        Image(
            painter = painterResource(id = R.drawable.logo2),
            contentDescription = "Logo",
            modifier = Modifier
                .size(width = 41.4.dp, height = 38.dp)
                .offset(x = 127.dp, y = 39.dp),
            colorFilter = ColorFilter.tint(Color(0xFF802544))


        )
        Text(
            text = "Dream Friend",
            modifier = Modifier
                .offset(x = 162.dp, y = 68.dp),
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF161616)
        )

        // Main Filter Card
        Box(
            modifier = Modifier
                .offset(y = 160.dp)
                .fillMaxWidth()
                .height(652.dp)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.curve8),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 395.dp, height = 255.dp)
                    .align(Alignment.BottomCenter)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Filters",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF161616)
                )

                Spacer(modifier = Modifier.height(25.dp))
                Text("Short By", color = Color(0xFF161616), fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(12.dp))

                Box(
                    modifier = Modifier
                        .border(1.dp, Color(0xFF808080), RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(9.dp))
                ) {
                    Row(
                        Modifier
                            .height(55.dp)
                            .border(1.dp, Color(0xFF808080), RoundedCornerShape(8.dp))
                            .clip(RoundedCornerShape(8.dp)),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        SelectionChip("Online", true, Modifier.weight(1f), Color.White)
                        Image(painterResource(R.drawable.line4), contentDescription = null)
                        SelectionChip("Popular", false, Modifier.weight(1f), Color.Gray)
                        Image(painterResource(R.drawable.line4), contentDescription = null, Modifier.size(24.dp))
                        SelectionChip("Highly Match", false, Modifier.weight(1f), Color.Gray)
                    }

                }
                
                Spacer(modifier = Modifier.height(30.dp))

                Text("Interested in", color = Color(0xFF161616), fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    Modifier
                        .height(55.dp)
                        .border(1.dp, Color(0xFF808080), RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    InterestChip("Man", true, Modifier.weight(1f), Color.White, R.drawable.man)
                    Image(painterResource(R.drawable.line4), contentDescription = null, modifier = Modifier.height(24.dp))
                    InterestChip("Woman", false, Modifier.weight(1f), Color.Gray, R.drawable.woman)
                    Image(painterResource(R.drawable.line4), contentDescription = null, Modifier.size(24.dp))
                    InterestChip("Other", false, Modifier.weight(1f), Color.Gray, R.drawable.other)
                }



                Spacer(modifier = Modifier.height(30.dp))
                FilterSection("Age range", "20 - 28")
                FilterSlider(
                    activeWidth = 75.5.dp,
                    startThumbOffsetX = 40.dp,
                    endThumbOffsetX = 115.5.dp
                )

                Spacer(modifier = Modifier.height(30.dp))
                FilterSection("Distance (km)", "40 km")
                FilterSlider(
                    activeWidth = 150.dp,
                    startThumbOffsetX = 0.dp,
                    endThumbOffsetX = 150.dp
                )


                Spacer(modifier = Modifier.height(30.dp))

                Row(modifier = Modifier.fillMaxWidth().clickable{onAdvanceFilterClick()}, horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Advance Filters", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color(0xFF161616))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_next),
                        contentDescription = null,
                        tint = Color(0xFF949494),
                        modifier = Modifier.size(12.dp)
                    )

                }

                Spacer(modifier = Modifier.height(30.dp))

                Spacer(modifier = Modifier.weight(1f))
                GradientButton(
                    text = "Try Again",
                    onClick = onTryAgainClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                        .height(56.dp)
                )

                Spacer(modifier = Modifier.height(40.dp))
            }
        }

        // Close Button
        Box(
            modifier = Modifier
                .offset(x = 311.dp, y = 169.dp)
                .size(42.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color(0x14F64F8B))
                .border(1.dp, Color(0x26F64F8B), RoundedCornerShape(24.dp))
                .clickable{onCloseClick()},
            contentAlignment = Alignment.Center
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_close), contentDescription = null, tint = Color(0xFF161616), modifier = Modifier.size(12.dp))
        }

        // Arrows
        ArrowButton(offsetX = 20.dp, imageRes = R.drawable.ca_vector_left, tint = Color(0xFF802544))
        ArrowButton(offsetX = 323.dp, imageRes = R.drawable.ca_vector_right, tint = Color(0xFF802544))

    }
}

@Composable
fun ArrowButton(
    offsetX: Dp,
    imageRes: Int,
    tint: Color = Color.Magenta // default tint
) {
    Box(
        modifier = Modifier
            .offset(x = offsetX, y = 49.dp)
            .size(32.dp)
            .clip(CircleShape)
            .background(Color(0x40C02080)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier.size(16.dp),
            colorFilter = ColorFilter.tint(tint)

        )
    }
}


@Composable
fun InterestChip(
    text: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    textColor: Color,
    iconResId: Int
) {
    val bg = if (isSelected) Brush.verticalGradient(
        listOf(Color(0xFFF64F8B), Color(0xFFF8CE61))
    ) else SolidColor(Color.White)

    Box(
        modifier = modifier
            .fillMaxHeight()
            .clip(RoundedCornerShape(
                topStart = if (text == "Man") 10.dp else 0.dp,
                topEnd = if (text == "Other") 10.dp else 0.dp,
                bottomStart = if (text == "Man") 10.dp else 0.dp,
                bottomEnd = if (text == "Other") 10.dp else 0.dp,
            ))
            .background(bg),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            Image(painterResource(id = iconResId), contentDescription = text, modifier = Modifier.size(20.dp))
            Text(text = text, color = textColor, fontWeight = FontWeight.Medium)
        }
    }
}


@Composable
fun SelectionChip(text: String, isSelected: Boolean, modifier: Modifier = Modifier, textColor: Color) {
    val bg = if (isSelected)
        Brush.verticalGradient(listOf(Color(0xFFF64F8B), Color(0xFFF8CE61)))
    else SolidColor(Color.White)

    Box(
        modifier = modifier
            .fillMaxHeight()
            .clip(RoundedCornerShape(
                topStart = if (text == "Online") 10.dp else 0.dp,
                topEnd = if (text == "last") 10.dp else 0.dp,
                bottomStart = if (text == "Online") 10.dp else 0.dp,
                bottomEnd = if (text == "last") 10.dp else 0.dp,
            ))
            .background(bg),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun FilterSection(
    title: String,
    value: String,
    icon: Painter? = null,
    startPadding: Dp = 0.dp // Optional start padding
) {
    Column(modifier = Modifier.padding(start = startPadding)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                icon?.let {
                    Image(
                        painter = it,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF161616)
                )
            }

            Text(
                text = value,
                fontSize = 14.sp,
                color = Color(0xFF808080)
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
    }
}



@Composable
fun FilterSlider(
    activeWidth: Dp,
    startThumbOffsetX: Dp,
    endThumbOffsetX: Dp,
    startPadding: Dp = 0.dp
) {
    Box(
        modifier = Modifier
            .width(335.dp)
            .height(24.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        // Full track
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .align(Alignment.CenterStart)
                .background(Color(0x1AF64F8B), shape = RoundedCornerShape(1000.dp))
        )

        // Active track between thumbs
        Box(
            modifier = Modifier
                .offset(x = startThumbOffsetX)
                .width(endThumbOffsetX - startThumbOffsetX)
                .height(2.dp)
                .background(Color(0xFFF64F8B), shape = RoundedCornerShape(1000.dp))
        )

        // Start Thumb
        Box(
            modifier = Modifier
                .offset(x = startThumbOffsetX)
                .size(24.dp)
                .background(Color.White, shape = CircleShape)
                .border(1.5.dp, Color(0xFFF64F8B), shape = CircleShape)
        )

        // End Thumb
        Box(
            modifier = Modifier
                .offset(x = endThumbOffsetX)
                .size(24.dp)
                .background(Color.White, shape = CircleShape)
                .border(1.5.dp, Color(0xFFF64F8B), shape = CircleShape)
        )
    }
}


@Composable
fun StoryItem1(
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
                        color = Color(0xFF802544),
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

            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(Color(0x80000000)) // This is #00000080
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(name, style = MaterialTheme.typography.bodyMedium, color = Color.White)
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF5F5F5, widthDp = 375, heightDp = 812)
@Composable
fun CupitArrowFilerScreenPreview() {
    CupidArrowFilterScreen(
        onCloseClick = {},
        onTryAgainClick = {},
        onAdvanceFilterClick = {}
    )
}
