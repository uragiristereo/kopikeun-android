package app.kopikeun.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import app.kopikeun.presentation.main.MainViewModel
import app.kopikeun.presentation.main.Screen
import com.google.accompanist.insets.navigationBarsWithImePadding

@ExperimentalComposeUiApi
@Composable
fun SearchScreen(
    onNavigate: (Screen) -> Unit,
    onBackPressed: () -> Unit,
    mainViewModel: MainViewModel,
    searchViewModel: SearchViewModel = hiltViewModel(),
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }

    DisposableEffect(key1 = Unit) {
        keyboardController?.show()

        onDispose {
            keyboardController?.hide()
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsWithImePadding(),
    ) {
        var query by searchViewModel.query

        SearchBox(
            query = query,
            focusRequester = focusRequester,
            onQueryChange = {
                if (it.text != query.text) {
                    if (it.text.isNotEmpty())
                        searchViewModel.searchCafe(keyword = it.text)
                    else
                        searchViewModel.clearSearches()
                }

                query = it
            },
            onBackPressed = {
                onBackPressed()
            },
            placeholder = "Cari kafe di sini",
        )

        DisposableEffect(key1 = Unit) {
            focusRequester.requestFocus()

            onDispose { }
        }

        LinearProgressIndicator(
            modifier = Modifier
                .alpha(alpha = if (searchViewModel.progressVisible) 1f else 0f)
                .fillMaxWidth(),
        )

        if (query.text.isNotEmpty()) {
            LazyColumn {
                if (searchViewModel.cafes.isNotEmpty())
                    item {
                        Text(
                            text = "Hasil pencarian",
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(
                                top = 8.dp,
                                bottom = 4.dp,
                                start = 16.dp,
                            ),
                        )
                    }

                items(searchViewModel.cafes) { item ->
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

        if (query.text.isNotEmpty() && searchViewModel.cafes.isEmpty() && !searchViewModel.progressVisible && searchViewModel.searchError.isEmpty()) {
            Text(
                text = "Kafe tidak ditemukan",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    top = 8.dp,
                    bottom = 4.dp,
                    start = 16.dp,
                ),
            )
        }

        if (searchViewModel.searchError.isNotEmpty()) {
            Text(searchViewModel.searchError)
        }
    }
}
