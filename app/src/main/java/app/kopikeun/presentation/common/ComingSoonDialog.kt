package app.kopikeun.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ComingSoonDialog(
    dialogShown: Boolean,
    onDialogShownChange: (Boolean) -> Unit,
) {
    AlertDialog(
        shape = RoundedCornerShape(size = 8.dp),
        onDismissRequest = { onDialogShownChange(false) },
        title = {
            Text(text = "Informasi")
        },
        text = {
            Text(text = "Fitur ini akan segera hadir!")
        },
        buttons = {
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        end = 16.dp,
                        bottom = 8.dp,
                    ),
            ) {
                TextButton(
                    onClick = { onDialogShownChange(false) },
                    content = { Text(text = "OK") }
                )
            }
        }
    )
}