package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.*

@Composable
fun GenderScreen(
    selectedGender: String,
    onGenderSelected: (String) -> Unit,
    onBackClick: () -> Unit,
    onContinueClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFEF9F5))
    ) {
        Image(
            painter = painterResource(id = R.drawable.curve6),
            contentDescription = "Background curve",
            modifier = Modifier
                .size(width = 395.dp, height = 301.dp)
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
                    progressWidth = 112.5.dp,
                    height = 8.dp
                )
            }

            Spacer(modifier = Modifier.height(48.dp))
            TitleText(
                text = "What’s Your Gender?",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Tell us about your gender",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
                color = Color(0xFF6F6F6F),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(65.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(48.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                GenderOption(
                    iconResId = R.drawable.male_vector,
                    text = "Male",
                    isSelected = selectedGender == "Male",
                    onClick = { onGenderSelected("Male") }
                )
                GenderOption(
                    iconResId = R.drawable.female_vector,
                    text = "Female",
                    isSelected = selectedGender == "Female",
                    onClick = { onGenderSelected("Female") }
                )
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
fun GenderOption(
    iconResId: Int,
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val size = 150.dp
    val gradient = Brush.verticalGradient(
        listOf(Color(0xFFF64F8B), Color(0xFFF8CE61))
    )

    val modifier = Modifier
        .size(size)
        .clickable { onClick() }
        .then(
            if (isSelected) {
                Modifier.background(brush = gradient, shape = CircleShape)
            } else {
                Modifier
                    .background(color = Color.White, shape = CircleShape)
                    .border(1.dp, Color(0x80F64F8B), shape = CircleShape)
            }
        )
        .padding(24.dp)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = text,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.manrope_semi_bold)),
            color = if (isSelected) Color.White else Color.Black,
            textAlign = TextAlign.Center
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GenderScreenPreview() {
    GenderScreen(
        selectedGender = "Male",
        onGenderSelected = {},
        onBackClick = {},
        onContinueClick = {}
    )
}
