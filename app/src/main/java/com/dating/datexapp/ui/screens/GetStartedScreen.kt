package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import com.dating.datexapp.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GetStartedScreen(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFFFFFBFA), Color.White)))
    ) {
        // Status Bar
        Spacer(modifier = Modifier.height(44.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 7.33.dp, start = 21.dp, end = 21.dp)
                .height(21.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Time
            Image(
                painter = painterResource(id = R.drawable.ic_time), // Replace with your actual time drawable name
                contentDescription = "Time",
                modifier = Modifier.size(width = 54.dp, height = 21.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                // Cellular
                Image(
                    painter = painterResource(id = R.drawable.ic_cellular), // Replace with your actual drawable
                    contentDescription = "Cellular",
                    modifier = Modifier.size(width = 17.dp, height = 10.66.dp)
                )
                // WiFi
                Image(
                    painter = painterResource(id = R.drawable.ic_wifi), // Replace with your actual drawable
                    contentDescription = "Wi-Fi",
                    modifier = Modifier.size(width = 15.33.dp, height = 11.dp)
                )
                // Battery
                Image(
                    painter = painterResource(id = R.drawable.ic_battery), // Replace with your actual drawable
                    contentDescription = "Battery",
                    modifier = Modifier.size(width = 24.33.dp, height = 11.33.dp)
                )
            }
        }


        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo), // replace with actual logo name
            contentDescription = "Logo",
            modifier = Modifier
                .size(121.dp)
                .offset(x = 127.dp, y = 19.dp)
        )

        // People Circles Image (Whole group can be pre-designed as 1 image)
        Image(
            painter = painterResource(id = R.drawable.group907), // you can also layer if needed
            contentDescription = "Hero Image",
            modifier = Modifier
                .width(400.dp)
                .height(367.dp)
                .offset(y = 119.dp)
        )

        // Headline Text
        Text(
            text = "Discover Love Where Your Story Begins.",
            modifier = Modifier
                .width(326.dp)
                .offset(x = 24.dp, y = 494.dp),
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily(Font(R.font.manrope_semi_boldddd)),
            lineHeight = 24.sp
        )

        // Subtext
        Text(
            text = "Join us to discover your ideal partner and ignite the sparks of romance in your journey.",
            modifier = Modifier
                .width(278.dp)
                .offset(x = 48.dp, y = 577.dp),
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
            lineHeight = 20.sp
        )

        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .width(327.dp)
                .height(56.dp)
                .offset(x = 24.dp, y = 674.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(50),
            contentPadding = PaddingValues()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color(0xFFF64F8B), Color(0xFFF8CE61))
                        ),
                        shape = RoundedCornerShape(50)
                    )
            ) {
                // 📍 Circle icon aligned to the start
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 6.dp)
                        .size(38.dp)
                        .background(Color.White, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.phone),
                        contentDescription = "Phone Icon",
                        modifier = Modifier.size(20.dp),
                        tint = Color(0xFFE94057)
                    )
                }

                // 📍 Text centered in the button
                Text(
                    text = "Login with Phone",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily(Font(R.font.manrope_semi_boldddd))
                )
            }
        }




        // Sign Up Text
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 753.dp),
            contentAlignment = Alignment.Center
        ) {
            Row {
                Text(
                    text = "Don’t have an account? ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.manrope_regularrrr))
                )
                Text(
                    text = "Sign Up",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily(Font(R.font.manrope_semi_boldddd)),
                    color = Color(0xFFE94057),
                    modifier = Modifier.clickable { onSignUpClick() }
                )
            }

        }
    }
}

//@Composable
//fun CustomIcon(
//    painter: Painter,
//    contentDescription: String,
//    modifier: Modifier = Modifier,
//    tint: Color = Color.Unspecified
//) {
//    Image(
//        painter = painter,
//        contentDescription = contentDescription,
//        modifier = modifier
//    )
//}

@Preview(showBackground = true)
@Composable
fun GetStartedScreenPreview() {
    GetStartedScreen(
        onLoginClick = {},
        onSignUpClick = {}
    )
}

