package com.dating.datexapp.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dating.datexapp.R
import com.dating.datexapp.ui.common.IconButtonBox
import com.dating.datexapp.ui.common.StatusBar


@Composable
fun FullCardScreen(
    onMainImageClick: () -> Unit,
    onBackClick: () -> Unit,
    onBottomHeartClick: () -> Unit,
    onChatClick: () -> Unit,
    onProfileClick: () -> Unit,
    onLikeClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
            Image(
                painter = painterResource(id = R.drawable.ca_main_image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(800.dp)
            )
        StatusBarChat()
            IconButtonBox(
            iconResId = R.drawable.back_arrow,
            contentDescription = "Back",
            onClick = {onBackClick()},
            modifier = Modifier.offset(y = 48.dp, x = 16.dp),
            tint = Color.White
        )

        // Scrollable Content in Card
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(200.dp))

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .offset(y = (-55).dp)
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.White,
                                Color.White.copy(alpha = 0.95f),

                            )
                        )
                    )
            ) {
                androidx.compose.foundation.rememberScrollState().let { scrollState ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp, vertical = 18.dp)
                            .verticalScroll(scrollState)
                    ) {
                        Spacer(modifier = Modifier.height(8.dp))
                        ProfileCardContent(onChatClick)
                        Spacer(modifier = Modifier.height(8.dp))
                        ActionButtons(onBottomHeartClick)

                    }
                }
            }
        }

        // Story Frames Row (bottom)
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.White)
                .height(55.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            StoryFrame(R.drawable.ca_btm_img1, Color.Transparent, true, modifier = Modifier.clickable{onBackClick()})
            StoryFrame(R.drawable.ca_btm_img2, Color.Transparent, modifier = Modifier.clickable{onBottomHeartClick()})
            StoryFrame(R.drawable.ca_btm_img3, Color.Transparent, modifier = Modifier.clickable{onChatClick()})
            StoryFrame(R.drawable.ca_btm_img4, Color.Transparent, modifier = Modifier.clickable{onProfileClick()})
        }
    }
}


@Composable
fun ProfileCardContent(
    onChatClick: () -> Unit
) {
    Column(modifier = Modifier.padding(horizontal = 4.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Kalvin, 23",
                style = MaterialTheme.typography.headlineMedium,
                fontSize = 32.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            // Ellipse with message_logo
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .clickable { onChatClick() }
                    .background(Color(0xFFF64F8B)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.message_logo),
                    contentDescription = "Message Icon",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Malibu • 20 kms away",
            style = MaterialTheme.typography.bodySmall,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "About me",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "A listener to your anecdotes, a friend to rely\n" +
                    "on, a witty one to ensure doses of laughter,\n" +
                    "& a person to respect your comfort zone.",
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "My basics",
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))

        ProfileTagWrap(
            tags = listOf(
                "In college" to R.drawable.education,
                "Hindu" to R.drawable.religion,
                "Often" to R.drawable.workout,
                "Never" to R.drawable.smoking,
                "Socially" to R.drawable.drinking
            )
        )




        Spacer(modifier = Modifier.height(16.dp))

        Text("Interests", fontWeight = FontWeight.Bold)
        FlowRow {
            InterestChip2("Travel", isSelected = true)
            InterestChip2("Sports", isSelected = true)
            InterestChip2("Party", isSelected = false)
            InterestChip2("Shopping", isSelected = false)
            InterestChip2("Music", isSelected = false)
            InterestChip2("Dancing", isSelected = true)
        }


        Spacer(modifier = Modifier.height(12.dp))

        // Grid of Photos
        ProfileImageGrid(
            imageResList = listOf(
                R.drawable.aiv_img2,
                R.drawable.fcv_img1,
                R.drawable.aiv_img3,
                R.drawable.aiv_img1,
                R.drawable.aiv_img4,
                R.drawable.fcv_img3,
                R.drawable.aiv_img1,
                R.drawable.fcv_img2,
                R.drawable.fcv_img3,
            )
        )


        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Leslie’s location",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "San Francisco, California",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Verification",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            VerifiedProfilePhoto()
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Verified by Photo",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text("Block and Report", color = Color.Gray, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(16.dp)) // Important to give space

    }
}

