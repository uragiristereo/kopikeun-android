package app.kopikeun.presentation.dashboard.cafes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.kopikeun.R
import app.kopikeun.domain.entity.cafe.Cafe
import coil.compose.rememberImagePainter

@Composable
fun DashboardCafeItem(
    cafe: Cafe,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = RoundedCornerShape(size = 16.dp),
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.clickable { onClick() },
        ) {
            Image(
                painter =
                    if (cafe.photo == null)
                        painterResource(id = R.drawable.cafe)
                    else
                        rememberImagePainter(
                            data = cafe.photo.photoUrl,
                            builder = {
                                crossfade(200)
                            }
                        ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .clip(RoundedCornerShape(size = 16.dp))
                    .background(Color(0xFF212121).copy(alpha = 0.08f)),
            )

            Text(
                text = cafe.name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(
                    vertical = 4.dp,
                    horizontal = 16.dp,
                ),
            )
        }
    }
}