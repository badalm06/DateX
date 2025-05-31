package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.IconButtonBox
import com.dating.datexapp.ui.common.StatusBar

@Composable
fun AboutUsScreen(
    onBackClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {

            // Top Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp)
                    .border(1.dp, Color(0xFFD4D4D4))
            ) {
                StatusBar()
                Row(
                    modifier = Modifier
                        .padding(top = 40.dp, start = 25.dp, end = 20.dp)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButtonBox(
                        iconResId = R.drawable.back_arrow,
                        contentDescription = "Back",
                        onClick = { onBackClick() }
                    )
                    Text(
                        text = "About Us",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF333333),
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            // Logo Centered
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(244.dp)
                    .align(Alignment.CenterHorizontally)
            )


            // Footer Text
            Text(
                text = "Copyright 2023–2024 Dream Friend,\nall rights reserved",
                color = Color.Gray,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(225.dp)
                    .height(44.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }

        // Curve background
        Image(
            painter = painterResource(id = R.drawable.curve4),
            contentDescription = null,
            modifier = Modifier
                .size(width = 375.dp, height = 408.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AboutUsScreenPreview() {
    AboutUsScreen(
        onBackClick = {}
    )
}
