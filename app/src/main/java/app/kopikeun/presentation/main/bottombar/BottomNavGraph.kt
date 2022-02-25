package app.kopikeun.presentation.main.bottombar

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import app.kopikeun.presentation.account.AccountScreen
import app.kopikeun.presentation.dashboard.DashboardScreen
import app.kopikeun.presentation.main.MainViewModel
import app.kopikeun.presentation.main.Screen
import soup.compose.material.motion.navigation.MaterialMotionNavHost
import soup.compose.material.motion.navigation.composable

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun BottomNavGraph(
    mainViewModel: MainViewModel,
    navigation: NavHostController,
    onNavigateMain: (Screen) -> Unit,
) {
    MaterialMotionNavHost(
        navController = navigation,
        startDestination = BottomNavScreen.Dashboard.route,
    ) {
        composable(route = BottomNavScreen.Dashboard.route) {
            DashboardScreen(
                mainViewModel = mainViewModel,
                onNavigate = onNavigateMain ,
            )
        }
        composable(route = BottomNavScreen.Account.route) {
            AccountScreen()
        }
    }
}