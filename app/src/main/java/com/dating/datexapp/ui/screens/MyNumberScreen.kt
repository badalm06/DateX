package com.dating.datexapp.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.border
import com.dating.datexapp.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*

@Composable
fun MyNumberIsScreen(
    onContinueClick: () -> Unit,
    onFacebookLogin: () -> Unit,
    onGoogleLogin: () -> Unit,
    onSignUpClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFFFFFFF), Color(0xFFFFFFFF))
                )
            )
    ) {
        // Background Image from drawable
        Image(
            painter = painterResource(id = R.drawable.curve),
            contentDescription = "Background Curve",
            modifier = Modifier
                .size(width = 400.dp, height = 341.dp)
                .offset(y = 471.dp)
        )

        // Status Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 7.33.dp, start = 21.dp, end = 21.dp)
                .height(21.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(R.drawable.ic_time), contentDescription = "Time", modifier = Modifier.size(54.dp, 21.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Image(painter = painterResource(R.drawable.ic_cellular), contentDescription = "Cellular", modifier = Modifier.size(17.dp, 10.66.dp))
                Image(painter = painterResource(R.drawable.ic_wifi), contentDescription = "WiFi", modifier = Modifier.size(15.33.dp, 11.dp))
                Image(painter = painterResource(R.drawable.ic_battery), contentDescription = "Battery", modifier = Modifier.size(24.33.dp, 11.33.dp))
            }
        }

        // Back Button
        Box(
            modifier = Modifier
                .offset(x = 20.dp, y = 54.dp)
                .size(24.dp)
                .clickable { /* TODO: Handle back */ },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = "Back",
                tint = Color(0xFF1E1E1E),
                modifier = Modifier.size(16.dp, 14.dp)
            )
        }

        // Progress Bar Background
        Box(
            modifier = Modifier
                .offset(x = 97.dp, y = 62.dp)
                .size(width = 180.dp, height = 8.dp)
                .background(color = Color(0x26F64F8B), shape = RoundedCornerShape(50))
        )

        // Progress Bar Foreground
        Box(
            modifier = Modifier
                .offset(x = 97.dp, y = 62.dp)
                .size(width = 22.5.dp, height = 8.dp)
                .background(color = Color(0xFFF64F8B), shape = RoundedCornerShape(50))
        )

        // Title Text
        Text(
            text = "My Number Is",
            modifier = Modifier
                .offset(x = 54.dp, y = 120.dp)
                .width(266.dp)
                .height(33.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily(Font(R.font.manrope_semi_boldddd)),
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        // Subtitle Text
        Text(
            text = "We'll need your phone number to send an OTP for verification.",
            modifier = Modifier
                .offset(x = 48.dp, y = 163.dp)
                .width(278.dp)
                .height(40.dp),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
            color = Color(0xFF333333),
            textAlign = TextAlign.Center,
            lineHeight = 20.sp
        )

        // Phone Input Box
        var phoneNumber by remember { mutableStateOf("") }

        Row(
            modifier = Modifier
                .offset(x = 35.dp, y = 237.dp)
                .width(325.dp)
                .height(56.dp)
                .background(Color.White, shape = RoundedCornerShape(50.dp))
                .border(1.dp, Color(0xFFF64F8B), shape = RoundedCornerShape(50.dp))
                .padding(start = 12.dp, end = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.flag),
                contentDescription = "Flag",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "+91",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(6.dp))
            Icon(
                painter = painterResource(id = R.drawable.vector),
                contentDescription = "Dropdown",
                modifier = Modifier.size(8.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Image(
                painter = painterResource(id = R.drawable.line1),
                contentDescription = "Divider",
                modifier = Modifier
                    .height(28.dp)
                    .width(1.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                placeholder = {
                    Text(
                        "Enter phone number",
                        fontFamily = FontFamily(Font(R.font.manrope_regularrrr))
                    )
                },
                singleLine = true,
                modifier = Modifier.weight(1f),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent,
                    cursorColor = Color.Black
                ),
                textStyle = TextStyle(
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.manrope_regularrrr))
                )
            )
        }

        // Continue Button
        Button(
            onClick = onContinueClick,
            modifier = Modifier
                .width(325.dp)
                .height(58.dp)
                .offset(x = 35.dp, y = 330.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(50),
            contentPadding = PaddingValues()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            listOf(Color(0xFFF64F8B), Color(0xFFF8CE61))
                        ),
                        shape = RoundedCornerShape(50)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Continue",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily(Font(R.font.manrope_semi_boldddd))
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyNumberIsScreenPreview() {
    MyNumberIsScreen(
        onContinueClick = {},
        onFacebookLogin = {},
        onGoogleLogin = {},
        onSignUpClick = {}
    )
}

