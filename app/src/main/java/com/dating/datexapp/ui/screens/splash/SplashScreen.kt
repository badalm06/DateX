package com.dating.datexapp.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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


@Composable
fun SplashScreen(onNavigateNext: () -> Unit) {
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(2000) // 2-second splash delay
        onNavigateNext() // Navigate to next screen
    }
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

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(onNavigateNext = {})
}