package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.*

@Composable
fun InterestScreen(
    onBackClick: () -> Unit,
    onContinueClick: () -> Unit
) {
    val gradientItems = listOf("Reading", "Music", "Painting", "Sports")
    val selectedInterests = remember { mutableStateListOf("Reading", "Music", "Painting", "Sports") }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFEF9F5))
    ) {
        Image(
            painter = painterResource(id = R.drawable.curve8),
            contentDescription = null,
            modifier = Modifier
                .size(width = 395.dp, height = 301.dp)
                .align(Alignment.BottomCenter)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            StatusBar()
            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButtonBox(
                    iconResId = R.drawable.back_arrow,
                    contentDescription = "Back",
                    onClick = onBackClick
                )
                Spacer(modifier = Modifier.width(60.dp))
                ProgressIndicator(
                    totalWidth = 180.dp,
                    progressWidth = 157.5.dp,
                    height = 8.dp
                )
            }

            Spacer(modifier = Modifier.height(48.dp))
            TitleText(
                text = "Select Up To 3 Interest",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Tell us what piques your curiosity and\n passions",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
                color = Color(0xFF6F6F6F),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )

            Box(modifier = Modifier.weight(1f)) {

                val items = listOf(
                    Triple("Reading", R.drawable.reading, Pair(55.dp, 32.dp)),
                    Triple("Photography", R.drawable.photography, Pair(177.dp, 32.dp)),
                    Triple("Gaming", R.drawable.gaming, Pair(23.dp, 85.dp)),
                    Triple("Music", R.drawable.music, Pair(145.dp, 85.dp)),
                    Triple("Travel", R.drawable.travel, Pair(253.dp, 85.dp)),
                    Triple("Painting", R.drawable.painting, Pair(73.dp, 138.dp)),
                    Triple("Politics", R.drawable.politics, Pair(195.dp, 138.dp)),
                    Triple("Charity", R.drawable.charity, Pair(24.dp, 191.dp)),
                    Triple("Cooking", R.drawable.cooking, Pair(140.dp, 191.dp)),
                    Triple("Pets", R.drawable.pets, Pair(263.dp, 191.dp)),
                    Triple("Sports", R.drawable.sports, Pair(77.dp, 244.dp)),
                    Triple("Fashion", R.drawable.fashion, Pair(189.dp, 244.dp))
                )

                items.forEach { (label, icon, offset) ->
                    InterestChip1(
                        text = label,
                        icon = icon,
                        isSelected = selectedInterests.contains(label),
                        isGradient = label in gradientItems,
                        onClick = {
                            if (selectedInterests.contains(label)) {
                                selectedInterests.remove(label)
                            } else if (selectedInterests.size < 3) {
                                selectedInterests.add(label)
                            }
                        },
                        modifier = Modifier
                            .absoluteOffset(x = offset.first, y = offset.second)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))
            GradientButton(
                text = "Continue",
                onClick = onContinueClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .height(56.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun InterestChip1(
    text: String,
    icon: Int,
    isSelected: Boolean,
    isGradient: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val gradient = Brush.verticalGradient(
        listOf(Color(0xFFF64F8B), Color(0xFFF8CE61))
    )

    val chipWidth = when (text) {
        "Photography" -> 143.dp
        "Gaming" -> 112.dp
        "Music" -> 98.dp
        "Travel" -> 99.dp
        "Painting" -> 112.dp
        "Politics" -> 106.dp
        "Charity" -> 106.dp
        "Cooking" -> 113.dp
        "Pets" -> 88.dp
        "Sports" -> 102.dp
        "Fashion" -> 110.dp
        else -> 112.dp // "Reading" or default
    }

    val showGradient = isGradient && isSelected

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .width(chipWidth)
            .height(40.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(
                brush = if (showGradient) gradient else Brush.verticalGradient(listOf(Color.White, Color.White)),
                shape = RoundedCornerShape(50.dp)
            )
            .border(
                width = if (!showGradient) 1.dp else 0.dp,
                color = if (!showGradient) Color(0xCCF64F8B) else Color.Transparent,
                shape = RoundedCornerShape(50.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 12.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = if (showGradient) Color.White else Color(0xFFF64F8B),
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            fontSize = 15.sp,
            color = if (showGradient) Color.White else Color.Black
        )
    }
}




@Preview(showBackground = true)
@Composable
fun InterestScreenPreview() {
    InterestScreen(
        onContinueClick = {},
        onBackClick = {}
    )
}
