package app.kopikeun.presentation.dashboard.core

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import app.kopikeun.presentation.main.Screen

@Composable
fun DashboardSearch2(
    onNavigate: (Screen) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
            .clip(RoundedCornerShape(size = 8.dp))
            .clickable { onNavigate(Screen.Search) }
            .background(color = MaterialTheme.colors.onSurface.copy(0.1f)),
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null,
            modifier = Modifier
                .padding(
                    vertical = 12.dp,
                    horizontal = 12.dp,
                )
                .size(32.dp),
        )

        Text(
            text = "Cari kafe menarik...",
            color = MaterialTheme.colors.onSurface.copy(0.9f),
        )
    }
}