package com.assem.loginformcompose.presentation.login


import com.assem.loginformcompose.core.mvi.Action
import com.assem.loginformcompose.core.mvi.State
import com.assem.loginformcompose.core.mvi.ViewEffect

/**
 * State
 */
data class LoginState(
    val email: String = "", // test.other.completed@goalngo.com
    val isEmailValid: Boolean = true,
    val emailValidationErrorMessage: String? = null,

    val password: String = "", // Other@123
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
    data class ChangeEmail(
        val email: String,
    ) : LoginAction()

    data class ChangePassword(
        val password: String,
    ) : LoginAction()

    data object Login : LoginAction()
    data class LoginFailed(val message: String) : LoginAction()
    data object LoadProfile : LoginAction()
    data object ProfileLoaded : LoginAction()
}

/**
 * Effect
 */

sealed class LoginViewEffect : ViewEffect {
    data object NavigateToSignUp : LoginViewEffect()
    data object NavigateToHome : LoginViewEffect()
    data object NavigateToOtp : LoginViewEffect()
    data object NavigateToForgetPassword : LoginViewEffect()
}
