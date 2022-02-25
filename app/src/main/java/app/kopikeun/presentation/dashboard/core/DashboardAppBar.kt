package app.kopikeun.presentation.dashboard.core

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp

@Composable
fun DashboardAppBar(
    elevation: Dp,
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.background,
        elevation = elevation,
        content = {
            Text(
                text = "Kopikeun",
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    )
}