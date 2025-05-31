package com.dating.datexapp.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.IconButtonBox
import com.dating.datexapp.ui.common.StatusBar
import com.dating.datexapp.ui.common.TitleText

@Composable
fun VerificationProcessingScreen(
    onDemoImgClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .zIndex(1f)
            .padding(top = 38.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .shadow(1.dp, RoundedCornerShape(16.dp), clip = false)
    ) {
        Image(
            painter = painterResource(id = R.drawable.verification_processing),
            contentDescription = null,
            modifier = Modifier
                .size(width = 78.dp, height = 66.dp)
                .align(Alignment.CenterStart)
                .padding(start = 10.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "We’ve got your photo, we’ll get back to you soon!",
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.manrope_regular)),
            fontWeight = FontWeight.W300,
            fontSize = 14.sp,
            letterSpacing = 0.3.sp,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 95.dp)
                .width(240.dp)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        StatusBar()
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButtonBox(R.drawable.back_arrow, "Back", onClick = { })
            Text(
                text = "Edit Profile",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF333333),
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(28.dp))
        TitleText("Upload Your Photo", Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "We'd love to see you. Upload a photo for\nyour dating journey.",
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.manrope_regularrrr)),
            color = Color(0xFF333333),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(32.dp))

        Box(modifier = Modifier.fillMaxWidth().height(360.dp), contentAlignment = Alignment.Center) {
            Box(
                modifier = Modifier
                    .size(216.dp)
                    .align(Alignment.CenterStart)
                    .offset(x = 26.dp, y = (-60).dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Image(painter = painterResource(id = R.drawable.demo_image), contentDescription = null, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize().clickable{onDemoImgClick()})
                Box(modifier = Modifier.matchParentSize())
            }

            val plusIcon = painterResource(id = R.drawable.plus_icon)
            Column(
                verticalArrangement = Arrangement.spacedBy(18.dp),
                horizontalAlignment = Alignment.End,
                modifier = Modifier.align(Alignment.CenterStart).offset(x = 16.dp)
            ) {
                UploadBox(plusIcon)
                UploadBox(plusIcon)
                Row(horizontalArrangement = Arrangement.spacedBy(18.dp), modifier = Modifier.padding(start = 12.dp)) {
                    repeat(3) { UploadBox(plusIcon, Modifier.width(110.dp)) }
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))


        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(34.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left icon
            Image(
                painter = painterResource(id = R.drawable.ic_verified),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 22.dp, height = 24.dp)
                    .alpha(0.6f)
            )

            Spacer(modifier = Modifier.width(9.dp))

            // Text label
            Text(
                text = "Verify my profile",
                color = Color.Black,
                fontSize = 16.sp,
                modifier = Modifier
                    .width(122.dp)
                    .height(20.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "Verify Now",
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier.
                width(91.dp)
                    .height(18.dp)
                    .offset(x = 20.dp)
            )


            // Right icon (same as left)
            Image(
                painter = painterResource(id = R.drawable.ic_next),
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp)
                    .alpha(0.6f)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(horizontal = 16.dp).width(355.dp))
        Spacer(modifier = Modifier.height(14.dp))

        Column(Modifier.padding(horizontal = 16.dp).width(355.dp)) {
            Text("Basic Info", fontSize = 18.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily(Font(R.font.manrope_regularrrr)), color = Color(0xFF161616), modifier = Modifier.padding(bottom = 16.dp))
            InfoRow("Name", "Lucifier")
            Divider(color = Color.LightGray, thickness = 1.dp)
            Spacer(modifier = Modifier.height(16.dp))
            InfoRow("Gender", "Male")
            Divider(color = Color.LightGray, thickness = 1.dp)
            Spacer(modifier = Modifier.height(16.dp))
            InfoRow("Birthday", "11/Sept/1999")
            Divider(color = Color.LightGray, thickness = 1.dp)
            Spacer(modifier = Modifier.height(16.dp))
            InfoRow("Current Location", "San Francisco")
            Divider(color = Color.LightGray, thickness = 1.dp)
            Spacer(modifier = Modifier.height(16.dp))
        }

        Spacer(modifier = Modifier.height(14.dp))
        Column(Modifier.padding(horizontal = 16.dp).width(352.dp).height(409.dp)) {
            Text("More Info", fontSize = 18.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily(Font(R.font.manrope_regularrrr)), color = Color(0xFF161616), modifier = Modifier.padding(bottom = 16.dp))
            FilterOption("Height", R.drawable.height)
            FilterOption("Looking For", R.drawable.magnifier)
            FilterOption("Sexual Orientation", R.drawable.sexual_orientation)
            FilterOption("Education", R.drawable.education)
            FilterOption("Religion", R.drawable.religion)
            FilterOption("Workout", R.drawable.workout)
            FilterOption("Smoking", R.drawable.smoking)
            FilterOption("Drinking", R.drawable.drinking)
            FilterOption("Interests", R.drawable.interest)
        }

        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            // Title
            Text(
                text = "About Me",
                fontSize = 18.sp,
                color = Color(0xFF161616),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Input box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .background(Color.Transparent, RoundedCornerShape(10.dp))
                    .border(1.dp, Color(0xFFD4D4D4), RoundedCornerShape(10.dp))
                    .padding(12.dp)
            ) {
                Text(
                    text = "Write something about yourself…",
                    fontSize = 14.sp,
                    color = Color(0xFF808080),
                    modifier = Modifier.align(Alignment.TopStart)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, end = 4.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "300 Characters",
                    fontSize = 12.sp,
                    color = Color(0xFF808080)
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, fontSize = 16.sp, fontFamily = FontFamily(Font(R.font.manrope_regularrrr)), color = Color(0xFF161616), modifier = Modifier.weight(1f))
        Text(value, fontSize = 16.sp, fontFamily = FontFamily(Font(R.font.manrope_regularrrr)), color = Color(0xFF161616), modifier = Modifier.offset(x = 10.dp))
        Image(painter = painterResource(id = R.drawable.ic_next), contentDescription = null, modifier = Modifier.size(16.dp).offset(x = 10.dp))
    }
}

@Composable
fun FilterOption(label: String, iconRes: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Left Icon
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(14.dp),
            colorFilter = ColorFilter.tint(Color.Black)
        )

        Spacer(modifier = Modifier.width(10.dp))

        // Label Text
        Text(
            text = label,
            fontSize = 16.sp,
            color = Color(0xFF161616),
            modifier = Modifier.weight(1f)
        )

        // Right "Add" + ic_next Icon
        Text(
            text = "Add",
            fontSize = 14.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.width(6.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_next),
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun VerificationProcessingScreenPreview() {
    VerificationProcessingScreen(
        onDemoImgClick = {}
    )
}
