package com.assem.loginformcompose.core.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.assem.loginformcompose.core.navigation.screens.BottomNavScreens
import com.assem.loginformcompose.presentation.home.HomeScreen
import com.assem.loginformcompose.presentation.profile.ProfileScreen
import com.assem.loginformcompose.presentation.settings.SettingsScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavScreens.Home
    ) {
        composable<BottomNavScreens.Home> {
            HomeScreen()
        }
        composable<BottomNavScreens.Profile> {
            ProfileScreen()
        }
        composable<BottomNavScreens.Settings> {
            SettingsScreen()
        }
    }
}
