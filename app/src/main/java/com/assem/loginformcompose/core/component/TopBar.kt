package com.assem.loginformcompose.core.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import com.assem.loginformcompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(
    icon: Int = R.drawable.ic_back,
    onBackClick: () -> Unit,
    text: String = "",
    textColor: Color = Color.Black,
) {
    TopAppBar(
        title = {
            Text(text, maxLines = 1, overflow = TextOverflow.Ellipsis, color = textColor)
        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = "Back Button",
                    tint = Color.Black
                )
            }
        },
    )
}