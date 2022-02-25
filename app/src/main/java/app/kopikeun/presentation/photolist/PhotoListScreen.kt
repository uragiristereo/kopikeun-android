package app.kopikeun.presentation.photolist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import app.kopikeun.presentation.main.MainViewModel
import app.kopikeun.presentation.main.Screen
import coil.compose.rememberImagePainter

@ExperimentalFoundationApi
@Composable
fun PhotoListScreen(
    onNavigate: (Screen) -> Unit,
    onBackPressed: () -> Unit,
    mainViewModel: MainViewModel,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = { Text(text = "Daftar Foto") },
                navigationIcon = {
                    IconButton(
                        onClick = onBackPressed,
                        content = {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                        }
                    )
                }
            )
        },
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            contentPadding = PaddingValues(
                top = innerPadding.calculateTopPadding() + 2.dp,
            ),
            modifier = Modifier.fillMaxSize(),
        ) {
            items(mainViewModel.selectedPhotoList) { item ->
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillParentMaxWidth()
                        .padding(1.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0xFF212121).copy(alpha = 0.08f)),
                    )

                    Image(
                        painter = rememberImagePainter(
                            data = item.photoUrl,
                            builder = {
                                crossfade(200)
                            }
                        ),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                mainViewModel.setSelectedPhoto(item.photoUrl)

                                onNavigate(Screen.Photo)
                            },
                    )
                }
            }
        }
    }
}