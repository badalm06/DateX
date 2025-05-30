package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.compose.ui.tooling.preview.Preview
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.GradientButton
import com.dating.datexapp.ui.common.IconButtonBox
import com.dating.datexapp.ui.common.StatusBar

@Composable
fun LocationSettingsScreen(onContinueClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFCF8))
    ) {
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
                        onClick = { }
                    )
                    Text(
                        text = "Location Settings",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF333333),
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Search Bar
            var query by remember { mutableStateOf("") }
            SearchBar(
                query = query,
                onQueryChanged = { query = it }
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Use current location
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(35.dp))
                    .background(Color(0x1A808080))
                    .border(1.5.dp, Color(0x54949494), RoundedCornerShape(35.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Use my current location",
                    color = Color(0xFF333333),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 20.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.location_icon),
                    contentDescription = "Location Icon",
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(20.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Saved Locations List
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .width(335.dp)
                    .height(350.dp)
            ) {
                LocationItem(
                    title = "Washington Ave",
                    address = "4517 Washington Ave. Manchester, California 62639"
                )
                Divider()
                LocationItem(
                    title = "Thornridge Cir. Syracuse",
                    address = "2118 Thornridge Cir. Syracuse, Connecticut 35624"
                )
                Divider()
                LocationItem(
                    title = "Allentown",
                    address = "4140 Parker Rd. Allentown, New Mexico 31134"
                )
                Divider()
            }

            Spacer(modifier = Modifier.weight(1f))

            // Gradient Button
            GradientButton(
                text = "Set Location",
                onClick = onContinueClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .height(56.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))
        }

        // Background Curve
        Image(
            painter = painterResource(id = R.drawable.curve4),
            contentDescription = "Curve Background",
            modifier = Modifier
                .size(width = 375.dp, height = 408.dp)
                .align(Alignment.BottomCenter)
        )
    }
}



@Composable
fun LocationItem(title: String, address: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        Row(verticalAlignment = Alignment.Top) {
            Icon(
                painter = painterResource(id = R.drawable.location),
                contentDescription = null,
                tint = Color(0xFF161616),
                modifier = Modifier
                    .padding(end = 12.dp)
                    .size(20.dp)
            )
            Column {
                Text(
                    text = title,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    color = Color(0xFF161616)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = address,
                    fontSize = 14.sp,
                    color = Color(0xFF8E8E8E),
                    lineHeight = 18.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LocationSettingsScreenPreview() {
    LocationSettingsScreen()
}
