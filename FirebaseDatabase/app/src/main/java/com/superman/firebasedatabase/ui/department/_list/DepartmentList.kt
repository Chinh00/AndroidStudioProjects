package com.superman.firebasedatabase.ui.department._list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.superman.firebasedatabase.database.domain.Department

@Composable
fun DepartmentList () {
    val departmentListViewModel: DepartmentListViewModel = hiltViewModel()
    LaunchedEffect(key1 = Unit) {
        departmentListViewModel.HandleGetDepartment()
    }
}

@Composable
fun DepartmentItem (d: Department) {
    Row (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Card (modifier = Modifier.apply {
            padding(10.dp).fillMaxWidth()
        }) {
            Row (modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column (modifier = Modifier
                    .padding(10.dp)) {
                    Text(text = "Phòng: ${d.name}")
                    Text(text = "Email: ${d.email}")
                    Text(text = "Website: ${d.website}", color = Color.Blue)
                    Text(text = "Địa chỉ: ${d.address}", color = Color.Blue)
                    Text(text = "Số điện thoại: ${d.phone}", color = Color.Blue)
                    Text(text = "Trực thuộc: ...", color = Color.Blue)
                }
                Column (modifier = Modifier.apply {
                }) {
                    Image(imageVector = Icons.Filled.Settings, contentDescription = "", modifier = Modifier.apply {
                        size(50.dp)
                    })
                }
            }
        }
    }
}