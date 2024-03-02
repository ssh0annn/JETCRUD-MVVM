package com.example.jetcrud_mvvm.feature_user.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetcrud_mvvm.feature_user.data.data_source.local.dao.UserDao
import com.example.jetcrud_mvvm.feature_user.domain.model.User


@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class UserDatabase:RoomDatabase() {
    abstract val usedao: UserDao
}