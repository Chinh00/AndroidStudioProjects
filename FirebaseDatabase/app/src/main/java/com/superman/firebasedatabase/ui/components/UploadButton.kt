package com.superman.firebasedatabase.ui.components

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun UploadButton(onUploadClicked: (String) -> Unit) {
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        // Xử lý tệp được chọn ở đây
        uri?.let {
            // Do something with the selected file URI
            onUploadClicked(it.toString()) // Chuyển đường dẫn tệp cho người dùng
        }
    }

    Button(
        onClick = { launcher.launch("*/*") }, // Mở hộp thoại chọn tệp khi nút được nhấp
        colors = ButtonDefaults.buttonColors(Color.Blue),
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Upload")
    }
}