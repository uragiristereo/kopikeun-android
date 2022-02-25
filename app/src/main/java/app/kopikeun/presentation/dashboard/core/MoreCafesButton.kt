package app.kopikeun.presentation.dashboard.core

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun MoreCafeButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Button(
        enabled = enabled,
        shape = RoundedCornerShape(percent = 50),
        border = BorderStroke(width = 1.dp, color = Color(0xFF79747E)),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = MaterialTheme.colors.primaryVariant,
        ),
        onClick = onClick,
        modifier = modifier
            .padding(start = 8.dp),
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 8.dp),
        )
    }
}