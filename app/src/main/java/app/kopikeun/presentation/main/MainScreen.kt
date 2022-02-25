package app.kopikeun.presentation.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.kopikeun.presentation.main.bottombar.BottomNavGraph
import app.kopikeun.presentation.main.bottombar.BottomNavigationBar
import soup.compose.material.motion.navigation.rememberMaterialMotionNavController

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun MainScreen(
    mainViewModel: MainViewModel,
    onNavigate: (Screen) -> Unit,
) {
    val bottomNavigation = rememberMaterialMotionNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navBackStackEntry = bottomNavigation.currentBackStackEntry,
                onNavigate = {
                    // TODO
                },
            )
        },
    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
            BottomNavGraph(
                mainViewModel = mainViewModel,
                navigation = bottomNavigation,
                onNavigateMain = onNavigate,
            )
        }
    }
}