package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
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
fun UpdateEmailAddressScreen(
    email: String,
    onEmailChange: (String) -> Unit,
    onBackClick: () -> Unit,
    onContinueClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFEF9F4))
    ) {
        Image(
            painter = painterResource(id = R.drawable.curve4),
            contentDescription = "Curve Background",
            modifier = Modifier
                .size(width = 385.dp, height = 251.dp)
                .align(Alignment.BottomCenter),)

        Column(
            modifier = Modifier.fillMaxSize()

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
                    progressWidth = 67.5.dp,
                    height = 8.dp
                )
            }

            Spacer(modifier = Modifier.height(48.dp))

            TitleText(
                text = "Email Address",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "We’ll need your email to stay in touch",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
                color = Color(0xFF5F5F5F),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(36.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                RoundedTextField(
                    value = email,
                    onValueChange = onEmailChange,
                    placeholder = "rahulsharma@gmail.com"
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
fun UpdateEmailAddressScreenPreview() {
    var email by remember { mutableStateOf("") }

    UpdateEmailAddressScreen(
        email = email,
        onEmailChange = { email = it },
        onBackClick = {},
        onContinueClick = {}
    )
}


