package com.superman.firebasedatabase.ui.components

import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun LoadingButton (
    isLoading: State<Boolean>,
    modifier: Modifier?,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(onClick = { onClick() }) {
        if (isLoading.value) {
            CircularProgressIndicator(
                modifier = Modifier.width(20.dp), color = MaterialTheme.colorScheme.primary, trackColor = MaterialTheme.colorScheme.secondary
            )
        } else {
            content()
        }
    }
}