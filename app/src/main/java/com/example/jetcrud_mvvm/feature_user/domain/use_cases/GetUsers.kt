package com.example.jetcrud_mvvm.feature_user.domain.use_cases

import com.example.jetcrud_mvvm.feature_user.domain.model.User
import com.example.jetcrud_mvvm.feature_user.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsers @Inject constructor(
    private val repository: UserRepository
) {
     operator fun invoke(): Flow<List<User>> {
        return repository.getUsers()
    }
}