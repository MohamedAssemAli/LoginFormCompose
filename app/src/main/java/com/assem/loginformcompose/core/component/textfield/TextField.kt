package com.assem.loginformcompose.core.component.textfield

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.assem.loginformcompose.core.component.MyText
import com.assem.loginformcompose.ui.theme.LoginFormComposeTheme

@Composable
fun MyTextField(
    value: String = "",
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    hintStyle: TextStyle = MaterialTheme.typography.bodyMedium.copy(
        color = Color.Gray,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
    label: @Composable (() -> Unit)? = null,
    hint: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    errMessage: String? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    borderRadius: Dp = 8.dp,
    shape: Shape = RoundedCornerShape(borderRadius),
    colors: TextFieldColors? = null,
    modifier: Modifier = Modifier
        .border(
            width = 1.dp,
            color = if (isError) MaterialTheme.colorScheme.error else Transparent,
            shape = shape
        )
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        label = label,
        placeholder = {
            MyText(
                text = hint ?: "",
                style = hintStyle
            )
        },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        prefix = prefix,
        suffix = suffix,
        supportingText = supportingText ?: if (isError && errMessage != null) {
            {
                MyText(
                    text = errMessage,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.error
                )
            }
        } else {
            null
        },
        isError = isError,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        minLines = minLines,
        shape = shape,
        colors = colors ?: TextFieldDefaults.colors(
            focusedContainerColor = Color.Gray,
            unfocusedContainerColor = Color.Gray,
            focusedTextColor = MaterialTheme.colorScheme.onBackground,
            unfocusedTextColor = MaterialTheme.colorScheme.onBackground,
            focusedIndicatorColor = Transparent,
            unfocusedIndicatorColor = Transparent,
            errorIndicatorColor = MaterialTheme.colorScheme.error,
            errorContainerColor = Color.Gray,
            errorTextColor = MaterialTheme.colorScheme.onBackground,
        )
    )
}

@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun MyTextFieldPreview() {
    LoginFormComposeTheme(dynamicColor = false) {
        Column(modifier = Modifier.fillMaxSize()) {
            MyTextField(
                onValueChange = {},
                hint = LoremIpsum(3).values.joinToString(" ")
            )
            Spacer(Modifier.height(8.dp))
            MyTextField(
                value = LoremIpsum(3).values.joinToString(" "),
                onValueChange = {},
            )
            Spacer(Modifier.height(8.dp))
            MyTextField(
                value = LoremIpsum(3).values.joinToString(" "),
                onValueChange = {},
                isError = true
            )
            Spacer(Modifier.height(8.dp))
            MyTextField(
                value = LoremIpsum(3).values.joinToString(" "),
                onValueChange = {},
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                },
            )
            Spacer(Modifier.height(8.dp))
            MyTextField(
                value = LoremIpsum(3).values.joinToString(" "),
                onValueChange = {},
                visualTransformation = PasswordVisualTransformation(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                },
            )
            Spacer(Modifier.height(8.dp))
            MyTextField(
                hint = LoremIpsum(3).values.joinToString(" "),
                onValueChange = {},
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                },
            )
        }
    }
}