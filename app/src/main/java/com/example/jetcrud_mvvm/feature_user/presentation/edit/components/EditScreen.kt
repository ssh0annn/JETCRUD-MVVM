package com.example.jetcrud_mvvm.feature_user.presentation.edit.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.androidperu.peopleapp.feature_users.presentation.edit.components.UserInputText
import com.example.jetcrud_mvvm.feature_user.presentation.edit.EditEvent
import com.example.jetcrud_mvvm.feature_user.presentation.edit.EditViewModel
import kotlinx.coroutines.flow.collectLatest

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EditScreen(
    navController: NavController,
    viewModel: EditViewModel = hiltViewModel()
){
    val nameState = viewModel.nombreUser.value
    val correoState = viewModel.correoName.value
    val passwordState = viewModel.passwordUser.value
    val telefonoState = viewModel.telefonoUser.value
    val ICCID = viewModel.IICID.value
    
    LaunchedEffect(key1 = true){
        viewModel.eventFlow.collectLatest {event->
            when(event){
                is EditViewModel.UiEvent.SaveUser -> {
                    navController.navigateUp()
                }
            }

        }
    }

    Scaffold(
        topBar = {
            EditTopBar(
                topAppBarText =stringResource(id = com.example.jetcrud_mvvm.R.string.add_user)
            )
        },
        content = {
            EditContent(
                name = nameState.text,
                correo = correoState.text,
                telefono = telefonoState.text,
                password = passwordState.text,
                ICCID = ICCID.text,
                onEvent = { viewModel.onEvent(it) }
            )
        },
        bottomBar = {
            EditBottomBar(
                onInsertUser = { viewModel.onEvent(EditEvent.InsertUser) }
            )
        }
    )
}


@Composable
fun EditBottomBar(
    modifier: Modifier = Modifier,
    onInsertUser: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 14.dp),
        onClick = { onInsertUser() }
    ) {
        Text(text = stringResource( id = com.example.jetcrud_mvvm.R.string.add_user))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTopBar(topAppBarText: String) {
    TopAppBar(
        title = {
            Text(
                text = topAppBarText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        Modifier.background(MaterialTheme.colorScheme.surface)
    )
}


@Composable
fun EditContent(
    name: String,
    correo: String,
    telefono: String,
    password: String,
    ICCID: String,
    onEvent: (EditEvent) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(44.dp))
        UserInputText(
            text = name,
            hint = stringResource(id = com.example.jetcrud_mvvm.R.string.nombre_usuario),
            onTextChange = { onEvent(EditEvent.EnteredName(it)) }
        )
        UserInputText(
            text = correo,
            hint = stringResource(id = com.example.jetcrud_mvvm.R.string.correo_usuario),
            onTextChange = { onEvent(EditEvent.EnteredCorreo(it)) }
        )
        UserInputText(
            text = telefono,
            hint = stringResource(id = com.example.jetcrud_mvvm.R.string.telefono_usuario),
            onTextChange = { onEvent(EditEvent.EnteredTelefono(it)) }
        )
        UserInputText(
            text = password,
            hint = stringResource(id = com.example.jetcrud_mvvm.R.string.password_usuario),
            onTextChange = { onEvent(EditEvent.EnteredPassword(it)) }
        )
        UserInputText(
            text = ICCID,
            hint = stringResource(id = com.example.jetcrud_mvvm.R.string.ICCID_usuario),
            onTextChange = { onEvent(EditEvent.EnteredICCID(it)) }
        )
    }
}
