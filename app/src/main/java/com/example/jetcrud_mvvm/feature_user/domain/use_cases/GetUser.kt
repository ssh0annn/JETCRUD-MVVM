package com.example.jetcrud_mvvm.feature_user.domain.use_cases

import com.example.jetcrud_mvvm.feature_user.domain.model.User
import com.example.jetcrud_mvvm.feature_user.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUser @Inject constructor(
    private val repository: UserRepository
) {
   suspend operator fun invoke(id: Int): User? {
        return repository.getUserById(id)
    }
}