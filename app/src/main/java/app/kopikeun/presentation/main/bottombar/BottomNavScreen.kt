package app.kopikeun.presentation.main.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavScreen(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
) {
    Dashboard("dashboard", Icons.Filled.Home, Icons.Outlined.Home),
    Search("search", Icons.Filled.Search, Icons.Outlined.Search),
    Account("account", Icons.Filled.Person, Icons.Outlined.Person),
}