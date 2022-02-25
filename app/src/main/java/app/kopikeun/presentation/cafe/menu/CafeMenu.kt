package app.kopikeun.presentation.cafe.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.kopikeun.domain.entity.Menu

@Composable
fun CafeMenu(
    menus: List<Menu>,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFE5E5E5)),
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
        ) {
            Text(
                text = "Menu",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    top = 8.dp,
                    bottom = 4.dp,
                ),
            )

            menus.forEach { item ->
                MenuItem(
                    menu = item,
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(vertical = 8.dp),
                )
            }
        }
    }
}