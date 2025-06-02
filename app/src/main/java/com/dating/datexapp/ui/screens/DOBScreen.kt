package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.dating.datexapp.ui.common.IconButtonBox
import com.dating.datexapp.ui.common.ProgressIndicator
import com.dating.datexapp.ui.common.StatusBar
import com.dating.datexapp.ui.common.TitleText
import com.dating.datexapp.ui.wheelpicker.FWheelPickerState
import com.dating.datexapp.ui.wheelpicker.FVerticalWheelPicker
import com.dating.datexapp.ui.wheelpicker.rememberFWheelPickerState

@Composable
fun DOBScreen(
    selectedAge: Int,
    onAgeSelected: (Int) -> Unit,
    onBackClick: () -> Unit,
    onContinueClick: () -> Unit
) {
    val ageRange = (18..80).toList()
    val pickerState = rememberFWheelPickerState(
        initialIndex = ageRange.indexOf(selectedAge))

    LaunchedEffect(pickerState.currentIndex) {
        val index = pickerState.currentIndex
        if (index in ageRange.indices) {
            onAgeSelected(ageRange[index])
        }
    }

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
                    .height(394.dp)
                    .fillMaxWidth()
            ) {
                // Pink indicator lines
                val lineColor = Color(0xFFF64F8B)
                val lineThickness = 3.dp
                val itemHeight = 77.dp

                // Top line
                Box(
                    Modifier
                        .align(Alignment.Center)
                        .offset(y = -itemHeight / 2)
                        .width(137.dp)
                        .height(lineThickness)
                        .background(lineColor)
                )

                // Bottom line
                Box(
                    Modifier
                        .align(Alignment.Center)
                        .offset(y = itemHeight / 2)
                        .width(137.dp)
                        .height(lineThickness)
                        .background(lineColor)
                )

                // The age picker
                FVerticalWheelPicker(
                    count = ageRange.size,
                    state = pickerState,
                    modifier = Modifier
                        .fillMaxSize(),
                    itemHeight = itemHeight,
                    unfocusedCount = 3,
                    display = {
                        val isFocused = pickerState.currentIndex == it
                        val textColor = if (isFocused) Color(0xFFF64F8B) else Color(0xFFFF2D55).copy(alpha = 0.3f)
                        val textSize = if (isFocused) 64.sp else 48.sp
                        val fontWeight = if (isFocused) FontWeight.Bold else FontWeight.Normal

                        Text(
                            text = ageRange[it].toString(),
                            textAlign = TextAlign.Center,
                            fontSize = textSize,
                            fontWeight = fontWeight,
                            color = textColor,
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    content = { }
                )
            }
       }

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


@Preview(showBackground = true)
@Composable
fun DOBScreenPreview() {
    DOBScreen(
        selectedAge = 32,
        onAgeSelected = {},
        onBackClick = {},
        onContinueClick = {}
    )
}
