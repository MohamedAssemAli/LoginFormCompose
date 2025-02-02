package com.assem.loginformcompose.core.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mansety.android.core.navigation.screens.AuthScreens
import com.mansety.android.features.login.ui.login.LoginScreen
import com.mansety.android.features.login.ui.OtpScreen
import com.mansety.android.features.main.ui.MainScreen
import com.mansety.android.features.registration.ui.AddPersonalInfoScreen
import com.mansety.android.features.registration.ui.SelectLevelScreen
import com.mansety.android.features.registration.ui.SetPasswordScreen
import com.mansety.android.features.splash.SplashScreen

@Composable
fun RootNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AuthScreens.Login,
        startDestination = AuthScreens.MainScreen,
    ) {
        composable<AuthScreens.Splash> { SplashScreen() }
        composable<AuthScreens.Login> { LoginScreen(navigateToOtp = {}) }
        composable<AuthScreens.OTP> { OtpScreen() }
        composable<AuthScreens.SetPassword> { SetPasswordScreen() }
        composable<AuthScreens.SelectLevel> { SelectLevelScreen() }
        composable<AuthScreens.PersonalInfo> { AddPersonalInfoScreen() }
        composable<AuthScreens.ForgotPassword> { SplashScreen() }
        composable<AuthScreens.MainScreen> { MainScreen() }
    }
}