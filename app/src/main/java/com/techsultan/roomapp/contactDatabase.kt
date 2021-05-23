package com.techsultan.roomapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.techsultan.roomapp.db.dao.UserDao
import com.techsultan.roomapp.db.entity.UserEntity


@Database(
    entities = [UserEntity::class],
    version = 1
)
abstract class UserDatabase : RoomDatabase(){

    abstract fun userDao() : UserDao

    companion object {
        @Volatile private var instance: UserDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context)
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context, UserDatabase::class.java, "user.db"
        ).allowMainThreadQueries().build()
    }
}