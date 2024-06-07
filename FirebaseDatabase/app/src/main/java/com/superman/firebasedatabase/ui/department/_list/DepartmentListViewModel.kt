package com.superman.firebasedatabase.ui.department._list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.superman.firebasedatabase.database.IRepository
import com.superman.firebasedatabase.database.domain.Department
import com.superman.firebasedatabase.infrastructure.di.DepartmentFirebaseRepository
import com.superman.firebasedatabase.infrastructure.network.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DepartmentListViewModel @Inject constructor(
) : ViewModel(){
    val _departments = MutableStateFlow(emptyList<Department>())
    val departments = _departments.asStateFlow()
    val _apiState = MutableStateFlow(ApiState.NONE)
    suspend fun HandleGetDepartment () {
        viewModelScope.launch {

        }
    }

}