package com.superman.firebasedatabase.ui.main

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationBarItemConfig(
    val icon: ImageVector, val onClick: () -> Unit, val title: String, val path: String
)
