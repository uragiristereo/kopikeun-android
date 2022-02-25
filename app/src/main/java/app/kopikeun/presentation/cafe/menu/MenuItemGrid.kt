package app.kopikeun.presentation.cafe.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.kopikeun.R
import app.kopikeun.common.NumberHelper
import app.kopikeun.domain.entity.Menu

@Composable
fun MenuItemGrid(
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
        Column(
            modifier = Modifier.clickable { onClick() },
        ) {
            Image(
                painter = painterResource(id = R.drawable.coffee_cup),
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(size = 16.dp))
                    .background(MaterialTheme.colors.primary.copy(0.1f))
                    .padding(all = 24.dp),
            )

            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
            ) {
                Text(
                    text = menu.name,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp),
                )

                Text(
                    text = "Rp. ${NumberHelper.formatThousand(menu.price)}",
                    style = MaterialTheme.typography.overline,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                )
            }
        }
    }
}