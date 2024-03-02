package com.example.jetcrud_mvvm.feature_user.domain.use_cases

import androidx.room.Insert
import com.example.jetcrud_mvvm.feature_user.domain.model.User
import com.example.jetcrud_mvvm.feature_user.domain.repository.UserRepository
import javax.inject.Inject

class InsertUser @Inject constructor(
    private val repository: UserRepository
) {
    suspend operator fun invoke(user: User){
        repository.insertUser(user)
    }
}