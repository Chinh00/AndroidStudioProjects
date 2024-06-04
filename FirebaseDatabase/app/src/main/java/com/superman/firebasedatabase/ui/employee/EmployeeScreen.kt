package com.superman.firebasedatabase.ui.employee

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.superman.firebasedatabase.ui.components.Dropdown
import com.superman.firebasedatabase.ui.components.UploadButton


@Composable
fun EmployeeScreen () {
    val departmentScreenViewmodel: EmployeeScreenViewmodel = viewModel()
    val fullname = remember {
        mutableStateOf("")
    }
    val position = remember {
        mutableStateOf("")
    }
    val email = remember {
        mutableStateOf("")
    }
    val phone = remember {
        mutableStateOf("")
    }
    val avatar = remember {
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
            TextField(value = fullname.value, onValueChange = { fullname.value = it}, label = { Text(text = "Họ tên nhân viên  ")} , modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth())
            TextField(value = position.value, onValueChange = { position.value = it}, label = { Text(text = "vị trí ")} , modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth())

            TextField(value = phone.value, onValueChange = { phone.value = it}, label = { Text(text = "Email")}, modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth())
            TextField(value = phone.value, onValueChange = { phone.value = it}, label = { Text(text = "Số điện thoại ")}, modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth())
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Chọn ảnh đại diện ")
                UploadButton {
                    Log.d("img", it)
                }
            }
            Dropdown()
            Button(onClick = {  }) {
                Text(text = "Thêm mới ")
            }
        }
    }



}