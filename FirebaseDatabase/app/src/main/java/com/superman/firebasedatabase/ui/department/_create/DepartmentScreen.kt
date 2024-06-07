package com.superman.firebasedatabase.ui.department._create

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.superman.firebasedatabase.database.domain.Department
import com.superman.firebasedatabase.ui.components.Dropdown
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun DepartmentScreen () {
    val coroutineScope = CoroutineScope(Dispatchers.IO)
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
    val context = LocalContext.current
    Surface {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(value = name.value, onValueChange = { name.value = it}, label = { Text(text = "Tên đơn vị ")} , modifier = Modifier.padding(10.dp).fillMaxWidth())
            TextField(value = email.value, onValueChange = { email.value = it}, label = { Text(text = "Email")} , modifier = Modifier.padding(10.dp).fillMaxWidth())
            TextField(value = website.value, onValueChange = { website.value = it}, label = { Text(
                text = "Website "
            )} , modifier = Modifier.padding(10.dp).fillMaxWidth())
            TextField(value = logo.value, onValueChange = { logo.value = it}, label = { Text(text = "Logo")}, modifier = Modifier.padding(10.dp).fillMaxWidth())
            TextField(value = address.value, onValueChange = { address.value = it}, label = { Text(
                text = "Địa chỉ "
            )}, modifier = Modifier.padding(10.dp).fillMaxWidth())
            TextField(value = phone.value, onValueChange = { phone.value = it}, label = { Text(text = "Số điện thoại ")}, modifier = Modifier.padding(10.dp).fillMaxWidth())

            Dropdown()
            Button(onClick = {

            }) {
                Text(text = "Thêm mới ")
            }
        }
    }



}