package com.goalngo.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.assem.loginformcompose.core.component.MyText
import com.assem.loginformcompose.ui.theme.LoginFormComposeTheme

@Composable
fun MyButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues? = null,
    borderRadius: Dp = 8.dp,
    containerColor: Color = Color.Unspecified,
    contentColor: Color = Color.Unspecified,
    disabledContainerColor: Color = Color.Unspecified,
    disabledContentColor: Color = Color.Unspecified,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = contentPadding ?: if (leadingIcon != null) {
            ButtonDefaults.ButtonWithIconContentPadding
        } else {
            ButtonDefaults.ContentPadding
        },
        shape = RoundedCornerShape(borderRadius),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        ),
    ) {
        MyButtonContent(
            text = text,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon
        )
    }
}

@Composable
fun MyOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues? = null,
    borderRadius: Dp = 8.dp,
    borderWidth: Dp = 1.dp,
    enabledBorderColor: Color = MaterialTheme.colorScheme.outline,
    disabledBorderColor: Color = MaterialTheme.colorScheme.onSurface,
    containerColor: Color = Color.Unspecified,
    contentColor: Color = Color.Unspecified,
    disabledContainerColor: Color = Color.Unspecified,
    disabledContentColor: Color = Color.Unspecified,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = contentPadding ?: if (leadingIcon != null) {
            ButtonDefaults.ButtonWithIconContentPadding
        } else {
            ButtonDefaults.ContentPadding
        },
        shape = RoundedCornerShape(borderRadius),
        border = BorderStroke(
            width = borderWidth,
            color = if (enabled) enabledBorderColor else disabledBorderColor,
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        ),
    ) {
        MyButtonContent(
            text = text,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon
        )
    }
}

@Composable
fun MyTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues? = null,
    contentColor: Color = Color.Unspecified,
    disabledContentColor: Color = Color.Unspecified,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = contentPadding ?: if (leadingIcon != null) {
            ButtonDefaults.ButtonWithIconContentPadding
        } else {
            ButtonDefaults.ContentPadding
        },
        colors = ButtonDefaults.textButtonColors(
            contentColor = contentColor,
            disabledContentColor = disabledContentColor,
        ),
    ) {
        MyButtonContent(
            text = text,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon
        )
    }
}

@Composable
private fun MyButtonContent(
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        leadingIcon?.invoke()
        Box(
            Modifier
                .padding(
                    start = if (leadingIcon != null) ButtonDefaults.IconSpacing else 0.dp,
                    end = if (trailingIcon != null) ButtonDefaults.IconSpacing else 0.dp,
                ),
        ) {
            text()
        }
        trailingIcon?.invoke()
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun MyButtonPreview() {
    LoginFormComposeTheme(dynamicColor = false) {
        Column(modifier = Modifier.fillMaxSize()) {
            MyButton(
                onClick = {},
                text = {
                    MyText(
                        text = LoremIpsum(1).values.joinToString(" "),
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 14.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                }
            )
            Spacer(Modifier.height(8.dp))
            MyButton(
                onClick = {},
                enabled = false,
                disabledContainerColor = MaterialTheme.colorScheme.onSurface,
                disabledContentColor = MaterialTheme.colorScheme.surface,
                text = {
                    MyText(
                        text = LoremIpsum(4).values.joinToString(" "),
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 14.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                }
            )
            Spacer(Modifier.height(8.dp))
            MyButton(
                onClick = {},
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onBackground,
                text = {
                    MyText(
                        text = LoremIpsum(1).values.joinToString(" "),
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 14.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                }
            )
            Spacer(Modifier.height(8.dp))
            MyButton(
                onClick = {},
                enabled = false,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
                disabledContentColor = MaterialTheme.colorScheme.secondary,
                text = {
                    MyText(
                        text = LoremIpsum(1).values.joinToString(" "),
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 14.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                }
            )
            Spacer(Modifier.height(8.dp))
            MyOutlinedButton(
                onClick = {},
                text = {
                    MyText(
                        text = LoremIpsum(1).values.joinToString(" "),
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 14.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                }
            )
            Spacer(Modifier.height(8.dp))
            MyOutlinedButton(
                onClick = {},
                enabled = false,
                disabledContainerColor = MaterialTheme.colorScheme.onSurface,
                disabledContentColor = MaterialTheme.colorScheme.surface,
                text = {
                    MyText(
                        text = LoremIpsum(1).values.joinToString(" "),
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 14.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                }
            )
            Spacer(Modifier.height(8.dp))
            MyTextButton(
                onClick = {},
                contentColor = MaterialTheme.colorScheme.onBackground,
                text = {
                    MyText(
                        text = LoremIpsum(1).values.joinToString(" "),
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 14.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                }
            )
            Spacer(Modifier.height(8.dp))
            MyTextButton(
                onClick = {},
                enabled = false,
                text = {
                    MyText(
                        text = LoremIpsum(1).values.joinToString(" "),
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 14.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                }
            )
            MyTextButton(
                onClick = {},
                text = {
                    MyText(
                        text = LoremIpsum(1).values.joinToString(" "),
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 14.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                }
            )
            Spacer(Modifier.height(8.dp))
            MyTextButton(
                onClick = {},
                enabled = false,
                text = {
                    MyText(
                        text = LoremIpsum(1).values.joinToString(" "),
                        style = MaterialTheme.typography.bodyLarge,
                        fontSize = 14.sp
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "",
                    )
                }
            )
            Spacer(Modifier.height(8.dp))
        }
    }
}
