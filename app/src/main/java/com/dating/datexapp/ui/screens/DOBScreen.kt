package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.dating.datexapp.ui.common.IconButtonBox
import com.dating.datexapp.ui.common.ProgressIndicator
import com.dating.datexapp.ui.common.StatusBar
import com.dating.datexapp.ui.common.TitleText



@Composable
fun DOBScreen(
    age: Int,
    onAgeChange: (Int) -> Unit,
    onBackClick: () -> Unit,
    onContinueClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFEF9F5))
    ) {
        Image(
            painter = painterResource(id = R.drawable.curve5),
            contentDescription = "Background curve",
            modifier = Modifier
                .size(width = 385.dp, height = 281.dp)
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
                    progressWidth = 90.dp,
                    height = 8.dp
                )

            }

            Spacer(modifier = Modifier.height(48.dp))
            TitleText(
                text = "How Old Are You?",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Please provide your age in years",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
                color = Color(0xFF6F6F6F),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(40.dp))

            Box(
                modifier = Modifier
                    .height(460.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    val agesToShow = (age - 3)..(age + 3)
                    for (i in agesToShow) {
                        when (i) {
                            age - 3, age + 3 -> AgeText(
                                text = "$i",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0x73F64F8B)
                            )

                            age - 2, age + 2 -> AgeText(
                                text = "$i",
                                fontSize = 36.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0x80F64F8B)
                            )

                            age - 1, age + 1 -> AgeText(
                                text = "$i",
                                fontSize = 44.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color(0xBFF64F8B)
                            )

                            age -> {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Box(
                                        modifier = Modifier
                                            .width(137.dp)
                                            .height(3.dp)
                                            .background(Color(0xFFF64F8B))
                                    )
                                    AgeText(
                                        text = "$i",
                                        fontSize = 64.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFF64F8B)
                                    )
                                    Box(
                                        modifier = Modifier
                                            .width(137.dp)
                                            .height(3.dp)
                                            .background(Color(0xFFF64F8B))
                                    )
                                }
                            }
                        }

                    }
                }
            }

            Spacer(modifier = Modifier.height(80.dp)) // Add some space to avoid overlap with button
        }

        // Continue Button at Bottom
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp)
        ) {
            GradientButton(
                text = "Continue",
                onClick = onContinueClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .height(56.dp)
            )
        }
    }
}

@Composable
fun AgeText(
    text: String,
    fontSize: androidx.compose.ui.unit.TextUnit,
    color: Color,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        text = text,
        fontSize = fontSize,
        fontFamily = FontFamily(Font(R.font.manrope_regular)),
        fontWeight = fontWeight,
        color = color,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(vertical = 2.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DOBScreenPreview() {
    DOBScreen(
        age = 32,
        onAgeChange = {},
        onBackClick = {},
        onContinueClick = {}
    )
}