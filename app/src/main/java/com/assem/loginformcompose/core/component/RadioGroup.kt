package com.assem.loginformcompose.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyRadioButton(
    title: String,
    mandatoryField: Boolean,
    options: List<String>,
    onSelectedOptionChange: (String) -> Unit
) {
    var selectedOption by remember { mutableStateOf(options[0]) }

    Column(modifier = Modifier.fillMaxWidth()) {
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
        RadioGroup(
            options = options,
            selectedOption = selectedOption,
            onSelectedOptionChange = { onSelectedOptionChange(it) }
        )
    }
}

@Composable
fun RadioGroup(
    options: List<String>,
    selectedOption: String,
    onSelectedOptionChange: (String) -> Unit
) {
    Row {
        options.forEach { option ->
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    colors = RadioButtonColors(
                        selectedColor = Color.Green,
                        unselectedColor = Color.Gray,
                        disabledSelectedColor = Color.Gray,
                        disabledUnselectedColor = Color.Gray
                    ),
                    selected = selectedOption == option,
                    onClick = { onSelectedOptionChange(option) }
                )
                MyText(
                    text = option,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MyRadioButtonPreview() {
    MyRadioButton(
        "Gender",
        true,
        listOf("Male", "Female")
    ) {
    }
}

