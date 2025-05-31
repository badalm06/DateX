@file:OptIn(ExperimentalMaterial3Api::class)

package com.dating.datexapp.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.GradientButton
import com.dating.datexapp.ui.common.IconButtonBox
import com.dating.datexapp.ui.common.StatusBar

@Composable
fun SettingScreen(
    onBackClick: () -> Unit,
    onAboutUsClick: () -> Unit,
    onLocationClick: () -> Unit,
    onBlockedUsersClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onPhNumClick: () -> Unit,
    onEmailClick: () -> Unit
) {
    var isIncognitoEnabled by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {

            StatusBar()
            Spacer(modifier = Modifier.height(16.dp))

            // Back Arrow and Title
            Row(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButtonBox(
                    iconResId = R.drawable.back_arrow,
                    contentDescription = "Back",
                    onClick = { onBackClick() }
                )
                Text(
                    text = "Edit Profile",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF333333),
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Account Settings
            Text(
                text = "Account Settings",
                fontSize = 18.sp,
                color = Color(0xFF161616),
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(start = 6.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color(0xFFF64F8B),
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(vertical = 8.dp)
            ) {
                SettingItem("Phone Number", "+91 9876543210",  onPhNumClick)
                Divider()
                SettingItem("Email", "lucifer786@gmail.com", onEmailClick)
                Divider()
                SettingItem("Current Location", "San Francisco", onLocationClick)
            }

            Spacer(modifier = Modifier.height(24.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Incognito Mode",
                    fontSize = 18.sp,
                    color = Color(0xFF161616),
                    fontWeight = FontWeight.Normal
                )

                Switch(
                    checked = isIncognitoEnabled,
                    onCheckedChange = { isIncognitoEnabled = it },
                    modifier = Modifier.scale(0.8f).width(44.dp).height(22.dp),
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,
                        checkedTrackColor = Color(0xFFF64F8B),
                        uncheckedThumbColor = Color.White,
                        uncheckedTrackColor = Color.LightGray
                    )
                )
            }
            Text(
                text = "Enable incognito mode so no one sees you unless\nyou want them to. Only people you swipe right on\nwill be able to view your profile.",
                fontSize = 14.sp,
                color = Color.Gray,
                lineHeight = 18.sp,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .fillMaxWidth()
            )


            Spacer(modifier = Modifier.height(24.dp))

            // Preferred Language
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { }
                    .padding(vertical = 12.dp, horizontal = 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column {
                    Text(
                        text = "Preferred Languages",
                        fontSize = 18.sp,
                        color = Color(0xFF161616)
                    )
                    Spacer(modifier = Modifier.height(18.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        Text(
                            text = "English",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.ic_next),
                            contentDescription = null,
                            modifier = Modifier
                                .height(14.dp)
                                .width(20.dp)
                        )
                    }
                    Divider(
                        color = Color.LightGray,
                        thickness = 1.dp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

            }


            Spacer(modifier = Modifier.height(16.dp))

            // More About Us
            Text(text = "More About Us", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color(0xFFF64F8B),
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                listOf("About Us", "Share", "Privacy Policy", "Terms of Services").forEach {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onAboutUsClick() }
                            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = it, fontSize = 16.sp, color = Color.Gray)
                        Icon(
                            painter = painterResource(id = R.drawable.ic_next),
                            contentDescription = null,
                            modifier = Modifier
                                .height(14.dp)
                                .width(20.dp)
                        )
                    }
                    if (it != "Terms of Services") Divider()
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Support & Feedback
            Text(text = "Support & Feedback", fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color(0xFFF64F8B),
                        shape = RoundedCornerShape(12.dp)
                    )
            ) {
                listOf("Rate Us", "Help & support").forEach {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { }
                            .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = it, fontSize = 16.sp, color = Color.Gray)
                        Icon(
                            painter = painterResource(id = R.drawable.ic_next),
                            contentDescription = null,
                            modifier = Modifier
                                .height(14.dp)
                                .width(20.dp)
                        )
                    }
                    if (it != "Help & support") Divider()
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Blocked Users & Notifications
            Column {
                // Blocked Users
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onBlockedUsersClick() }
                        .padding(vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Blocked Users", fontSize = 18.sp)
                    Icon(
                        painter = painterResource(id = R.drawable.ic_next),
                        contentDescription = null,
                        modifier = Modifier
                            .height(14.dp)
                            .width(20.dp)
                    )
                }

                // Notifications
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onNotificationClick() }
                        .padding(vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Notifications", fontSize = 18.sp)
                    Icon(
                        painter = painterResource(id = R.drawable.ic_next),
                        contentDescription = null,
                        modifier = Modifier
                            .height(14.dp)
                            .width(20.dp)
                    )
                }
            }


            Image(
                painter = painterResource(id = R.drawable.curve8),
                contentDescription = null,
                modifier = Modifier
                    .width(450.dp)
                    .height(97.dp)
                    .align(Alignment.CenterHorizontally)
            )


            // Log Out Button
            GradientButton(
                text = "Log out",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp)
                    .padding(horizontal = 8.dp)
            ) {
                // Handle logout
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Delete Account",
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(24.dp))
        }

    }
}

@Composable
fun SettingItem(
    title: String,
    value: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 10.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = value,
            fontSize = 14.sp,
            color = Color.Gray,
            textAlign = TextAlign.End,
            modifier = Modifier.weight(1f)
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_next),
            contentDescription = null,
            modifier = Modifier
                .height(14.dp)
                .width(20.dp)
                .padding(start = 8.dp)
        )
    }
}



@Preview(showBackground = true)
@Composable
fun SettingScreenPreview() {
    SettingScreen(
        onBackClick = {},
        onLocationClick = {},
        onAboutUsClick = {},
        onBlockedUsersClick = {},
        onNotificationClick = {},
        onPhNumClick = {},
        onEmailClick = {}
    )
}
