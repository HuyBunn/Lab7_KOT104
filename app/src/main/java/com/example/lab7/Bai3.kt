package com.example.lab7

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Screen3(val route: String) {
    LOGIN("Login"),
    MOVIE_SCREEN("MovieScreen"),
    SCREEN1("Screen1"),
    SCREEN2("Screen2"),
    SCREEN3("Screen3"),
}
@Composable
fun ScreenNavigation3() {
    val navController = rememberNavController()
    val mainViewModel: MainViewModel = viewModel()
    val moviesState = mainViewModel.movies.observeAsState(initial = emptyList())
    NavHost(
        navController = navController,
        startDestination = Screen3.LOGIN.route,
    ) {
        composable(Screen3.LOGIN.route) { LoginScreen(navController) }
        composable(Screen3.MOVIE_SCREEN.route) { Bai1(moviesState.value) }
        composable(Screen3.SCREEN1.route) { Screen1(navController) }
        composable(Screen3.SCREEN2.route) { Screen2(navController) }
        composable(Screen3.SCREEN3.route) { Screen3(navController) }
    }
}
