package com.superman.firebasedatabase.ui.components._layout

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseScreen (
    content: @Composable () -> Unit,
    title: String?
) {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(title = { title ?: "" })
        }
    ) {
        Surface (modifier = Modifier.apply { padding(it) }) {
            content()
        }
    }
}