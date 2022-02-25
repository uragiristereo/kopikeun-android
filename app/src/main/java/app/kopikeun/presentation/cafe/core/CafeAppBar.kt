package app.kopikeun.presentation.cafe.core

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import app.kopikeun.R

@Composable
fun CafeAppBar(
    elevation: Dp,
    onNavigateBack: () -> Unit,
    onInfoClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        TopAppBar(
            elevation = elevation,
            backgroundColor = Color.White,
            title = { },
            navigationIcon = {
                IconButton(
                    onClick = onNavigateBack,
                    content = {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    },
                )
            },
            actions = {
                IconButton(
                    onClick = onInfoClick,
                    content = {
                        Icon(painterResource(id = R.drawable.contact_phone), contentDescription = null)
                    },
                )
            }
        )
    }
}