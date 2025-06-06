package com.dating.datexapp.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.compose.ui.tooling.preview.Preview
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.GradientButton
import com.dating.datexapp.ui.common.IconButtonBox
import com.dating.datexapp.ui.common.ProgressIndicator
import com.dating.datexapp.ui.common.StatusBar
import com.dating.datexapp.ui.common.TitleText
import java.nio.file.Files.size

@Composable
fun EditProfileNotVerified2Screen(
    onOkayClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x80000000))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButtonBox(
                    iconResId = R.drawable.back_arrow,
                    contentDescription = "Back",
                    onClick = { }
                )
                Text(
                    text = "Edit Profile",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF333333),
                    modifier = Modifier
                        .weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(28.dp))
            TitleText(
                text = "Upload Your Photo",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "We'd love to see you. Upload a photo for\nyour dating journey.",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
                color = Color(0xFF333333),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Main Image + Upload Boxes Layout
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(360.dp),
                contentAlignment = Alignment.Center
            ) {
                // Main image on right
                Box(
                    modifier = Modifier
                        .size(width = 216.dp, height = 216.dp)
                        .align(Alignment.CenterStart)
                        .offset(x = (26).dp)
                        .offset(y = (-60).dp)
                        .clip(RoundedCornerShape(16.dp)),

                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.demo_image),
                        contentDescription = "Main Profile Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .background(Color(0x55000000))
                    )
                }

                // Upload Boxes
                val plusIcon = painterResource(id = R.drawable.plus_icon)

                Column(
                    verticalArrangement = Arrangement.spacedBy(18.dp),
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .offset(x = 16.dp)
                ) {
                    UploadBox1(plusIcon)
                    UploadBox1(plusIcon)

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(18.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
                        repeat(3) {
                            UploadBox1(plusIcon, modifier = Modifier.width(110.dp))
                        }
                    }
                }
            }

            // Group: Verify My Profile
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(34.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_verified),
                    contentDescription = "Verified Icon",
                    modifier = Modifier
                        .size(width = 22.dp, height = 24.dp)
                        .alpha(0.6f)
                )


                Spacer(modifier = Modifier.width(9.dp))
                Text(
                    text = "Verify my profile",
                    color = Color.Black,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .background(Color.Transparent, RoundedCornerShape(4.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .width(122.dp)
                        .height(20.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Verified    >",
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .background(Color.Transparent, RoundedCornerShape(4.dp))
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                        .width(91.dp)
                        .height(18.dp)
                        .offset(x = 20.dp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
            Divider(color = Color.Gray, thickness = 1.dp)
            Spacer(modifier = Modifier.height(14.dp))


            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .width(335.dp)
                    .height(223.dp)
            ) {
                Text(
                    text = "Basic Info",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
                    color = Color(0xFF161616),
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .height(25.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Name",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
                        color = Color(0xFF161616),
                        modifier = Modifier
                            .weight(1f)
                            .height(20.dp)
                    )
                    Text(
                        text = "Lucifier",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
                        color = Color(0xFF161616),
                        modifier = Modifier
                            .width(63.dp)
                            .height(19.dp)
                            .offset(x = 10.dp)
                    )
                }
            }
        }

        // Delete Photo Popup
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(279.dp)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
                .align(Alignment.BottomCenter)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 33.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "You need at least\none photo",
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.manrope_regular)),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 30.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .width(205.dp)
                        .height(65.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "If you’d like to delete this photo, please add\nanother one first. Everyone on Dream friend\nneeds at least one photo.",
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.manrope_regular)),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    lineHeight = 22.sp,
                    color = Color(0xFF808080),
                    modifier = Modifier
                        .width(330.dp)
                        .height(66.dp)
                )

                Spacer(modifier = Modifier.height(24.dp))

                GradientButton(
                    text = "OK",
                    modifier = Modifier
                        .width(337.dp)
                        .height(50.dp),
                    onClick = { onOkayClick()}
                )
            }

        }

    }
}



@Preview(showBackground = true)
@Composable
fun EditProfileNotVerified2ScreenPreview() {
    EditProfileNotVerified2Screen(
        onOkayClick = {}
    )
}
