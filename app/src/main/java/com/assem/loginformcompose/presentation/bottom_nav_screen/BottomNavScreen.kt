package com.assem.loginformcompose.presentation.bottom_nav_screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.assem.loginformcompose.core.navigation.graph.HomeNavGraph
import com.assem.loginformcompose.domain.entity.BottomNavItem

@Composable
fun BottomNavScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValue ->
        HomeNavGraph(navController)
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Profile,
        BottomNavItem.Settings,
    )

    var navigationSelectedItem by remember { mutableIntStateOf(0) }
    NavigationBar(
        containerColor = White,
        modifier = Modifier.fillMaxWidth()
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                colors = NavigationBarItemColors(
                    selectedIconColor = Color.Black,
                    selectedTextColor = Color.Black,
                    selectedIndicatorColor = White,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    disabledIconColor = Color.Gray,
                    disabledTextColor = Color.Gray,
                ),
                icon = {
                    Icon(
                        if (index == navigationSelectedItem) {
                            item.selectedIcon
                        } else {
                            item.unselectedIcon
                        },
                        contentDescription = item.label
                    )
                },
                label = {
                    Text(text = item.label)
                },
                selected = index == navigationSelectedItem,
                onClick = {
                    navigationSelectedItem = index
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}



