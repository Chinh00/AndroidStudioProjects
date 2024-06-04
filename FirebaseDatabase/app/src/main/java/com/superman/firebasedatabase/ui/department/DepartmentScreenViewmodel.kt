package com.superman.firebasedatabase.ui.department

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.superman.firebasedatabase.database.FirebaseRepository
import com.superman.firebasedatabase.database.IRepository
import com.superman.firebasedatabase.database.domain.Department
import kotlinx.coroutines.launch

class DepartmentScreenViewmodel : ViewModel(){
    private val repository: IRepository<Department> = FirebaseRepository<Department>("Departments")
    suspend fun HandleCreateDepartment (department: Department) {
        viewModelScope.launch {
            repository.addAsync(department)
        }
    }


}