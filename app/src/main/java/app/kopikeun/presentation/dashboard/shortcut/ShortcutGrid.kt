package app.kopikeun.presentation.dashboard.shortcut

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.kopikeun.R
import app.kopikeun.presentation.common.ComingSoonDialog
import app.kopikeun.presentation.main.Screen

@ExperimentalFoundationApi
@Composable
fun ShortcutGrid(
    onNavigate: (Screen) -> Unit,
) {
    val configuration = LocalConfiguration.current
    val width = configuration.screenWidthDp
    val count = 4
    val itemWidth = (width - ((count - 1) * 8)) / count

    var dialogShown by remember { mutableStateOf(false) }

    if (dialogShown) {
        ComingSoonDialog(
            dialogShown = dialogShown,
            onDialogShownChange = { dialogShown = it }
        )
    }

    Column(
        modifier = Modifier.padding(
            top = 8.dp,
            bottom = 8.dp,
            start = 16.dp,
            end = 8.dp,
        )
    ) {
        Text(
            text = "Navigasi".uppercase(),
            style = MaterialTheme.typography.overline,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 12.dp),
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
        ) {
            ShortcutButton(
                onClick = {
                    onNavigate(Screen.CafeList)
                },
                text = "Semua",
                icon = painterResource(id = R.drawable.all),
                modifier = Modifier.width(itemWidth.dp),
            )

            ShortcutButton(
                onClick = { dialogShown = true },
                text = "Favorit",
                icon = painterResource(id = R.drawable.star2),
                modifier = Modifier.width(itemWidth.dp),
            )

            ShortcutButton(
                onClick = { dialogShown = true },
                text = "Rating terbanyak",
                icon = painterResource(id = R.drawable.most_rated),
                modifier = Modifier.width(itemWidth.dp),
            )

            ShortcutButton(
                onClick = { dialogShown = true },
                text = "Rating terbaik",
                icon = painterResource(id = R.drawable.best_rated),
                modifier = Modifier.width(itemWidth.dp),
            )
        }

//        LazyVerticalGrid(
//            cells = GridCells.Fixed(4),
//        ) {
//            item {
//                ShortcutButton(
//                    onClick = { /*TODO*/ },
//                    text = "Semua",
//                    icon = painterResource(id = R.drawable.all),
//                )
//            }
//            item {
//                ShortcutButton(
//                    onClick = { /*TODO*/ },
//                    text = "Favorit",
//                    icon = painterResource(id = R.drawable.star2),
//                )
//            }
//            item {
//                ShortcutButton(
//                    onClick = { /*TODO*/ },
//                    text = "Rating terbanyak",
//                    icon = painterResource(id = R.drawable.most_rated),
//                )
//            }
//            item {
//                ShortcutButton(
//                    onClick = { /*TODO*/ },
//                    text = "Rating terbaik",
//                    icon = painterResource(id = R.drawable.best_rated),
//                )
//            }
//        }
    }
}