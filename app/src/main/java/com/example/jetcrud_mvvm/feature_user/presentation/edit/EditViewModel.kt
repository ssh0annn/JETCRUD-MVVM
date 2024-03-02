package com.example.jetcrud_mvvm.feature_user.presentation.edit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetcrud_mvvm.feature_user.domain.model.User
import com.example.jetcrud_mvvm.feature_user.domain.use_cases.GetUser
import com.example.jetcrud_mvvm.feature_user.domain.use_cases.InsertUser

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class EditViewModel @Inject constructor(
    private  val getUser: GetUser,
    private val insertUser: InsertUser,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _nombreUser = mutableStateOf(TextFieldState())
    val nombreUser: State<TextFieldState> = _nombreUser

    private val _coreoUser = mutableStateOf(TextFieldState())
    val correoName: State<TextFieldState> = _coreoUser

    private val _passwordUser = mutableStateOf(TextFieldState())
    val passwordUser: State<TextFieldState> = _passwordUser

    private val _telefonoUser = mutableStateOf(TextFieldState())
    val telefonoUser: State<TextFieldState> = _telefonoUser

    private val _ICCIDUser = mutableStateOf(TextFieldState())
    val IICID: State<TextFieldState> = _ICCIDUser

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentIdUser: Int? = null



    init {
        savedStateHandle.get<Int>("userId")?.let { userId->
            if(userId != -1) {
                viewModelScope.launch {
                    getUser(userId).also {user->
                        currentIdUser = user!!.userId
                        _nombreUser.value = nombreUser.value.copy(
                            text = user.name
                        )

                        _coreoUser.value = correoName.value.copy(
                            text = user.correo
                        )

                        _passwordUser.value = passwordUser.value.copy(
                            text = user.password
                        )

                        _telefonoUser.value = telefonoUser.value.copy(
                            text = user.telefono
                        )

                        _ICCIDUser.value = IICID.value.copy(
                            text = user.ICCID
                        )
                    }
                }

            }
        }
    }

    fun onEvent(event: EditEvent){
        when(event) {
            is EditEvent.EnteredName -> {
                _nombreUser.value = nombreUser.value.copy(
                    text = event.value
                )
            }

            is EditEvent.EnteredCorreo -> {
                _coreoUser.value = correoName.value.copy(
                    text = event.value
                )
            }
            is EditEvent.EnteredPassword -> {
                _passwordUser.value = passwordUser.value.copy(
                    text = event.value
                )
            }
            is EditEvent.EnteredTelefono -> {
                _telefonoUser.value = telefonoUser.value.copy(
                    text = event.value
                )
            }
            is EditEvent.EnteredICCID -> {
                _ICCIDUser.value = IICID.value.copy(
                    text = event.value
                )
            }

            EditEvent.InsertUser -> {
                viewModelScope.launch {
                    insertUser(
                        User(
                            name = nombreUser.value.text,
                            correo = correoName.value.text,
                            password = passwordUser.value.text,
                            telefono = telefonoUser.value.text,
                            ICCID = IICID.value.text
                        )
                    )
                    _eventFlow.emit(UiEvent.SaveUser)
                }
            }
        }
    }

    sealed class UiEvent {
        object SaveUser: UiEvent()

    }

}