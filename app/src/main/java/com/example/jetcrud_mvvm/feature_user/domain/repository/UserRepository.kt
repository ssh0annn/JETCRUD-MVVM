package com.example.jetcrud_mvvm.feature_user.domain.repository

import com.example.jetcrud_mvvm.feature_user.data.data_source.local.dao.UserDao
import com.example.jetcrud_mvvm.feature_user.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUsers(): Flow<List<User>>

    suspend fun getUserById(id:Int):User?

    suspend fun insertUser(user: User)

    suspend fun deleteUser(user: User)

}