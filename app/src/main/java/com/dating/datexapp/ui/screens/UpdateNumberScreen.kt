package com.dating.datexapp.ui.screens

import androidx.compose.foundation.*
import com.dating.datexapp.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Link
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.dating.datexapp.ui.common.GradientButton
import com.dating.datexapp.ui.common.IconButtonBox
import com.dating.datexapp.ui.common.PhoneNumberInputField
import com.dating.datexapp.ui.common.StatusBar

@Composable
fun UpdateNumberScreen(
    onContinueClick: () -> Unit,
    onBackClick: () -> Unit

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
        Spacer(modifier = Modifier.height(44.dp))
        StatusBar()


        // Back Button
        IconButtonBox(
            iconResId = R.drawable.back_arrow,
            contentDescription = "Back",
            onClick = onBackClick,
            modifier = Modifier.offset(x = 20.dp, y = 54.dp)
        )


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

        // Phone Input Box.
        var phoneNumber by remember { mutableStateOf("") }

        PhoneNumberInputField1(
            phoneNumber = phoneNumber,
            onPhoneNumberChange = { phoneNumber = it },
            modifier = Modifier.offset(x = 35.dp, y = 237.dp)
        )


        // Gradient button
        GradientButton(
            text = "Continue",
            modifier = Modifier
                .offset(x = 35.dp, y = 330.dp)
                .width(325.dp)
                .height(58.dp),
            onClick = {onContinueClick()}
        )

    }
}

@Composable
fun PhoneNumberInputField1(
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
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

        Spacer(modifier = Modifier.width(4.dp))

        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = "Dropdown",
            modifier = Modifier.size(16.dp),
            tint = Color.Black
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Vertical divider
        Box(
            modifier = Modifier
                .height(28.dp)
                .width(1.dp)
                .background(Color.LightGray)
        )

        Spacer(modifier = Modifier.width(8.dp))

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = onPhoneNumberChange,
            placeholder = {
                Text(
                    "9876543210",
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

        Icon(
            painter = painterResource(id = R.drawable.ic_edit),
            contentDescription = "Link Icon",
            modifier = Modifier.size(20.dp),
            tint = Color.Black
        )
    }
}



@Preview(showBackground = true)
@Composable
fun UpdateNumberScreenPreview() {
    UpdateNumberScreen(
        onContinueClick = {},
        onBackClick = {}

    )
}

