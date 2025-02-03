package com.assem.loginformcompose.core.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.assem.loginformcompose.core.navigation.screens.RootScreens
import com.assem.loginformcompose.presentation.ForgetPasswordScreen
import com.assem.loginformcompose.presentation.bottom_nav_screen.BottomNavScreen
import com.assem.loginformcompose.presentation.login.LoginScreen
import com.assem.loginformcompose.presentation.signup.SignUpScreen
import com.assem.loginformcompose.presentation.splash.SplashScreen

@Composable
fun RootNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = RootScreens.Login,
    ) {
        composable<RootScreens.Splash> { SplashScreen() }
        composable<RootScreens.Login> {
            LoginScreen(
                navigateToHomeScreen = {
                    navController.navigate(RootScreens.MainScreen)
                },
                navigateToForgotPasswordScreen = {
                    navController.navigate(RootScreens.ForgotPassword)

                },
                navigateToSignUpScreen = {
                    navController.navigate(RootScreens.SignUp)
                },
            )
        }
        composable<RootScreens.SignUp> {
            SignUpScreen(
                navigateToHomeScreen = {
                    navController.navigate(RootScreens.MainScreen)
                },
                navigateToLoginScreen = {
                    navController.navigate(RootScreens.Login)
                },
            )
        }
        composable<RootScreens.ForgotPassword> { ForgetPasswordScreen() }
        composable<RootScreens.MainScreen> { BottomNavScreen() }
    }
}