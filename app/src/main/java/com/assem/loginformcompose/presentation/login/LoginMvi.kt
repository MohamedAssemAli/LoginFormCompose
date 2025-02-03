package com.assem.loginformcompose.presentation.login


import com.assem.loginformcompose.core.mvi.Action
import com.assem.loginformcompose.core.mvi.State
import com.assem.loginformcompose.core.mvi.ViewEffect

/**
 * State
 */
data class LoginState(
    val email: String = "",
    val isEmailValid: Boolean = true,
    val emailValidationErrorMessage: String? = null,

    val password: String = "",
    val isPasswordValid: Boolean = true,
    val passwordValidationErrorMessage: String? = null,

    val isLoading: Boolean = false,
    val generalErrorMessage: String? = null,
) : State {
    companion object {
        fun initial() = LoginState()
    }
}

/**
 * Action
 */
sealed class LoginAction : Action {
    data object Login : LoginAction()
    data class LoginFailed(val message: String) : LoginAction()
}

/**
 * Effect
 */
sealed class LoginViewEffect : ViewEffect {
    data object LoginFailed : LoginViewEffect()
    data object NavigateToSignUp : LoginViewEffect()
    data object NavigateToHome : LoginViewEffect()
    data object NavigateToForgetPassword : LoginViewEffect()
}
