package com.superman.firebasedatabase.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Build
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.superman.firebasedatabase.ui.department.DepartmentNavigateActivity
import com.superman.firebasedatabase.ui.employee.EmployeeNavigateActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
public class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MainScreen()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MainScreen () {
    val context = LocalContext.current
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "DHTL") })
        },
        bottomBar = {
            NavigationBar {

                NavigationBarItem(selected = 1 == 1, label = { Text(text = "Department")}, onClick = {
                    val intent = Intent(context, DepartmentNavigateActivity::class.java)
                    context.startActivity(intent)
                }, icon = { Icon(imageVector = Icons.Filled.Build, contentDescription = "")})
                NavigationBarItem(selected = 1 == 1, label = { Text(text = "Employee")}, onClick = {
                    val intent = Intent(context, EmployeeNavigateActivity::class.java)
                    context.startActivity(intent)
                }, icon = { Icon(imageVector = Icons.Filled.AccountBox, contentDescription = "")})
            }

        }
    ) {
        Surface (modifier = Modifier
            .padding(it)
            .fillMaxSize()) {
            Text(text = "Quản trị Trường TLU ")
        }
    }
}

