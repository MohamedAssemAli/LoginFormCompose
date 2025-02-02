package com.assem.loginformcompose.core.component.textfield

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun EmailTextField(
    modifier: Modifier = Modifier,
    email: String,
    onValueChange: (String) -> Unit,
    errMessage: String? = null,
    isError: Boolean,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    MyTextField(
        modifier = modifier,
        value = email,
        onValueChange = onValueChange,
        hint = "Email",
        errMessage = errMessage,
        isError = isError,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = true
    )
}
