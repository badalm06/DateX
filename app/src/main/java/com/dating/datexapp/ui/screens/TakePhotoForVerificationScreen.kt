import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
fun TakePhotoForVerificationScreen(
    onTakePhotoClick: () -> Unit = {},
    onCloseClick: () -> Unit = {},
    onSupportClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFCF8))
    ) {
        // Top StatusBar
        StatusBar()

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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(124.dp))

            // Sample Image with rounded corners
            Box {
                Image(
                    painter = painterResource(id = R.drawable.asp_img1),
                    contentDescription = "Pose Sample",
                    modifier = Modifier
                        .size(width = 132.dp, height = 175.dp)
                        .clip(RoundedCornerShape(12.5.dp)),
                    contentScale = ContentScale.Crop
                )

                // Verified Icon
                Image(
                    painter = painterResource(id = R.drawable.ic_verified),
                    contentDescription = "Verified Icon",
                    modifier = Modifier
                        .size(width = 21.8.dp, height = 24.dp)
                        .offset(x = 102.95.dp, y = 143.dp) // relative to image box
                        .align(Alignment.TopStart)
                )
            }

            // Content Group
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
            ) {
                Text(
                    text = "Copy this pose and take\na photo.",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "We’ll verify you by comparing  it with other photos\nalready on your dream friend profile.",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    textAlign = TextAlign.Start
                )
            }

            Spacer(modifier = Modifier.height(36.dp))

            // Button
            GradientButton(
                text = "Take My Photo",
                onClick = onTakePhotoClick,
                modifier = Modifier
                    .width(325.dp)
                    .height(58.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            // Bottom info text
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "This photo won’t be uploaded to your profile. It’ll only\nbe used to verify you and help keep you safe.",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    lineHeight = 22.sp,
                    color = Color(0x80161616),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Contact Support",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    lineHeight = 22.sp,
                    color = Color(0x80161616),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TakePhotoForVerificationScreenPreview() {
    TakePhotoForVerificationScreen()
}
