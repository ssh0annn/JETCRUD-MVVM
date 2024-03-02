package com.example.jetcrud_mvvm.feature_user.presentation.home

import com.example.jetcrud_mvvm.feature_user.domain.model.User

sealed class HomeEvent {
    data class DeleteUser(val user: User ):HomeEvent()
}