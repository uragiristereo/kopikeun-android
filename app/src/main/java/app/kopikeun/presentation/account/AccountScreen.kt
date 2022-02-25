package app.kopikeun.presentation.account

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun AccountScreen() {
    LazyColumn {
        items(100) { item ->
            Text("account $item")
        }
    }
}