package com.example.jetcrud_mvvm.feature_user.presentation.edit

sealed class EditEvent {
    data class EnteredName(val value: String): EditEvent()
    data class EnteredCorreo(val value: String): EditEvent()
    data class EnteredPassword(val value: String): EditEvent()
    data class EnteredTelefono(val value: String): EditEvent()
    data class EnteredICCID(val value: String): EditEvent()
    object InsertUser:EditEvent()
}