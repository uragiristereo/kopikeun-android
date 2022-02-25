package app.kopikeun.presentation.cafe.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import app.kopikeun.R
import app.kopikeun.domain.entity.Photo
import coil.compose.rememberImagePainter

@Composable
fun CafePhoto(
    photo: Photo?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Image(
        painter =
            if (photo == null)
                painterResource(id = R.drawable.cafe)
            else
                rememberImagePainter(
                    data = photo.photoUrl,
                    builder = {
                        crossfade(200)
                    }
                ),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .aspectRatio(16f / 9f)
            .clip(RoundedCornerShape(size = 16.dp))
            .background(Color(0xFF212121).copy(alpha = 0.08f))
            .clickable { onClick() },
    )
}