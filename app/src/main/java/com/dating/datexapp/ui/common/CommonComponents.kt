package com.dating.datexapp.ui.common

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.sp
import com.dating.datexapp.R

// Gradient Button - Reusable
@Composable
fun GradientButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
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
                text = text,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily(Font(R.font.manrope_semi_boldddd))
            )
        }
    }
}

// Progress Indicator
@Composable
fun ProgressIndicator(
    totalWidth: Dp,
    progressWidth: Dp,
    height: Dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(totalWidth)
            .height(height)
            .background(
                color = Color(0xFFF64F8B).copy(alpha = 0.15f),
                shape = RoundedCornerShape(50.dp)
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .width(progressWidth)
                .height(height)
                .background(
                    color = Color(0xFFF64F8B),
                    shape = RoundedCornerShape(50.dp)
                )
        )
    }
}




// Title Text - Reusable
@Composable
fun TitleText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = FontFamily(Font(R.font.manrope_semi_boldddd)),
        color = Color.Black,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

// Optional: OR Divider
@Composable
fun OrDivider(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp)
    ) {
        Box(
            modifier = Modifier
                .width(80.dp)
                .height(1.dp)
                .background(Color(0xFFD8D8D8))
        )
        Text(
            text = " OR ",
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Box(
            modifier = Modifier
                .width(80.dp)
                .height(1.dp)
                .background(Color(0xFFD8D8D8))
        )
    }
}

@Composable
fun StatusBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 7.33.dp, start = 18.dp, end = 21.dp)
            .height(21.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(R.drawable.ic_time),
            contentDescription = "Time",
            modifier = Modifier.size(54.dp, 21.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_cellular),
                contentDescription = "Cellular",
                modifier = Modifier.size(17.dp, 10.66.dp)
            )
            Image(
                painter = painterResource(R.drawable.ic_wifi),
                contentDescription = "WiFi",
                modifier = Modifier.size(15.33.dp, 11.dp)
            )
            Image(
                painter = painterResource(R.drawable.ic_battery),
                contentDescription = "Battery",
                modifier = Modifier.size(24.33.dp, 11.33.dp)
            )
        }
    }
}


@Composable
fun PhoneNumberInputField(
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
            onValueChange = onPhoneNumberChange,
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
}

// Back Botton
@Composable
fun IconButtonBox(
    iconResId: Int,
    contentDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconSize: DpSize = DpSize(16.dp, 14.dp),
    tint: Color = Color(0xFF1E1E1E)
) {
    Box(
        modifier = modifier
            .size(24.dp)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = contentDescription,
            tint = tint,
            modifier = Modifier.size(iconSize)
        )
    }
}

// ✅ Editable Text Box
@Composable
fun RoundedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder) },
        singleLine = true,
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color(0xFFF64F8B),
            focusedBorderColor = Color(0xFFF64F8B),
            cursorColor = Color.Black
        ),
        textStyle = TextStyle(fontSize = 16.sp)
    )
}
