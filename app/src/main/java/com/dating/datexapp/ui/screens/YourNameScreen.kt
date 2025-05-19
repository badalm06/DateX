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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.*

@Composable
fun YourNameScreen(
    name: String,
    onNameChange: (String) -> Unit,
    onContinueClick: () -> Unit,
    onBackClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF7EE)) // Set overall background color
    ) {
        // Background Image (curve3)
        Image(
            painter = painterResource(id = R.drawable.curve3),
            contentDescription = "Background curve",
            modifier = Modifier
                .size(width = 385.dp, height = 361.dp)
                .align(Alignment.BottomCenter)
        )

        Column(
            modifier = Modifier.fillMaxSize()
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
                    progressWidth = 45.dp,
                    height = 8.dp
                )

            }

            Spacer(modifier = Modifier.height(48.dp))

            TitleText(
                text = "What’s Your Name?",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Let’s Get to Know Each Other",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
                color = Color(0xFF6F6F6F),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(36.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                RoundedTextField(
                    value = name,
                    onValueChange = onNameChange,
                    placeholder = "Rahul Sharma"
                )
            }

            Spacer(modifier = Modifier.height(36.dp))

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
fun YourNameScreenPreview() {
    YourNameScreen(
        name = "Rahul Shar |",
        onNameChange = {},
        onBackClick = {},
        onContinueClick = {}
    )
}

