package com.example.jetcrud_mvvm.feature_user.presentation.home

sealed class Screen (val route:String){
    object Home: Screen("home")
    object edit: Screen("edit?userId={userId}"){
        fun passId(userId: Int?): String{
            return "edit?userId=$userId"
        }
    }
}