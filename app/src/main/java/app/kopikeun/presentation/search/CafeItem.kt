package app.kopikeun.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.kopikeun.R
import app.kopikeun.domain.entity.cafe.Cafe
import coil.compose.rememberImagePainter

@Composable
fun CafeItem(
    item: Cafe,
    onClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(
                    top = 16.dp,
                    bottom = 8.dp,
                )
                .padding(horizontal = 16.dp),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(152.dp, 114.dp)
                    .clip(shape = RoundedCornerShape(size = 16.dp))
                    .background(color = MaterialTheme.colors.primary),
            ) {
                Image(
                    painter =
                        if (item.photo == null)
                            painterResource(id = R.drawable.cafe)
                        else
                            rememberImagePainter(
                                data = item.photo.photoUrl,
                                builder = {
                                    crossfade(200)
                                }
                            ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }

            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f, true),
            ) {
                Text(
                    text = item.name,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 8.dp),
                )

                Text(
                    text = "Rating ${item.ratingDec} (${item.ratingCount})",
                    style = MaterialTheme.typography.overline,
                    color = Color.Unspecified.copy(alpha = 0.7f),
                )
            }
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )
    }
}