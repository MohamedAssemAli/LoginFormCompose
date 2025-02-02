package com.assem.loginformcompose.core.component.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.assem.loginformcompose.core.component.MyText

@Composable
fun MyTextFiledWithTitleAndMandatoryFieldOption(
    title: String,
    hint: String,
    value: String,
    mandatoryField: Boolean,
    child: @Composable (() -> Unit)? = null,
    onValueChange: (value: String) -> Unit,
) {
    Column {
        Row(modifier = Modifier.padding(bottom = 4.dp)) {
            MyText(
                text = title,
                style = MaterialTheme.typography.bodyMedium
            )
            if (mandatoryField) {
                MyText(
                    text = "*",
                    color = Color.Red,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
        }
        child?.invoke() ?: MyTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground
                )
            },
            hint = hint
        )
    }
}

@Composable
fun MyTextFiledWithTitle(
    title: String,
    hint: String,
    value: String,
    mandatoryField: Boolean,
    onValueChange: (value: String) -> Unit
) {
    Column {
        Row(modifier = Modifier.padding(bottom = 4.dp)) {
            MyText(
                text = title,
                style = MaterialTheme.typography.bodyMedium
            )
            if (mandatoryField) {
                MyText(
                    text = "*",
                    color = Color.Red
                )
            }
        }
        MyTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            hint = hint
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyTextFiledWithTitlePreview() {
    Column(Modifier.fillMaxWidth()) {
        MyTextFiledWithTitleAndMandatoryFieldOption(
            "First Name",
            "First Name Hint",
            "",
            true,
        ) {}

        MyTextFiledWithTitleAndMandatoryFieldOption(
            "Second Name",
            "Second Name Hint",
            "",
            false,
        ) {}

        MyTextFiledWithTitle(
            "Last Name",
            "Last Name Hint",
            "",
            false
        ) {
        }
    }
}