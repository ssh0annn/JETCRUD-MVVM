package com.example.jetcrud_mvvm.feature_user.presentation.home

import com.example.jetcrud_mvvm.feature_user.domain.model.User

data class HomeState(
    val users:List<User> = emptyList()
)
