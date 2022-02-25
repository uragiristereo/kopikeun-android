package app.kopikeun.presentation.cafe.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.kopikeun.R
import app.kopikeun.common.NumberHelper
import app.kopikeun.domain.entity.Menu

@Composable
fun MenuItem(
    menu: Menu,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = RoundedCornerShape(size = 16.dp),
        elevation = 2.dp,
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .clickable { onClick() }
                .padding(all = 16.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.coffee_cup),
                contentDescription = null,
                modifier = Modifier
                    .size(size = 64.dp)
                    .clip(RoundedCornerShape(size = 16.dp))
                    .background(Color(0xFFE5E5E5))
                    .padding(all = 8.dp),
            )

            Column(
                modifier = Modifier.padding(start = 16.dp),
            ) {
                Text(
                    text = menu.name,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp),
                )

                Text(
                    text = "Rp. ${NumberHelper.formatThousand(menu.price)}",
                    style = MaterialTheme.typography.overline,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.primary,
                )
            }
        }
    }
}