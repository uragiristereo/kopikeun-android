package app.kopikeun.presentation.cafelist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import app.kopikeun.presentation.main.MainViewModel
import app.kopikeun.presentation.main.Screen
import app.kopikeun.presentation.search.CafeItem


@Composable
fun CafeListScreen(
    onNavigate: (Screen) -> Unit,
    onBackPressed: () -> Unit,
    mainViewModel: MainViewModel,
    cafeListViewModel: CafeListViewModel = hiltViewModel(),
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Semua Cafe") },
                backgroundColor = Color.White,
                contentColor = Color.Black,
                navigationIcon = {
                    IconButton(
                        onClick = onBackPressed,
                        content = {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                        },
                    )
                }
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.primary.copy(alpha = 0.05f)),
        ) {
            if (cafeListViewModel.loading) {
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

            items(cafeListViewModel.cafeList) { item ->
                CafeItem(
                    item = item,
                    onClick = {
                        mainViewModel.setSelectedCafe(item.id)
                        onNavigate(Screen.Cafe)
                    }
                )
            }
        }
    }
}