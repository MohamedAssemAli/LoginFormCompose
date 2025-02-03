package com.assem.loginformcompose.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assem.loginformcompose.core.mvi.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

const val LOGIN_EMAIL = "admin@gmail.com"
const val LOGIN_PASSWORD = "12345678"

@HiltViewModel
class LoginViewModel() : ViewModel() {
    private val store: Store<LoginState, LoginAction, LoginViewEffect> =
        Store(LoginState.initial(), LoginReducer(), viewModelScope)

    val state: StateFlow<LoginState> = store.state
    val effect: SharedFlow<LoginViewEffect?> = store.effect

    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    fun updateEmail(text: String) {
        _email.value = text
        validateEmail(text)
    }

    private val _isEmailValid = MutableStateFlow(true)
    val isEmailValid = _isEmailValid.asStateFlow()

    private fun validateEmail(text: String) {
        _isEmailValid.value = text.isNotEmpty()
    }

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    fun updatePassword(text: String) {
        _password.value = text
        validatePassword(text)
    }

    private val _isPasswordValid = MutableStateFlow(true)
    val isPasswordValid = _isPasswordValid.asStateFlow()


    private fun validatePassword(text: String) {
        _isPasswordValid.value = text.length >= 8
    }

    private val _isShowPassword = MutableStateFlow(false)
    val isShowPassword = _isShowPassword.asStateFlow()

    fun toggleShowPassword() {
        _isShowPassword.value = _isShowPassword.value.not()
    }

    private val _isFormValid = MutableStateFlow(false)
    val isFormValid = _isFormValid.asStateFlow()

    private fun validateForm() {
        _isFormValid.value = _isEmailValid.value && _isPasswordValid.value
    }

    fun sendIntent(loginIntent: LoginIntent) {
        when (loginIntent) {
            LoginIntent.Login -> {
                login()
            }
        }
    }

    private fun login() {
        val email = email.value
        val password = password.value

        if (email == LOGIN_EMAIL && password == LOGIN_PASSWORD) {
            store.dispatch(LoginAction.Login)
        } else {
            store.dispatch(LoginAction.LoginFailed("Invalid email or password"))
        }
    }
}
