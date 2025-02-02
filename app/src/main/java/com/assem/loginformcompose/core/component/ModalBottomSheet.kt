package com.assem.loginformcompose.core.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyModalBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    sheetState: SheetState = rememberModalBottomSheetState(),
    shape: Shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    dragHandle: @Composable (() -> Unit)? = { BottomSheetDefaults.DragHandle() },
    showBottomSheet: Boolean,
    content: @Composable () -> Unit,
) {
    if (showBottomSheet) {
        ModalBottomSheet(
            modifier = modifier
                .fillMaxSize()
                .statusBarsPadding(),
            sheetState = sheetState,
            onDismissRequest = { onDismissRequest() },
            containerColor = MaterialTheme.colorScheme.surface,
            shape = shape,
            dragHandle = dragHandle
        ) {
            content()
        }
    }
}