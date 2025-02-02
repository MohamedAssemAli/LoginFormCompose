package com.assem.loginformcompose.core.component

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import com.goalngo.designsystem.component.MyTextButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDatePickerDialog(
    minDate: Long? = null,
    maxDate: Long? = null,
    selectedDate: Long? = null,
    onConfirm: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = selectedDate,
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean =
                minDate?.let { utcTimeMillis >= it } ?: true &&
                        maxDate?.let { utcTimeMillis <= it } ?: true
        }
    )

    DatePickerDialog(
        colors = DatePickerDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        onDismissRequest = onDismiss,
        confirmButton = {
            MyTextButton(
                onClick = {
                    onConfirm(datePickerState.selectedDateMillis)
                    onDismiss()
                },
                text = {
                    MyText(
                        text = "Ok",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            )
        },
        dismissButton = {
            MyTextButton(
                onClick = onDismiss,
                text = {
                    MyText(
                        text = "Cancel",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            )
        }
    ) {
        DatePicker(
            colors = DatePickerDefaults.colors(
                containerColor = MaterialTheme.colorScheme.surface,
                titleContentColor = MaterialTheme.colorScheme.onBackground,
                headlineContentColor = MaterialTheme.colorScheme.onBackground,
                dividerColor = MaterialTheme.colorScheme.onBackground,
                navigationContentColor = MaterialTheme.colorScheme.onBackground,
                subheadContentColor = MaterialTheme.colorScheme.onBackground,
                weekdayContentColor = MaterialTheme.colorScheme.onBackground,
                dayContentColor = MaterialTheme.colorScheme.onBackground,
                yearContentColor = MaterialTheme.colorScheme.onBackground
            ),
            state = datePickerState
        )
    }
}


