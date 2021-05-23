package com.techsultan.roomapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.techsultan.roomapp.db.entity.UserEntity


@Dao
interface UserDao {
    @Query("SELECT * FROM 'users' WHERE users.email LIKE email AND users.password LIKE password")

    fun getUserData(email: String, password: String) : UserEntity
    fun selectAllUser(email: String, password: String) : LiveData<List<UserEntity>>

    @Insert
    fun insertUser(userEntity: UserEntity)

    @Delete
    fun deleteUser(userEntity: UserEntity)

    @Update
    fun updateUser(userEntity: UserEntity)
}