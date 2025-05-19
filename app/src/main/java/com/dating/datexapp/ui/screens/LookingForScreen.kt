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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.*
import com.dating.datexapp.R
import androidx.compose.ui.tooling.preview.Preview
import com.dating.datexapp.ui.common.*

@Composable
fun LookingForScreen() {
    val options = listOf(
        "A relationship",
        "Somthing casual",
        "I’m not sure yet",
        "Prefer not to say"
    )
    var selectedOption by remember { mutableStateOf(options[1]) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFEF9F5))
    ) {
        Image(
            painter = painterResource(id = R.drawable.curve7),
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
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButtonBox(
                    iconResId = R.drawable.back_arrow,
                    contentDescription = "Back",
                    onClick = { /* Handle back */ }
                )
                Spacer(modifier = Modifier.width(60.dp))
                ProgressIndicator(
                    totalWidth = 180.dp,
                    progressWidth = 135.dp,
                    height = 8.dp
                )
            }

            Spacer(modifier = Modifier.height(48.dp))
            TitleText(
                text = "I Am Looking For...",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Provide us with further insights into your preferences",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
                color = Color(0xFF6F6F6F),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(36.dp))

            options.forEach { option ->
                OptionItem(
                    text = option,
                    isSelected = selectedOption == option,
                    onClick = { selectedOption = option },
                    modifier = Modifier.padding(horizontal = 20.dp) // 👈 Add this
                )
                Spacer(modifier = Modifier.height(16.dp))
            }


            Spacer(modifier = Modifier.weight(1f))

            GradientButton(
                text = "Continue",
                onClick = {  },
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
fun OptionItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFFF64F8B), Color(0xFFF8CE61))
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(28.dp))
            .background(
                if (isSelected) gradient else Brush.verticalGradient(
                    listOf(Color.White, Color.White)
                )
            )
            .border(
                BorderStroke(1.5.dp, Color(0xFFFFB6C1)),
                shape = RoundedCornerShape(28.dp)
            )
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(start = 24.dp),
            color = if (isSelected) Color.White else Color.Black,
            fontSize = 16.sp
        )

        Box(
            modifier = Modifier
                .padding(end = 16.dp)
                .size(24.dp)
                .clip(CircleShape)
                .background(
                    if (isSelected) Color(0xFFF64F8B) else Color.White
                )
                .border(
                    width = if (isSelected) 5.dp else 1.5.dp,
                    color = if (isSelected) Color.White else Color(0xFF999999),
                    shape = CircleShape
                )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun LookingForPreview() {
    LookingForScreen()
}
