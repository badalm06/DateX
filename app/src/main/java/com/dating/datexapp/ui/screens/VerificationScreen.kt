package com.dating.datexapp.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import com.dating.datexapp.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun VerificationCodeScreen(
    phoneNumber: String,
    onBackClick: () -> Unit,
    onContinueClick: () -> Unit,
    onResendCodeClick: () -> Unit
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
        // Status Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 7.33.dp, start = 21.dp, end = 21.dp)
                .height(21.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
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

        // Progress bar
        Box(
            modifier = Modifier
                .padding(top = 62.dp)
                .align(Alignment.TopCenter)
        ) {
            Box(
                modifier = Modifier
                    .width(180.dp)
                    .height(8.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color(0x26F64F8B))
            )
            Box(
                modifier = Modifier
                    .width(22.5.dp)
                    .height(8.dp)
                    .clip(RoundedCornerShape(50))
                    .background(Color(0xFFF64F8B))
            )
        }

        // Curve2 Decorative Vector with Border
        Image(
            painter = painterResource(id = R.drawable.curve2), // Use correct resource name
            contentDescription = "Curve2 Decoration",
            modifier = Modifier
                .fillMaxWidth()
                .height(86.dp)
                .align(Alignment.BottomCenter)
                .offset(y = (-171).dp), // Adjust this for fine-tuning
            contentScale = ContentScale.FillWidth
        )



        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(120.dp))

            // Title
            Text(
                text = "Verification Code",
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily(Font(R.font.manrope_semi_boldddd)),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Subtitle
            Text(
                buildAnnotatedString {
                    append("Please enter code we just send to\n")
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(phoneNumber)
                    }
                },
                fontSize = 14.sp,
                color = Color(0xFF333333),
                fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            // OTP input
            val codeDigits = listOf("5", "1", "-", "-")

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                codeDigits.forEach { digit ->
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .border(1.dp, Color(0xFFF64F8B), shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = digit,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }


            Spacer(modifier = Modifier.height(40.dp))

            // Resend Text
            Text(
                buildAnnotatedString {
                    append("Didn’t receive OTP?\n")
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFFF64F8B),
                            fontWeight = FontWeight.SemiBold,
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("Resend Code")
                    }
                },
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
                modifier = Modifier
                    .width(125.dp)
                    .clickable { onResendCodeClick() }
            )

            Spacer(modifier = Modifier.height(30.dp))


            // Continue Button
            Button(
                onClick = onContinueClick,
                modifier = Modifier
                    .width(325.dp)
                    .height(58.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 0.dp),
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
}






@Preview(showBackground = true)
@Composable
fun VerificationCodeScreenPreview() {
    VerificationCodeScreen(
        phoneNumber = "+91 99292 77633",
        onBackClick = {},
        onContinueClick = {},
        onResendCodeClick = {}
    )
}

