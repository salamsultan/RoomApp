package com.techsultan.roomapp.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(

    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var username : String,
    var email : String,
    var password : String
)
