package com.assem.loginformcompose.core.navigation.screens

import kotlinx.serialization.Serializable

@Serializable
sealed class BottomNavScreens {
    @Serializable
    data object Home : BottomNavScreens()

    @Serializable
    data object Profile : BottomNavScreens()

    @Serializable
    data object Settings : BottomNavScreens()
}