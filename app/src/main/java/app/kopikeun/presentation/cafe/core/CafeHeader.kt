package app.kopikeun.presentation.cafe.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.kopikeun.R
import app.kopikeun.domain.entity.cafe.CafeDetail

@Composable
fun CafeHeader(
    cafe: CafeDetail,
    onInstagramClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val rating = cafe.ratingDec.toInt()

    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = cafe.name,
                style = MaterialTheme.typography.h5,
            )

            Row {
                for (i in 1..rating) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary,
                    )
                }

                for (i in 1..(5 - rating)) {
                    Icon(
                        painter = painterResource(id = R.drawable.star_border),
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary,
                    )
                }
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { onInstagramClick() }
                    .padding(all = 4.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.instagram_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .size(16.dp),
                )
                Text(
                    text = "@${cafe.contact.instagram}",
                    style = MaterialTheme.typography.overline,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                    fontSize = 16.sp,
                )
            }

            Text(
                text = "${cafe.ratingDec} (${cafe.ratingCount})",
                style = MaterialTheme.typography.overline,
                textAlign = TextAlign.End,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
                fontSize = 16.sp,
            )
        }
    }
}