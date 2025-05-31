package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.dating.datexapp.ui.common.StatusBar

@Composable
fun LocationScreen(
    onAllowAccessClick: () -> Unit,
    onEnterManuallyClick: () -> Unit
) {
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
        StatusBar()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(199.dp))

            // Location vector
            Image(
                painter = painterResource(id = R.drawable.location_vector),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 176.dp, height = 126.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Title
            Text(
                text = "Enable Your Location",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Description
            Text(
                text = "Choose your location to start find people\naround you",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
                color = Color(0xFF6F6F6F),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Gradient Button
            GradientButton(
                text = "Allow Location Access",
                onClick = onAllowAccessClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Manual option
            Text(
                text = "Enter Location Manually",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFFF64F8B),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clickable { onEnterManuallyClick() }
                    .padding(top = 16.dp) // optional spacing
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun LocationScreenPreview() {
    LocationScreen(
        onAllowAccessClick = {},
        onEnterManuallyClick = {}
    )
}
