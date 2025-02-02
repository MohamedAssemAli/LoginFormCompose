package com.assem.loginformcompose.core.component.textfield

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.assem.loginformcompose.R

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    password: String,
    onValueChange: (String) -> Unit,
    hint: String = "Enter Password",
    onTrailingIconClicked: () -> Unit,
    showPassword: Boolean,
    errMessage: String? = null,
    isError: Boolean,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    MyTextField(
        modifier = modifier,
        value = password,
        onValueChange = onValueChange,
        hint = hint,
        trailingIcon = {
            Icon(
                modifier =
                Modifier.clickable {
                    onTrailingIconClicked()
                },
                painter =
                if (password.isEmpty()) {
                    painterResource(R.drawable.ic_eye_open_gray400)
                } else if (showPassword) {
                    painterResource(R.drawable.ic_eye_closed)
                } else {
                    painterResource(R.drawable.ic_eye_open_dark1000)
                },
                contentDescription =
                if (password.isEmpty()) {
                    "Open eye"
                } else if (showPassword) {
                    "Closed eye"
                } else {
                    "Open eye"
                },
                tint = Color.Unspecified,
            )
        },
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        errMessage = errMessage,
        isError = isError,
        maxLines = 1,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = true
    )
}
