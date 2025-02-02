package com.assem.loginformcompose.presentation.login

import com.assem.loginformcompose.core.mvi.Reducer


class LoginReducer : Reducer<LoginState, LoginAction, LoginViewEffect> {
    override fun reduce(
        currentState: LoginState,
        action: LoginAction,
    ): Pair<LoginState, LoginViewEffect?> = when (action) {
        is LoginAction.ChangeEmail -> {
            val validationErrorMessage = ""
            currentState.copy(
                email = action.email,
                isEmailValid = false,
                emailValidationErrorMessage = "validationErrorMessage"
            ) to null
        }

        is LoginAction.ChangePassword -> {
            val validationErrorMessage = ""
            currentState.copy(
                password = action.password.trim(),
                isPasswordValid = false,
                passwordValidationErrorMessage = "validationErrorMessage"
            ) to null
        }

        LoginAction.Login -> {
            currentState.copy(
                isLoading = true,
                generalErrorMessage = null,
            ) to null
        }

        is LoginAction.LoginFailed -> {
            currentState.copy(
                isLoading = false,
                generalErrorMessage = action.message,
            ) to null
        }

        LoginAction.LoadProfile -> {
            currentState.copy(
                isLoading = true,
                generalErrorMessage = null,
            ) to null
        }

        LoginAction.ProfileLoaded -> {
            currentState.copy(
                isLoading = false,
                generalErrorMessage = null,
            ) to LoginViewEffect.NavigateToHome
        }
    }
}
