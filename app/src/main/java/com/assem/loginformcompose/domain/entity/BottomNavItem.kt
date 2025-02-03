package com.assem.loginformcompose.domain.entity

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.assem.loginformcompose.core.navigation.screens.BottomNavScreens

sealed class BottomNavItem(
    val route: BottomNavScreens,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val label: String,
    val isSelected: Boolean
) {
    data object Home :
        BottomNavItem(
            route = BottomNavScreens.Home,
            unselectedIcon = Icons.Default.Home,
            selectedIcon = Icons.Default.Home,
            label = "Home",
            isSelected = true
        )

    data object Profile : BottomNavItem(
        route = BottomNavScreens.Profile,
        unselectedIcon = Icons.Default.Person,
        selectedIcon = Icons.Default.Person,
        label = "Profile",
        isSelected = false
    )

    data object Settings :
        BottomNavItem(
            route = BottomNavScreens.Settings,
            unselectedIcon = Icons.Default.Settings,
            selectedIcon = Icons.Default.Settings,
            label = "Settings",
            isSelected = false

        )
}