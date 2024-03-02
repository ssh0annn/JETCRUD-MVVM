package com.example.jetcrud_mvvm.feature_user.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jetcrud_mvvm.R
import com.example.jetcrud_mvvm.feature_user.domain.model.User
import com.example.jetcrud_mvvm.feature_user.presentation.home.components.UserItem

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()


) {

    val state = viewModel.state.value

    Scaffold(
        topBar = {
            HomeTopBar()

        },
        floatingActionButton = {
            HomeFap(
                onFabClicked = {navController.navigate(Screen.edit.route)}
            )
        },

        content = {innerPaddind->
            HomeContent(
                modifier = Modifier.padding(innerPaddind),
                onDeleteUser = {viewModel.onEvent(HomeEvent.DeleteUser(it))},
                onEditUser = {
                    navController.navigate(
                        route = Screen.edit.passId(it)
                    )
                },
                users = state.users
            )

        }


    )
}



@Composable
fun HomeFap(
    modifier: Modifier = Modifier,
    onFabClicked: () -> Unit = { }
) {
    FloatingActionButton(
        onClick = onFabClicked,
        modifier = modifier
            .height(52.dp)
            .widthIn(min = 52.dp)
            .background(MaterialTheme.colorScheme.primary)
   ) {

        Icon(imageVector = Icons.Outlined.AddCircle, contentDescription = stringResource(id = R.string.add_user))
        
    }
}


@ExperimentalMaterial3Api
@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.users),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        modifier = modifier.background(MaterialTheme.colorScheme.surface)

    )
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onDeleteUser: (user:User) -> Unit,
    onEditUser: (id:Int) -> Unit,
    users: List<User> = emptyList()
) {
    Surface (
        color = MaterialTheme.colorScheme.surface,
        modifier = modifier
    ){

        LazyColumn{
            items(users){user->
                UserItem(
                    user = user,
                    onEditUser = { onEditUser(user.userId!!)},
                    onDeleteUser = { onDeleteUser(user) }
                )
                }
            }
        }
    }


