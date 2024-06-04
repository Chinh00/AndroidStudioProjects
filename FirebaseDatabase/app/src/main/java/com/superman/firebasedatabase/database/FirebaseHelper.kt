package com.superman.firebasedatabase.database

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

public interface FirebaseHelper {
    public val database: FirebaseDatabase
}

public class FirebaseHelperImpl : FirebaseHelper {
    private val mutex = Mutex()
    private var _database: FirebaseDatabase? = null

    public override val database: FirebaseDatabase
        get() = runBlocking {
            mutex.withLock {
                if (_database == null) {
                    _database = Firebase.database
                }
                return@runBlocking _database!!
            }
        }
}
