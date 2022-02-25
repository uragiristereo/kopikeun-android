package app.kopikeun.presentation.dashboard.core

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.kopikeun.presentation.main.Screen

@Composable
fun DashboardSearch(
    onNavigate: (Screen) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .clickable { onNavigate(Screen.Cafe) }
            .padding(horizontal = 16.dp),
    ) {
        Text(
            text = "Cari kafe menarik hanya di Kopikeun",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.weight(weight = 1f, fill = true),
        )

        IconButton(
            onClick = { onNavigate(Screen.Search) },
            modifier = Modifier.padding(vertical = 8.dp),
            content = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                )
            },
        )
    }
}