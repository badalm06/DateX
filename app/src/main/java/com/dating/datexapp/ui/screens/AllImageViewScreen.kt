package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.IconButtonBox
import com.dating.datexapp.ui.common.StatusBar

@Composable
fun AllImageViewScreen(
    onBackClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFEF9F5)),
        contentAlignment = Alignment.Center
    )  {
        // Background Curve
        Image(
            painter = painterResource(id = R.drawable.curve8),
            contentDescription = null,
            modifier = Modifier
                .size(width = 395.dp, height = 231.dp)
                .align(Alignment.BottomCenter)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            StatusBar()
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
                    onClick = onBackClick
                )
                Spacer(modifier = Modifier.width(60.dp))
                Text(
                    text = "Kalvin’s Photos",
                    fontFamily = FontFamily(Font(R.font.manrope_semi_bold)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .offset(x = 24.dp)

                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Main Image
            Image(
                painter = painterResource(id = R.drawable.ca_main_image),
                contentDescription = "Main Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(48.dp))

            // Bottom Thumbnails
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .width(206.dp)
                    .height(50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.aiv_img1),
                    contentDescription = "Image 1",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .border(1.5.dp, Color(0xFFF64F8B), RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp))

                )
                Image(
                    painter = painterResource(id = R.drawable.aiv_img2),
                    contentDescription = "Image 2",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(44.dp)
                        .border(0.2.dp, Color(0xFF949494), RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp))
                )
                Image(
                    painter = painterResource(id = R.drawable.aiv_img3),
                    contentDescription = "Image 3",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(44.dp)
                        .border(0.2.dp, Color(0xFF949494), RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp))
                )
                Image(
                    painter = painterResource(id = R.drawable.aiv_img4),
                    contentDescription = "Image 4",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(44.dp)
                        .border(0.2.dp, Color(0xFF949494), RoundedCornerShape(8.dp))
                        .clip(RoundedCornerShape(8.dp))
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AllImageViewScreenPreview() {
    AllImageViewScreen(
        onBackClick = {}
    )
}
