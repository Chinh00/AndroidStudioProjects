package com.superman.firebasedatabase.ui.employee

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.superman.firebasedatabase.database.domain.Department

@Composable
fun EmployeeList () {
    val keySearch = remember {
        mutableStateOf("")
    }
    Column {
        TextField(value = keySearch.value, onValueChange = {keySearch.value = it}, modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(), placeholder ={ Text(
            text = "Thông tin cần tìm "
        )}, trailingIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = "")})
        LazyColumn (
            modifier = Modifier.apply {
                fillMaxSize()
                    .padding(10.dp)
                    .border(BorderStroke(1.dp, Color.DarkGray))
            }
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(text = "Mã nhân viên ")
                    Text(text = "Tên nhân viên ")
                    Text(text = "Vị trí")
                    Text(text = "Đơn vị trực thuộc ")
                }
            }
            items(departments) { department ->
                DepartmentItem(department)
            }
        }
    }
}

val departments = listOf<Department>(

)



@Composable
fun DepartmentItem (d: Department) {
    Card {
        Text(text = d.name)
    }
}