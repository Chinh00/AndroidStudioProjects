package com.superman.firebasedatabase.ui.department

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun DepartmentScreen () {
    val departmentScreenViewmodel: DepartmentScreenViewmodel = viewModel()

    val id = remember {
        mutableStateOf("")
    }
    val name = remember {
        mutableStateOf("")
    }
    val email = remember {
        mutableStateOf("")
    }
    val website = remember {
        mutableStateOf("")
    }
    val logo = remember {
        mutableStateOf("")
    }
    val address = remember {
        mutableStateOf("")
    }
    val phone = remember {
        mutableStateOf("")
    }
    val departmentId = remember {
        mutableStateOf("")
    }
    Surface {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(value = id.value, onValueChange = { id.value = it}, label = { Text(text = "Mã đơn vị ")}, modifier = Modifier.padding(10.dp))
            TextField(value = name.value, onValueChange = { name.value = it}, label = { Text(text = "Tên đơn vị ")} , modifier = Modifier.padding(10.dp))
            TextField(value = email.value, onValueChange = { email.value = it}, label = { Text(text = "Email")} , modifier = Modifier.padding(10.dp))
            TextField(value = website.value, onValueChange = { website.value = it}, label = { Text(
                text = "Website "
            )} , modifier = Modifier.padding(10.dp))
            TextField(value = logo.value, onValueChange = { logo.value = it}, label = { Text(text = "Logo")}, modifier = Modifier.padding(10.dp))
            TextField(value = address.value, onValueChange = { address.value = it}, label = { Text(
                text = "Địa chỉ "
            )}, modifier = Modifier.padding(10.dp))
            TextField(value = phone.value, onValueChange = { phone.value = it}, label = { Text(text = "Số điện thoại ")}, modifier = Modifier.padding(10.dp))
            TextField(value = departmentId.value, onValueChange = { departmentId.value = it}, label = { Text(
                text = "Đơn vị cha "
            )}, modifier = Modifier.padding(10.dp))
            Button(onClick = {  }) {
                Text(text = "Thêm mới ")
            }
        }
    }



}