package app.kopikeun.presentation.cafe

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import app.kopikeun.R
import app.kopikeun.domain.entity.Menu
import app.kopikeun.domain.entity.Photo
import app.kopikeun.presentation.cafe.core.*
import app.kopikeun.presentation.cafe.menu.MenuItemGrid
import app.kopikeun.presentation.main.MainViewModel
import app.kopikeun.presentation.main.Screen
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun CafeScreen(
    cafeId: Int,
    onNavigate: (Screen) -> Unit,
    onBackPressed: () -> Unit,
    mainViewModel: MainViewModel,
    cafeViewModel: CafeViewModel = hiltViewModel(),
) {
    val state = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    DisposableEffect(key1 = Unit) {
        cafeViewModel.getCafeDetail(cafeId)

        onDispose {  }
    }

    ModalBottomSheetLayout(
        sheetState = state,
        sheetShape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp,
        ),
        scrimColor = Color(color = 0xFF121212).copy(alpha = DrawerDefaults.ScrimOpacity),
        sheetContent = {
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .width(48.dp)
                            .height(4.dp)
                            .clip(RoundedCornerShape(percent = 50))
                            .background(Color(0xFF212121).copy(alpha = 0.2f)),
                    )
                }

                Text(
                    text = "Kontak Cafe",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 6.dp),
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 16.dp,
                            vertical = 4.dp,
                        ),
                ) {
                    Text(
                        text = "WhatsApp",
                        modifier = Modifier.weight(3f),
                    )

                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier.weight(7f, fill = true),
                    ) {
                        Text(
                            text = cafeViewModel.cafeDetail?.contact?.whatsapp ?: "-",
                            textAlign = TextAlign.End,
                        )

                        if (cafeViewModel.cafeDetail?.contact?.whatsapp ?: "-" != "-") {
                            LinkIconButton(
                                text = "Chat",
                                icon = painterResource(id = R.drawable.whatsapp),
                                onClick = {
                                    scope.launch {
                                        state.hide()

                                        val intent = Intent(Intent.ACTION_VIEW)
                                        val url =
                                            "https://api.whatsapp.com/send?phone=${cafeViewModel.cafeDetail?.contact?.whatsapp}"

                                        with(intent) {
                                            setPackage("com.whatsapp")
                                            data = Uri.parse(url)
                                        }

                                        try {
                                            context.startActivity(intent)
                                        } catch (t: Throwable) {
                                            Toast.makeText(
                                                context,
                                                "Error:\n${t}",
                                                Toast.LENGTH_LONG
                                            ).show()
                                        }
                                    }
                                }
                            )
                        }
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 16.dp,
                            vertical = 4.dp,
                        ),
                ) {
                    Text(
                        text = "Website",
                        modifier = Modifier.weight(3f),
                    )

                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier.weight(7f, fill = true),
                    ) {
                        Text(
                            text = cafeViewModel.cafeDetail?.contact?.website ?: "-",
                            textAlign = TextAlign.End,
                        )

                        if (cafeViewModel.cafeDetail?.contact?.website ?: "-" != "-") {
                            LinkIconButton(
                                text = "Kunjungi",
                                icon = painterResource(id = R.drawable.open_in_new),
                                onClick = {
                                    scope.launch {
                                        state.hide()

                                        val intent = Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse(
                                                cafeViewModel.cafeDetail?.contact?.website ?: "-"
                                            )
                                        )
                                        context.startActivity(intent)
                                    }
                                }
                            )
                        }
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 16.dp,
                            vertical = 4.dp,
                        ),
                ) {
                    Text(
                        text = "Alamat",
                        modifier = Modifier.weight(3f),
                    )

                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier.weight(7f, fill = true),
                    ) {
                        Text(
                            text = cafeViewModel.cafeDetail?.contact?.address ?: "-",
                            textAlign = TextAlign.End,
                        )

                        if (cafeViewModel.cafeDetail?.contact?.address ?: "-" != "-") {
                            LinkIconButton(
                                text = "Lihat",
                                icon = painterResource(id = R.drawable.gmaps),
                                onClick = {
                                    scope.launch {
                                        state.hide()

                                        val intent = Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse(
                                                cafeViewModel.cafeDetail?.contact?.gmaps ?: "-"
                                            )
                                        )
                                        context.startActivity(intent)
                                    }
                                }
                            )
                        }
                    }
                }
            }
        },
        modifier = Modifier.fillMaxSize(),
    ) {
        Scaffold(
            topBar = {
                CafeAppBar(
                    elevation = 0.dp,
                    onNavigateBack = onBackPressed,
                    onInfoClick = {
                        scope.launch { state.animateTo(ModalBottomSheetValue.Expanded) }
                    },
                    modifier = Modifier
                        .background(Color.White),
                )
            },
            modifier = Modifier.fillMaxSize(),
        ) { innerPadding ->
            if (cafeViewModel.progress) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 16.dp),
                ) {
                    CircularProgressIndicator(color = MaterialTheme.colors.primaryVariant)
                }
            }

            if (cafeViewModel.error.isNotEmpty()) {
                Text(cafeViewModel.error)
            }
            cafeViewModel.cafeDetail?.let { cafeDetail ->
                LazyColumn(
                    contentPadding = innerPadding,
                ) {
                    item {
                        val photo: Photo? =
                            if (cafeDetail.photos.isNotEmpty())
                                cafeDetail.photos[0]
                            else
                                null

                        CafePhoto(
                            photo = photo,
                            onClick = {
                                mainViewModel.setSelectedPhotos(cafeDetail.photos)
                                onNavigate(Screen.PhotoList)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    top = 16.dp,
                                    bottom = 8.dp,
                                    start = 16.dp,
                                    end = 16.dp,
                                ),
                        )
                    }

                    item {
                        CafeHeader(
                            cafe = cafeDetail,
                            onInstagramClick = {
                                val username = cafeViewModel.cafeDetail?.contact?.instagram ?: "-"
                                val intent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(
                                        "https://instagram.com/$username"
                                    )
                                )
                                context.startActivity(intent)
                            },
                            modifier = Modifier.padding(
                                vertical = 8.dp,
                                horizontal = 16.dp,
                            ),
                        )
                    }

                    item {
                        CafePhotoCard(
                            cafe = cafeDetail,
                            onClick = {
                                mainViewModel.setSelectedPhotos(cafeDetail.photos)
                                onNavigate(Screen.PhotoList)
                            },
                            modifier = Modifier.padding(
                                vertical = 8.dp,
                                horizontal = 16.dp,
                            ),
                        )
                    }

                    item {
                        Text(
                            text = "Menu",
                            style = MaterialTheme.typography.h5,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFE5E5E5))
                                .padding(horizontal = 16.dp)
                                .padding(
                                    top = 8.dp,
                                    bottom = 4.dp,
                                ),
                        )
                    }

                    itemsIndexed(cafeDetail.menus) { index, item ->
                        val secondItem: Menu? =
                            if (index + 1 != cafeDetail.menus.size)
                                cafeDetail.menus[index + 1]
                            else
                                null

                        if (index % 2 == 0) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color(0xFFE5E5E5))
                                    .padding(
                                        start = 16.dp,
                                        bottom = 16.dp,
                                    )
                            ) {

                                MenuItemGrid(
                                    menu = item,
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 16.dp),
                                )

                                if (secondItem != null) {
                                    MenuItemGrid(
                                        menu = cafeDetail.menus[index + 1],
                                        onClick = { /*TODO*/ },
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(end = 16.dp),
                                    )
                                } else {
                                    Box(modifier = Modifier.weight(1f))
                                }
                            }
                        }

                    }
                }
            }
        }
    }
}