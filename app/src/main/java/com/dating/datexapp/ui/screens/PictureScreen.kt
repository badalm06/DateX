package com.dating.datexapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dating.datexapp.ui.common.GradientButton
import com.dating.datexapp.ui.common.IconButtonBox
import com.dating.datexapp.ui.common.ProgressIndicator
import com.dating.datexapp.ui.common.StatusBar
import com.dating.datexapp.ui.common.TitleText
import com.dating.datexapp.R

@Composable
fun PictureScreen(
    onContinueClick: () -> Unit,
    onBackClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFEF9F5))
    ) {
        Image(
            painter = painterResource(id = R.drawable.curve8),
            contentDescription = null,
            modifier = Modifier
                .size(width = 395.dp, height = 301.dp)
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
                ProgressIndicator(
                    totalWidth = 180.dp,
                    progressWidth = 180.dp,
                    height = 8.dp
                )
            }

            Spacer(modifier = Modifier.height(48.dp))
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
                        .clip(RoundedCornerShape(16.dp))

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.demo_image),
                        contentDescription = "Main Profile Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                // Upload Boxes
                val plusIcon = painterResource(id = R.drawable.plus_icon)

                Column(
                    verticalArrangement = Arrangement.spacedBy(18.dp),
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.align(Alignment.CenterStart).offset(x = 16.dp)
                ) {
                    UploadBox(plusIcon)
                    UploadBox(plusIcon)

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(18.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
                        repeat(3) {
                            UploadBox(plusIcon, modifier = Modifier.width(110.dp))
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))
            GradientButton(
                text = "Continue",
                onClick = onContinueClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .height(56.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun UploadBox(plusIcon: Painter, modifier: Modifier = Modifier) {
    val borderColor = Color(0xFFF64F8B)
    val cornerRadius = 16.dp  // ⬅️ Increase this for more curve

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(100.dp)
        //    .clip(RoundedCornerShape(cornerRadius))
            .background(Color.White)
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                val dashWidth = 5.dp.toPx()
                val dashGap = 5.dp.toPx()

                val paint = Paint().asFrameworkPaint().apply {
                    isAntiAlias = true
                    style = android.graphics.Paint.Style.STROKE
                    color = borderColor.toArgb()
                    this.strokeWidth = strokeWidth
                    pathEffect = android.graphics.DashPathEffect(
                        floatArrayOf(dashWidth, dashGap), 0f
                    )
                }

                val radiusPx = cornerRadius.toPx()
                drawContext.canvas.nativeCanvas.drawRoundRect(
                    0f,
                    0f,
                    size.width,
                    size.height,
                    radiusPx,
                    radiusPx,
                    paint
                )
            }
    ) {
        Image(
            painter = plusIcon,
            contentDescription = "Add Photo",
            modifier = Modifier.size(28.dp)
        )
    }
}




@Preview(showBackground = true)
@Composable
fun PictureScreenPreview() {
   PictureScreen(
        onContinueClick = {},
        onBackClick = {}
    )
}
