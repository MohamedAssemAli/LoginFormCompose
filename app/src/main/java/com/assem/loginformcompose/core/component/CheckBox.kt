package com.assem.loginformcompose.core.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MyCheckBox(
    text: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    checkboxColor: Color = Color.Green,
    textColor: Color = Color.Black,
    borderColor: Color = checkboxColor
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .border(
                    BorderStroke(1.dp, borderColor),
                    shape = RoundedCornerShape(4.dp)
                )
                .clickable { onCheckedChange(!isChecked) }
                .background(if (isChecked) Color.Green else Color.White)
        ) {
            if (isChecked) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        MyText(
            text = text,
            style = MaterialTheme.typography.displayMedium.copy(
                color = textColor,
                fontSize = 12.sp
            ),
            fontWeight = FontWeight.Bold,
        )
    }
}