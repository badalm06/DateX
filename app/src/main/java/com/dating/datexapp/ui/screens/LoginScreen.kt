package com.dating.datexapp.ui.screens

import android.R.attr.phoneNumber
import androidx.compose.foundation.Image
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.GradientButton
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dating.datexapp.ui.common.PhoneNumberInputField
import com.dating.datexapp.ui.common.StatusBar


@Composable
fun LoginScreen(
    onContinueClick: () -> Unit,
    onFacebookLogin: () -> Unit,
    onGoogleLogin: () -> Unit,
    onSignUpClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // adjust to fit screen
        )



        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(121.dp)
                .offset(x = 127.dp, y = 20.dp)
        )

        // Title
        Text(
            text = "Let’s start with your number",
            modifier = Modifier
                .width(266.dp)
                .offset(x = 54.dp, y = 145.dp),
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily(Font(R.font.manrope_semi_boldddd)),
            color = Color.Black
        )

            // Phone number text field
        var phoneNumber by remember { mutableStateOf("") } // ✅ Correct (String)

        PhoneNumberInputField(
            phoneNumber = phoneNumber.toString(),
            onPhoneNumberChange = { phoneNumber = it },
            modifier = Modifier.offset(x = 35.dp, y = 237.dp)
        )


        GradientButton(
            text = "Continue",
            modifier = Modifier
                .offset(x = 35.dp, y = 330.dp)
                .width(325.dp)
                .height(58.dp),
            onClick = onContinueClick
        )


        // OR Divider
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .offset(y = 418.dp)
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
            horizontalArrangement = Arrangement.Center
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


        // Social Login Buttons

        SocialLoginButtons(
            onFacebookLogin = onFacebookLogin,
            onGoogleLogin = onGoogleLogin
        )



        // Bottom Text
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 790.dp),
            contentAlignment = Alignment.Center
        ) {
            Row {
                Text(
                    text = "Don’t have an account? ",
                    fontSize = 14.sp,
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

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onContinueClick = {},
        onFacebookLogin = {},
        onGoogleLogin = {},
        onSignUpClick = {}
    )
}

@Composable
fun SocialLoginButtons(
    onFacebookLogin: () -> Unit,
    onGoogleLogin: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp)
            .offset(y = 460.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Facebook Button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .border(1.dp, Color(0xFFE8E8E8), shape = RoundedCornerShape(50.dp))
                .background(Color.White, shape = RoundedCornerShape(50.dp))
                .clickable { onFacebookLogin() },
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(Color.White, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.facebook_icon),
                        contentDescription = "Facebook Icon",
                        tint = Color(0xFF4267B2),
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.width(46.dp))
                Text(
                    text = "Login with Facebook",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.manrope_semi_boldddd)),
                    color = Color.Black
                )
            }
        }

        // Google Button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .border(1.dp, Color(0xFFE8E8E8), shape = RoundedCornerShape(50.dp))
                .background(Color.White, shape = RoundedCornerShape(50.dp))
                .clickable { onGoogleLogin() },
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .background(Color.White, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.google_icon),
                        contentDescription = "Google Icon",
                        tint = Color.Unspecified, // keep original color
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.width(46.dp))
                Text(
                    text = "Login with Google",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.manrope_semi_boldddd)),
                    color = Color.Black
                )
            }
        }
    }
}
