package app.kopikeun.presentation.dashboard.shortcut

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ShortcutButton(
    onClick: () -> Unit,
    text: String,
    icon: ImageVector,
) {
    Surface(
        contentColor = MaterialTheme.colors.onSurface.copy(alpha = 0.5f),
        modifier = Modifier
            .padding(all = 8.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(all = 8.dp),
        ) {
            Surface(
                shape = RoundedCornerShape(size = 16.dp),
                border = BorderStroke(1.dp, MaterialTheme.colors.onSurface.copy(alpha = 0.5f)),
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = text,
                    tint = MaterialTheme.colors.onSurface.copy(alpha = 0.5f),
                    modifier = Modifier
                        .clickable { onClick() }
                        .padding(24.dp),
                )
            }

            Text(
                text = text,
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun ShortcutButton(
    onClick: () -> Unit,
    text: String,
    icon: Painter,
    modifier: Modifier = Modifier,
) {
    Surface(
        color = Color.Transparent,
        contentColor = MaterialTheme.colors.onSurface.copy(alpha = 0.5f),
        modifier = modifier.padding(end = 8.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(all = 1.dp),
        ) {
            Surface(
                shape = RoundedCornerShape(size = 16.dp),
                border = BorderStroke(1.dp, MaterialTheme.colors.onSurface.copy(alpha = 0.1f)),
                modifier = Modifier
//                    .fillMaxWidth()
//                    .aspectRatio(1f),
            ) {
                Image(
                    painter = icon,
                    contentDescription = text,
                    modifier = Modifier
                        .clickable { onClick() }
                        .padding(all = 20.dp)
                )
            }

            Text(
                text = text,
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            )
        }
    }
}