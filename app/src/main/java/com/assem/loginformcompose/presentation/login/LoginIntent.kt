package com.assem.loginformcompose.presentation.login

sealed class LoginIntent {
    data object Login : LoginIntent()
}