package com.superman.firebasedatabase.ui.employee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.superman.firebasedatabase.ui.main.NavigationBarItemConfig
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EmployeeNavigateActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmployeeNavigate()
        }
    }

}

val navigationBarItems = listOf<NavigationBarItemConfig>(
    NavigationBarItemConfig(
        Icons.Filled.Home,
        onClick = {},
        title = "Danh sách ",
        path = "employee"
    ),
    NavigationBarItemConfig(
        Icons.Filled.Add,
        onClick = {},
        title = "Thêm mới",
        path = "employee-add"
    ),

    )

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeeNavigate () {
    val navController = rememberNavController()
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "DHTL") })
        },
        bottomBar = {
            NavigationBar {
                navigationBarItems.forEach {
                        item ->
                    NavigationBarItem(selected = 1 == 1, label = { Text(text = item.title) }, onClick = { navController.navigate(item.path) }, icon = { Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                    ) })
                }
            }

        }
    ) {
        Surface (modifier = Modifier
            .padding(it)
            .fillMaxSize()) {
            NavHost(navController = navController, startDestination = "employee" , modifier = Modifier.padding(10.dp)) {
                composable("employee") { EmployeeList() }
                composable("employee-add") { EmployeeScreen() }
            }
        }
    }
}