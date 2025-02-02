package com.assem.loginformcompose.core.component.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.assem.loginformcompose.R

@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit
) {
    MyTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .padding(top = 26.dp)
            .fillMaxWidth(),
        hint = "Search",
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = null,
            )
        }
    )
}