package com.dating.datexapp.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.GradientButton
import com.dating.datexapp.ui.common.StatusBar


@Composable
fun AskSubmitPhotoScreen(
    onCloseClick: () -> Unit = {},
    onSubmitClick: () -> Unit = {},
    onRetakeClick: () -> Unit = {},
    onGetPremiumClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFDF7F1))
    ) {

        // Close Button
        Box(
            modifier = Modifier
                .offset(x = 20.dp, y = 42.dp)
                .size(42.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color(0x14F64F8B))
                .border(1.dp, Color(0x26F64F8B), RoundedCornerShape(24.dp))
                .clickable(onClick = onCloseClick),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_close),
                contentDescription = null,
                tint = Color(0xFF161616),
                modifier = Modifier.size(12.dp)
            )
        }

        // Images Group
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 114.dp)
                .height(200.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.asp_img1),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 140.dp, height = 200.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(id = R.drawable.asp_img2),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 140.dp, height = 200.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }


        // Content Group
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 352.dp)
        ) {
            Text(
                text = "Happy to Submit Your \nPhoto?",
                fontSize = 26.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "For verification to be successful",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                textAlign = TextAlign.Start
            )


            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "   • Your face must be clearly visible\n   • You must be copying the pose exactly",
                color = Color(0xFF808080),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 24.sp
            )

            Spacer(modifier = Modifier.height(28.dp))
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 537.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GradientButton(
                text = "Submit",
                onClick = onSubmitClick,
                modifier = Modifier
                    .width(325.dp)
                    .height(58.dp)
            )

            Spacer(modifier = Modifier.height(12.dp)) // Add space between button and text

            Text(
                text = "Retake",
                color = Color(0xFF161616),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                letterSpacing = 0.3.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .clickable(onClick = onRetakeClick)
            )
        }

        // Bottom Text
        Text(
            text = "This photo won’t be uploaded to your profile. It’ll only\nbe used to verify you and help keep you safe.\nContact Support",
            color = Color(0xFF808080),
            fontSize = 14.sp,
            fontWeight = FontWeight.Light,
            lineHeight = 22.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .offset(x = 20.dp, y = 762.dp)
                .width(335.dp)
                .height(66.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AskSubmitPhotoScreenPreview() {
    AskSubmitPhotoScreen()
}
