package app.kopikeun.presentation.dashboard.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import app.kopikeun.R

@Composable
fun DashboardBanner(
    onClick: () -> Unit,
) {
    Image(
        painter = painterResource(id = R.drawable.cafe_banner),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
//            .height(100.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(size = 16.dp))
            .background(color = MaterialTheme.colors.secondary)
            .clickable { onClick() },
    )
}