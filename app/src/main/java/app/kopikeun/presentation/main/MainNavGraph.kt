package app.kopikeun.presentation.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import app.kopikeun.presentation.cafe.CafeScreen
import app.kopikeun.presentation.cafelist.CafeListScreen
import app.kopikeun.presentation.dashboard.DashboardScreen
import app.kopikeun.presentation.photo.PhotoScreen
import app.kopikeun.presentation.photolist.PhotoListScreen
import app.kopikeun.presentation.search.SearchScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import soup.compose.material.motion.*
import soup.compose.material.motion.navigation.MaterialMotionNavHost
import soup.compose.material.motion.navigation.composable
import soup.compose.material.motion.navigation.rememberMaterialMotionNavController

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun MainNavGraph(
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    val mainNavigation = rememberMaterialMotionNavController()
    val sui = rememberSystemUiController()

    DisposableEffect(key1 = Unit) {
        sui.setStatusBarColor(Color.White)
        sui.setNavigationBarColor(Color.Black)

        onDispose { }
    }

    MaterialMotionNavHost(
        navController = mainNavigation,
        startDestination = Screen.Main.route,
    ) {
        composable(
            route = Screen.Main.route,
            exitMotionSpec = { _, target ->
                when (target.destination.route) {
                    Screen.Search.route -> holdOut()
                    else -> materialSharedAxisZOut()
                }
            },
        ) {
            DashboardScreen(
                mainViewModel = mainViewModel,
                onNavigate = {
                    mainNavigation.navigate(it.route)
                }
            )
        }

        composable(
            route = Screen.Search.route,
            enterMotionSpec = { _, _ ->
                holdIn()
            },
            popExitMotionSpec = { _, _ ->
                holdOut()
            },
            exitMotionSpec = { _, target ->
                when (target.destination.route) {
                    Screen.Cafe.route -> materialElevationScaleOut()
                    else -> materialSharedAxisZOut()
                }
            },
            popEnterMotionSpec = { initial, _ ->
                when (initial.destination.route) {
                    Screen.Cafe.route -> materialElevationScaleIn()
                    else -> materialSharedAxisZIn()
                }
            },
        ) {
            SearchScreen(
                onNavigate = {
                    mainNavigation.navigate(it.route)
                },
                onBackPressed = {
                    mainNavigation.navigateUp()
                },
                mainViewModel = mainViewModel,
            )
        }

        composable(
            route = Screen.Cafe.route,
            enterMotionSpec = { _, _ ->
                translateXIn({ it }, 250)
            },
            popExitMotionSpec = { _, _ ->
                translateXOut({ it }, 250)
            },
            exitMotionSpec = { _, target ->
                when (target.destination.route) {
                    Screen.PhotoList.route -> materialElevationScaleOut()
                    else -> materialSharedAxisZOut()
                }
            },
            popEnterMotionSpec = { initial, _ ->
                when (initial.destination.route) {
                    Screen.PhotoList.route -> materialElevationScaleIn()
                    else -> materialSharedAxisZIn()
                }
            },
        ) {
            CafeScreen(
                cafeId = mainViewModel.selectedCafeId,
                mainViewModel = mainViewModel,
                onNavigate = {
                    mainNavigation.navigate(it.route)
                },
                onBackPressed = {
                    mainNavigation.navigateUp()
                }
            )
        }

        composable(
            route = Screen.CafeList.route,
            exitMotionSpec = { _, target ->
                when (target.destination.route) {
                    Screen.Cafe.route -> materialElevationScaleOut()
                    else -> materialSharedAxisZOut()
                }
            },
            popEnterMotionSpec = { initial, _ ->
                when (initial.destination.route) {
                    Screen.Cafe.route -> materialElevationScaleIn()
                    else -> materialSharedAxisZIn()
                }
            },
        ) {
            CafeListScreen(
                mainViewModel = mainViewModel,
                onNavigate = {
                    mainNavigation.navigate(it.route)
                },
                onBackPressed = {
                    mainNavigation.navigateUp()
                },
            )
        }

        composable(
            route = Screen.PhotoList.route,
            enterMotionSpec = { _, _ ->
                translateXIn({ it }, 250)
            },
            popExitMotionSpec = { _, _ ->
                translateXOut({ it }, 250)
            },
            exitMotionSpec = { _, target ->
                when (target.destination.route) {
                    Screen.Photo.route -> holdOut()
                    else -> materialSharedAxisZOut()
                }
            },
            popEnterMotionSpec = { initial, _ ->
                when (initial.destination.route) {
                    Screen.Photo.route -> holdIn()
                    else -> materialSharedAxisZIn()
                }
            },
        ) {
            PhotoListScreen(
                onNavigate = {
                    mainNavigation.navigate(it.route)
                },
                onBackPressed = {
                    mainNavigation.navigateUp()
                },
                mainViewModel = mainViewModel,
            )
        }

        composable(
            route = Screen.Photo.route,
            enterMotionSpec = { _, _ ->
                translateYIn({ it }, 250)
            },
            popExitMotionSpec = { _, _ ->
                translateYOut({ it }, 250)
            }
        ) {
            PhotoScreen(
                onBackPressed = {
                    mainNavigation.navigateUp()
                },
                mainViewModel = mainViewModel,
            )
        }
    }
}