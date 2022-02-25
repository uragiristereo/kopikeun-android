package app.kopikeun.presentation.cafe.core

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.kopikeun.domain.entity.cafe.CafeDetail

@Composable
fun CafePhotoCard(
    cafe: CafeDetail,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(size = 16.dp))
            .background(color = Color(0xFFFAFAFA))
            .clickable { onClick() },
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
        ) {
            Column {
                Text(
                    text = "Cek foto dan review kafe ini",
                    modifier = Modifier.padding(bottom = 4.dp),
                )

                Text(
                    text = "${cafe.photos.size} foto & ${cafe.ratingCount} review",
                    style = MaterialTheme.typography.overline,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.primary,
                )
            }

            IconButton(
                onClick = onClick,
                content = {
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
                }
            )
        }
    }
}