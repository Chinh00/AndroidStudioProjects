package com.superman.firebasedatabase.database.domain

data class Employee(
    var id: String,
    var fullname: String,
    var position: String?,
    var email: String,
    var phone: String,
    var avatar: String,
    var departmentId: String,
)
