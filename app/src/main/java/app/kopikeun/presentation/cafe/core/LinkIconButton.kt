package app.kopikeun.presentation.cafe.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun LinkIconButton(
    text: String,
    icon: Painter,
    onClick: () -> Unit,
) {
    TextButton(
        onClick = onClick,
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier
                .padding(end = 8.dp)
                .size(16.dp),
        )

        Text(
            text = text,
        )
    }
}