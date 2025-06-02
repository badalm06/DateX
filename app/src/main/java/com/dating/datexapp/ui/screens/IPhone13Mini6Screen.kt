package com.dating.datexapp.ui.screens

import android.R.attr.alpha
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.GradientButton
import com.dating.datexapp.ui.common.IconButtonBox
import com.dating.datexapp.ui.common.StatusBar

@Composable
fun IPhone13Mini6Screen(
    onOkClick: () -> Unit,
    onAnyOtherClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0x80000000))
            .clickable{onAnyOtherClick()}
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            // Header Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp, start = 25.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButtonBox(
                    iconResId = R.drawable.back_arrow,
                    contentDescription = "Back",
                    onClick = {},
                )
                Spacer(modifier = Modifier.width(75.dp))
                Text(
                    text = "Choose Your Plan",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                )
            }

            ProfileHeader1()

            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                GradientBorderBox1(
                    width = 162.5.dp,
                    iconId = R.drawable.ps_like_img,
                    title = "Get\nSuper Likes",
                    gradient = Brush.verticalGradient(
                        listOf(Color(0x805558FF), Color(0x8000C0FF))
                    ),
                    backgroundGradient = Brush.verticalGradient(
                        listOf(Color(0x59ADDCFF), Color(0x59EAF6FF))
                    )
                )

                GradientBorderBox1(
                    width = 162.5.dp,
                    iconId = R.drawable.ps_boost_img,
                    title = "Get\nBoosts",
                    gradient = Brush.verticalGradient(
                        listOf(Color(0x80A93AFF), Color(0x80FF81FF))
                    ),
                    backgroundGradient = Brush.verticalGradient(
                        listOf(Color(0x59FFBEF9), Color(0x59FFF1FF), Color(0x59FFF1FF))
                    )
                )
            }


        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(428.dp)
                .align(Alignment.BottomCenter)
                .background(Color.White, shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 54.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Profile Image
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.im_img),
                        contentDescription = "User Photo",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ps_boost_img),
                        contentDescription = "Boost Icon",
                        modifier = Modifier
                            .size(32.dp)
                            .align(Alignment.BottomEnd)
                            .offset(x = 6.dp, y = 6.dp)
                    )
                }

                Spacer(modifier = Modifier.height(28.dp))

                Text(
                    text = "Get more matches",
                    color = Color(0xFF161616),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 30.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "For the next 30 minutes, your profile will be\n" +
                            "shown to more users in your area! Start\n" +
                            "swiping to maximize your matches.",
                    color = Color(0xFF808080),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    lineHeight = 22.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(42.dp))

                GradientButton(
                    text = "OK",
                    modifier = Modifier
                        .width(337.dp)
                        .height(50.dp),
                    onClick = { onOkClick() }
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewIPhone13Mini6Screen() {
    IPhone13Mini6Screen(
        onAnyOtherClick = {},
        onOkClick = {}
    )
}
