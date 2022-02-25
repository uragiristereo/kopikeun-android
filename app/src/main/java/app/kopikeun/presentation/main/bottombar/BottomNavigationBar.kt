package app.kopikeun.presentation.main.bottombar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry

@Composable
fun BottomNavigationBar(
    navBackStackEntry: NavBackStackEntry?,
    onNavigate: (String) -> Unit,
) {
    Box(
        modifier = Modifier.background(MaterialTheme.colors.primary.copy(alpha = 0.2f)),
    ) {
        BottomNavigation(
//        backgroundColor = MaterialTheme.colors.background,
//        contentColor = MaterialTheme.colors.primaryVariant,
            backgroundColor = Color.Transparent,
            contentColor = MaterialTheme.colors.onSurface.copy(alpha = 0.7f),
            elevation = 0.dp,
        ) {
            val currentRoute = navBackStackEntry?.destination?.route

            val items = remember {
                listOf(
                    BottomNavScreen.Dashboard,
                    BottomNavScreen.Search,
                    BottomNavScreen.Account,
                )
            }

            items.forEach { item ->
                BottomNavigationItem(
                    selected = currentRoute == item.route,
                    label = { Text(item.route.replaceFirstChar { it.uppercase() }) },
                    alwaysShowLabel = false,
                    icon = {
                        Icon(
                            imageVector = if (currentRoute == item.route) item.selectedIcon else item.unselectedIcon,
                            contentDescription = null,
                        )
                    },
                    onClick = { onNavigate(item.route) }
                )
            }
        }
    }
}