@Composable
fun VerifiedProfilePhoto() {
    Box(
        modifier = Modifier
            .size(44.78.dp)
            .clip(RoundedCornerShape(6.47.dp))
    ) {
        // Main profile image
        Image(
            painter = painterResource(id = R.drawable.aiv_img1),
            contentDescription = "Profile Photo",
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(24.dp)),
            contentScale = ContentScale.Crop
        )

        // Verified badge on top-end corner
        Image(
            painter = painterResource(id = R.drawable.verified),
            contentDescription = "Verified Badge",
            modifier = Modifier
                .size(16.dp)
                .align(Alignment.TopEnd)
                .offset(x = 2.dp, y = (-2).dp)
        )
    }
}


@Composable
fun ProfileTagWrap(
    tags: List<Pair<String, Int>>,
    selectedTags: List<String> = listOf("Hindu", "Never")
) {
    FlowRow {
        tags.forEach { (label, iconResId) ->
            Box(modifier = Modifier.padding(end = 8.dp, bottom = 8.dp)) {
                ProfileTag(
                    text = label,
                    iconResId = iconResId,
                    isSelected = selectedTags.contains(label)
                )
            }
        }
    }
}



@Composable
fun ActionButtons(
    onLikeClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Dislike Button
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.White)
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.cross),
                contentDescription = "Dislike",
                modifier = Modifier.size(16.dp)
            )
        }
        // Like Button
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(Color(0xFFF64F8B))
                .clickable{onLikeClick}
                .padding(20.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.like),
                contentDescription = "Like",
                modifier = Modifier.size(40.dp)
            )
        }

        // Star Button
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color(0xFFF8CE61))
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "Star",
                modifier = Modifier.size(30.dp)
            )
        }
    }
}



@Composable
fun ProfileTag(
    text: String,
    iconResId: Int,
    isSelected: Boolean
) {
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFFF64F8B), Color(0xFFF8CE61))
    )

    val borderColor = Color(0xFFF64F8B)

    Box(
        modifier = Modifier
            .background(
                brush = if (isSelected) gradient else Brush.linearGradient(listOf(Color.White, Color.White)),
                shape = RoundedCornerShape(20.dp)
            )
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = text,
                colorFilter = if (isSelected) ColorFilter.tint(Color.White) else ColorFilter.tint(Color.Black),
                modifier = Modifier
                    .size(16.dp)
                    .padding(end = 4.dp)
            )
            Text(
                text = text,
                color = if (isSelected) Color.White else Color.Black,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileImageGrid(
    imageResList: List<Int>,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(imageResList.size) { index ->
            Image(
                painter = painterResource(id = imageResList[index]),
                contentDescription = "Profile Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }
}

@Composable
fun InterestChip2(
    text: String,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    val gradient = Brush.verticalGradient(
        colors = listOf(Color(0xFFF64F8B), Color(0xFFF8CE61))
    )

    Box(
        modifier = modifier
            .padding(end = 8.dp, bottom = 8.dp)
            .then(
                if (isSelected) {
                    Modifier
                        .background(gradient, shape = RoundedCornerShape(50))
                } else {
                    Modifier
                        .background(Color.White, shape = RoundedCornerShape(50))
                }
            )
            .border(
                width = 1.dp,
                brush = if (isSelected) gradient else SolidColor(Color.Gray),
                shape = RoundedCornerShape(50)
            )
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            color = if (isSelected) Color.White else Color.Black
        )
    }
}



@Preview(showBackground = true)
@Composable
fun FullCardScreenPreview() {
    FullCardScreen(
        onMainImageClick = {},
        onBackClick = {},
        onBottomHeartClick = {},
        onChatClick = {},
        onProfileClick = {},
        onLikeClick = {}
    )
}



