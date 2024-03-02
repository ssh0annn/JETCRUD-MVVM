package com.example.jetcrud_mvvm.feature_user.presentation.home.components

import android.content.res.Resources.Theme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetcrud_mvvm.feature_user.domain.model.User

@Composable
fun UserItem(
    modifier: Modifier = Modifier,
    user: User,
    onEditUser: () -> Unit,
    onDeleteUser: () -> Unit
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 12.dp),

        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {

                Text(

                    text = user.userId.toString(),
                    style = MaterialTheme.typography.bodyMedium

                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(

                    text = user.name,
                    style = MaterialTheme.typography.bodyMedium

                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(

                    text = user.correo,
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.DarkGray )

                )

                Spacer(modifier = Modifier.height(4.dp))
                Text(

                    text = user.password,
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.DarkGray )

                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(

                    text = user.ICCID.toString(),
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.DarkGray )

                )
            }

            Row {
                IconButton(onClick = onEditUser) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = null,
                        tint = Color.Green
                    )
                }

                IconButton(onClick = onDeleteUser) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = null,
                        tint = Color.Red
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewUserItem() {
    MaterialTheme {
        UserItem(
            user = User(name = "Johan Diaz" , correo = "therealdiaz@live.com", password = "sasad65sd" , telefono = "809-613-4992" , ICCID = "d6f8sdf6sdf" ),
            onEditUser = {},
            onDeleteUser = {}
        )
    }
}