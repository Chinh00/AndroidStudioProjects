/*
package com.superman.firebasedatabase.database

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.ui.res.fontResource
import com.superman.firebasedatabase.database.exceptions.NotFoundByIdException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.tasks.asDeferred
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

public interface IRepository {
    public suspend fun FindByIdAsync(id: String): Deferred<Student>

    public suspend fun AddAsync(student: Student): Deferred<Student>
    public suspend  fun UpdateAsync(student: Student): Deferred<Student>
    public  fun RemoveAsync(id: String): Boolean

    public suspend fun GetAllAsync (): Deferred<List<Student>>
}



class Repository : IRepository {
    val ENTITY_SCHEMA = "Students"
    val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
    val firebaseHelper = FirebaseHelperImpl()


    override suspend fun FindByIdAsync(id: String): Deferred<Student> = coroutineScope.async {
        val student = firebaseHelper.database.reference.child(ENTITY_SCHEMA).child(id).get()
        val tmp = student.result

        if (tmp.exists()) {
            return@async tmp.getValue(Student::class.java)!!
        } else {
            throw NotFoundByIdException("Student not found by id $id")
        }

    }
    override suspend fun AddAsync(student: Student): Deferred<Student> {
        return coroutineScope.async {
            val studentId = firebaseHelper.database.reference.child(ENTITY_SCHEMA).push().key
            val tmp = studentId?.let { firebaseHelper.database.reference.child(ENTITY_SCHEMA).child(it).setValue(student) }

            if (tmp!!.isSuccessful) {
                return@async tmp as Student
            } else throw Exception("Student can not add $ENTITY_SCHEMA")
        }

    }

    override suspend fun UpdateAsync(student: Student): Deferred<Student> {
        return coroutineScope.async {
            val entity = FindByIdAsync(student.Id).await()
            val tmp = firebaseHelper.database.reference.child(ENTITY_SCHEMA).child(entity.Id).setValue(student)
            if (tmp.isSuccessful) {
                return@async FindByIdAsync(student.Id).await()
            } else throw Exception("Student can not update $ENTITY_SCHEMA")
        }

    }

    override fun RemoveAsync(id: String): Boolean {
        TODO("")
    }

    override suspend fun GetAllAsync(): Deferred<List<Student>> {
        return coroutineScope.async {
            val students = firebaseHelper.database.reference.child(ENTITY_SCHEMA).get()
            val tmp = students.result

            if (tmp.exists()) {
                return@async tmp.children.map { it.getValue(Student::class.java)!! }.toList()
            } else throw Exception("Student not found")
        }
    }


}*/
