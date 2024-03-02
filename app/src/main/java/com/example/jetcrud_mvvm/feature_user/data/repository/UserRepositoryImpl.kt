package com.example.jetcrud_mvvm.feature_user.data.repository

import com.example.jetcrud_mvvm.feature_user.data.data_source.local.dao.UserDao
import com.example.jetcrud_mvvm.feature_user.domain.model.User
import com.example.jetcrud_mvvm.feature_user.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dao:UserDao
): UserRepository {
    override fun getUsers(): Flow<List<User>> {
        return dao.getUsers()
    }

    override suspend fun getUserById(id: Int): User? {
        return dao.getUserById(id)
    }

    override suspend fun insertUser(user: User) {
        dao.insertUser(user)
    }

    override suspend fun deleteUser(user: User) {
        return dao.deleteUser(user)
    }

}