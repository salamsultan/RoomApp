package com.techsultan.roomapp.db

import android.content.Context
import androidx.lifecycle.LiveData
import com.techsultan.roomapp.UserDatabase
import com.techsultan.roomapp.db.entity.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserRepository(context: Context) {

    private val db = UserDatabase.invoke(context)

    //fun getAllUser() : LiveData<List<UserEntity>> = db.userDao().selectAllUser()

    fun isValidUser(email: String, password: String) : Boolean{
        val validUser: UserEntity = db.userDao().getUserData(email, password)

        return validUser.password == password
    }

    fun isExisting(email: String, password: String) : Boolean{
        val existingUser: UserEntity?= db.userDao().getUserData(email, password)

        return existingUser != null
    }

    fun insertUsers(userEntity: UserEntity) {
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                db.userDao().insertUser(userEntity)
            }
        }
    }
}