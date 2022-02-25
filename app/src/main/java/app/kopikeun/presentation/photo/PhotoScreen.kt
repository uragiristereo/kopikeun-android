package app.kopikeun.presentation.photo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import app.kopikeun.presentation.main.MainViewModel
import coil.load
import com.ortiz.touchview.TouchImageView

@Composable
fun PhotoScreen(
    onBackPressed: () -> Unit,
    mainViewModel: MainViewModel,
) {
    val context = LocalContext.current
    val imageViewer = remember { TouchImageView(context) }

    DisposableEffect(key1 = Unit) {
        imageViewer.apply {
            maxZoom = 4f
            doubleTapScale = 2f

            load(
                uri = mainViewModel.selectedPhotoUrl,
                builder = {
                    crossfade(200)
                }
            )
        }

        onDispose {  }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            CircularProgressIndicator(color = MaterialTheme.colors.primaryVariant)
        }

        AndroidView(
            factory = { imageViewer },
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
        )
        
        TopAppBar(
            backgroundColor = Color.Transparent,
            contentColor = Color.White,
            elevation = 0.dp,
            navigationIcon = {
                IconButton(
                    onClick = onBackPressed,
                    content = { Icon(Icons.Default.ArrowBack, null) }
                )
            },
            title = { },
            modifier = Modifier.fillMaxWidth(),
        )
    }
}