package com.dating.datexapp.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dating.datexapp.R

//@Preview(showBackground = true)
//@Composable
//fun SplashScreen() {
//    Box(
//        modifier = Modifier.fillMaxHeight().fillMaxWidth()
////            .size(width = 375.dp, height = 811.dp)
////            .offset(x = 1.dp, y = 0.dp)
//
//
//    ) {
//        // Background image
//        Image(
//            painter = painterResource(id = R.drawable.status_bar), // your drawable name
//            contentDescription = "Status Bar",
//            modifier = Modifier
//                .size(width = 375.dp, height = 36.dp)
//                .align(Alignment.TopCenter), // place at the top center
//            contentScale = ContentScale.Fit
//        )
//        Image(
//            painter = painterResource(id = R.drawable.bg),
//            contentDescription = "Background",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier.fillMaxSize()
//        )
//
//        // Logo image in the center
//        Image(
//            painter = painterResource(id = R.drawable.logo),
//            contentDescription = "App Logo",
//            modifier = Modifier
//                .size(width = 385.dp, height = 385.dp)
//                .offset(x = (0).dp, y = 344.dp),
//            contentScale = ContentScale.Fit
//        )
//
//        Image(
//            painter = painterResource(id = R.drawable.animationrectangle),
//            contentDescription = "Animated Rectangle",
//            modifier = Modifier
//                .size(width = 81.dp, height = 6.dp)
//                .offset(x = 147.dp, y = 636.dp)
//                .graphicsLayer {
//                    this.scaleX = scaleX
//                },
//            contentScale = ContentScale.Fit
//        )
//
//        Image(
//            painter = painterResource(id = R.drawable.rectangle),
//            contentDescription = "Rectangle Indicator",
//            modifier = Modifier
//                .size(width = 52.dp, height = 6.dp)
//                .offset(x = 147.dp, y = 636.dp),
//            contentScale = ContentScale.Fit
//        )
//
//    }
////    Box(
////        modifier = Modifier
////            .size(width = 637.23.dp, height = 922.80.dp)
////            .offset(x = 20.dp, y = (-2).dp)
////
////    ) {
//        // Heart 2
//        Image(
//            painter = painterResource(id = R.drawable.heart2),
//            contentDescription = "Heart 2",
//            modifier = Modifier
//                .size(width = 300.dp, height = 246.dp)
//                .offset(x = 148.dp, y = 60.dp)
//                .border(1.5.dp, Color.White, shape = RoundedCornerShape(3.dp))
//        )
//
//        // Heart 1
//        Image(
//            painter = painterResource(id = R.drawable.heart1),
//            contentDescription = "Heart 1",
//            modifier = Modifier
//                .size(width = 80.dp, height = 66.dp)
//                .offset(x = 50.dp, y = 110.dp)
//                .border(1.5.dp, Color.White, shape = RoundedCornerShape(3.dp))
//        )
//
//        // Heart 3
//        Image(
//            painter = painterResource(id = R.drawable.heart3),
//            contentDescription = "Heart 3",
//            modifier = Modifier
//                .size(width = 200.dp, height = 164.29.dp)
//                .offset(x = (-60).dp, y = 213.dp)
//                .border(1.5.dp, Color.White, shape = RoundedCornerShape(3.dp))
//        )
//
//        // Heart 4
//        Image(
//            painter = painterResource(id = R.drawable.heart4),
//            contentDescription = "Heart 4",
//            modifier = Modifier
//                .size(width = 230.dp, height = 197.dp)
//                .offset(x = 160.dp, y = 660.dp)
//                .border(1.5.dp, Color.White, shape = RoundedCornerShape(3.dp))
//        )
//    }
//
//
//

@Preview(showBackground = true)
@Composable
fun SplashScreen() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val screenWidth = maxWidth
        val screenHeight = maxHeight

        // ✅ Logo centered
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(
                    width = screenWidth * 1f, // 100% width (or use 0.5f for 50%)
                    height = screenHeight * 0.45f // 45% of screen height
                )
                .offset(y = screenHeight * 0.42f)
                .align(Alignment.TopCenter),
            contentScale = ContentScale.Fit
        )

        // ✅ Status bar
        Image(
            painter = painterResource(id = R.drawable.status_bar),
            contentDescription = "Status Bar",
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight * 0.045f)
                .align(Alignment.TopCenter),
            contentScale = ContentScale.FillBounds
        )

        // ✅ Rectangle Indicators
        Image(
            painter = painterResource(id = R.drawable.animationrectangle),
            contentDescription = "Animated Rectangle",
            modifier = Modifier
                .size(screenWidth * 0.22f, screenHeight * 0.007f)
                .offset(x = screenWidth * 0.39f, y = screenHeight * 0.79f)
                .graphicsLayer {
                    this.scaleX = scaleX
                },
            contentScale = ContentScale.Fit
        )

        Image(
            painter = painterResource(id = R.drawable.rectangle),
            contentDescription = "Rectangle Indicator",
            modifier = Modifier
                .size(screenWidth * 0.14f, screenHeight * 0.007f)
                .offset(x = screenWidth * 0.39f, y = screenHeight * 0.79f),
            contentScale = ContentScale.Fit
        )

        // ✅ Hearts — scaled and positioned using screen dimensions
        Image(
            painter = painterResource(id = R.drawable.heart2),
            contentDescription = "Heart 2",
            modifier = Modifier
                .size(screenWidth * 0.8f, screenHeight * 0.3f)
                .offset(x = screenWidth * 0.38f, y = screenHeight * 0.07f)
        )

        Image(
            painter = painterResource(id = R.drawable.heart1),
            contentDescription = "Heart 1",
            modifier = Modifier
                .size(screenWidth * 0.22f, screenHeight * 0.09f)
                .offset(x = screenWidth * 0.13f, y = screenHeight * 0.14f)
        )

        Image(
            painter = painterResource(id = R.drawable.heart3),
            contentDescription = "Heart 3",
            modifier = Modifier
                .size(screenWidth * 0.53f, screenHeight * 0.22f)
                .offset(x = screenWidth * -0.15f, y = screenHeight * 0.26f)
        )

        Image(
            painter = painterResource(id = R.drawable.heart4),
            contentDescription = "Heart 4",
            modifier = Modifier
                .size(screenWidth * 0.6f, screenHeight * 0.24f)
                .offset(x = screenWidth * 0.43f, y = screenHeight * 0.81f)
        )
    }
}
