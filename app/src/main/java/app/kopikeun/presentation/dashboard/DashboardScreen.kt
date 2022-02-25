package app.kopikeun.presentation.dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import app.kopikeun.presentation.common.ComingSoonDialog
import app.kopikeun.presentation.dashboard.cafes.DashboardCafeItem
import app.kopikeun.presentation.dashboard.core.DashboardAppBar
import app.kopikeun.presentation.dashboard.core.DashboardBanner
import app.kopikeun.presentation.dashboard.core.DashboardSearch2
import app.kopikeun.presentation.dashboard.shortcut.ShortcutGrid
import app.kopikeun.presentation.main.MainViewModel
import app.kopikeun.presentation.main.Screen

@ExperimentalFoundationApi
@Composable
fun DashboardScreen(
    mainViewModel: MainViewModel,
    dashboardViewModel: DashboardViewModel = hiltViewModel(),
    onNavigate: (Screen) -> Unit,
) {
    var dialogShown by remember { mutableStateOf(false) }

    if (dialogShown) {
        ComingSoonDialog(
            dialogShown = dialogShown,
            onDialogShownChange = { dialogShown = it }
        )
    }

    Scaffold(
        topBar = {
            DashboardAppBar(elevation = 0.dp)
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.primary.copy(alpha = 0.05f)),
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp)
                        .background(Color.White)
                        .clip(
                            RoundedCornerShape(
                                topStart = 16.dp,
                                topEnd = 16.dp,
                            )
                        )
                        .background(MaterialTheme.colors.primary.copy(alpha = 0.05f)),
                )
            }

            item {
                DashboardSearch2(onNavigate = onNavigate)
            }

            item {
                DashboardBanner(
                    onClick = {
                        dialogShown = true
                    },
                )
            }

            item {
                ShortcutGrid(
                    onNavigate = onNavigate,
                )
            }

            item {
                Text(
                    text = "Daftar cafe".uppercase(),
                    style = MaterialTheme.typography.overline,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(
                            top = 12.dp,
                            bottom = 4.dp,
                        ),
                )
            }

            if (dashboardViewModel.loading) {
                item {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 16.dp),
                    ) {
                        CircularProgressIndicator(color = MaterialTheme.colors.primaryVariant)
                    }
                }
            }

            if (dashboardViewModel.cafeList.size == 4) {
                itemsIndexed(dashboardViewModel.cafeList) { index, item ->
                    if (index % 2 == 0) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp)
                                .padding(vertical = 8.dp),
                        ) {
                            DashboardCafeItem(
                                cafe = item,
                                onClick = {
                                    mainViewModel.setSelectedCafe(item.id)
                                    onNavigate(Screen.Cafe)
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 16.dp),
                            )

                            DashboardCafeItem(
                                cafe = dashboardViewModel.cafeList[index + 1],
                                onClick = {
                                    mainViewModel.setSelectedCafe(dashboardViewModel.cafeList[index + 1].id)
                                    onNavigate(Screen.Cafe)
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 16.dp),
                            )
                        }
                    }
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 8.dp),
                ) {
                    TextButton(
                        onClick = {
                              onNavigate(Screen.CafeList)
                        },
                    ) {
                        Text(text = "Lihat semua")
                    }
                }
            }
        }
    }
}