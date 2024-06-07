package com.superman.firebasedatabase.database

import kotlinx.coroutines.tasks.await



interface IRootRepository {}

interface IRepository<T> : IRootRepository {
    suspend fun findByIdAsync(id: String): T?
    suspend fun addAsync(entity: T): T?
    suspend fun updateAsync(entity: T): T?
    suspend fun removeAsync(id: String): Boolean
    suspend fun getAllAsync(): List<T>
}

class FirebaseRepository<T>(val entityName: String) : IRepository<T> {
    private val firebaseHelper: FirebaseHelper = FirebaseHelperImpl()
    override suspend fun findByIdAsync(id: String): T? {
        val student = firebaseHelper.database.reference.child(entityName).child(id).get()
        val tmp = student.result
        if (tmp.exists()) {
            return tmp.value as T
        } else {
            return null
        }
    }

    override suspend fun addAsync(entity: T): T? {
        val studentId = firebaseHelper.database.reference.child(entityName).push().key
        val tmp = studentId?.let { firebaseHelper.database.reference.child(entityName).child(it).setValue(entity) }
        return if (tmp!!.isSuccessful) {
            findByIdAsync(studentId)
        } else null
    }

    override suspend fun updateAsync(entity: T): T? {
//        val idField = entityClass.getDeclaredField("id")
//        idField.isAccessible = true
//        val id = idField.get(entity) as String
//        db.document(id).set(entity).await()
//        return findByIdAsync(id)!!
        return null;
    }

    override suspend fun removeAsync(id: String): Boolean {
        return false;
    }

    override suspend fun getAllAsync(): List<T> {
        val querySnapshot = firebaseHelper.database.reference.child(entityName).get()
        val tmp = querySnapshot.result
        return tmp.children.map { it as T }.toList()
    }
}
