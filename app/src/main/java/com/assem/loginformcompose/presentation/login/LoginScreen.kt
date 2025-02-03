package com.assem.loginformcompose.presentation.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.assem.loginformcompose.core.component.MyText
import com.assem.loginformcompose.core.component.MyTopBar
import com.assem.loginformcompose.core.component.textfield.EmailTextField
import com.assem.loginformcompose.core.component.textfield.PasswordTextField
import com.goalngo.designsystem.component.MyButton
import com.goalngo.designsystem.component.MyTextButton
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navigateToHomeScreen: () -> Unit,
    navigateToForgotPasswordScreen: () -> Unit,
    navigateToSignUpScreen: () -> Unit,
) {
    val state by viewModel.state.collectAsState()
    val effect = viewModel.effect

    LaunchedEffect(effect) {
        effect.collectLatest {
            when (it) {
                LoginViewEffect.LoginFailed -> {}

                LoginViewEffect.NavigateToForgetPassword -> {
                    navigateToForgotPasswordScreen()
                }

                LoginViewEffect.NavigateToHome -> {
                    navigateToHomeScreen()
                }

                LoginViewEffect.NavigateToSignUp -> {
                    navigateToSignUpScreen()
                }

                else -> {}
            }
        }
    }
    LoginScreenContent(
        viewModel = viewModel,
        stateHolder = state,
        navigateToHomeScreen = navigateToHomeScreen,
        navigateToForgotPasswordScreen = navigateToForgotPasswordScreen,
        navigateToSignUpScreen = navigateToSignUpScreen,
    )
}


@Composable
fun LoginScreenContent(
    viewModel: LoginViewModel,
    stateHolder: LoginState,
    navigateToHomeScreen: () -> Unit,
    navigateToForgotPasswordScreen: () -> Unit,
    navigateToSignUpScreen: () -> Unit,
) {

    val email by viewModel.email.collectAsState()
    val isEmailValid by viewModel.isEmailValid.collectAsState()

    val password by viewModel.password.collectAsState()
    val isPasswordValid by viewModel.isPasswordValid.collectAsState()

    val isShowPassword by viewModel.isShowPassword.collectAsState()
    val isFormdValid by viewModel.isFormValid.collectAsState()

    Scaffold(topBar = { MyTopBar(isBackVisibilie = false) }) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(
                    horizontal = 16.dp,
                    vertical = 16.dp
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                EmailTextField(
                    email = email,
                    onValueChange = { value ->
                        viewModel.updateEmail(value)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    errMessage = "Email is Invalid",
                    isError = isEmailValid
                )
                Spacer(modifier = Modifier.height(16.dp))
                PasswordTextField(
                    password = password,
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = { viewModel.updatePassword(it) },
                    errMessage = "Password must be 8 chars or more",
                    showPassword = isShowPassword,
                    onTrailingIconClicked = { viewModel.toggleShowPassword() },
                    isError = isPasswordValid,
                )
                Spacer(modifier = Modifier.height(24.dp))
                MyButton(
                    onClick = {
                        viewModel.sendIntent(LoginIntent.Login)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    contentPadding = PaddingValues(
                        vertical = 13.dp
                    ),

                    enabled = isFormdValid,
                    disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                    disabledContentColor = MaterialTheme.colorScheme.onPrimary,
                    text = {
                        MyText(
                            text = "Login",
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    },
                )
                Spacer(modifier = Modifier.height(24.dp))
                MyTextButton(
                    onClick = { navigateToSignUpScreen() },
                    text = {
                        MyText("New User? Signup", fontSize = 12.sp)
                    })
            }
        }
    }
}

