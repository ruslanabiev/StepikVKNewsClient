package com.example.vknewsclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vknewsclient.ui.theme.PostCard
import com.example.vknewsclient.ui.theme.VkNewsClientTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            VkNewsClientTheme() {
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(MaterialTheme.colors.background)
//                        .padding(8.dp)
//                ) {
//                    PostCard()
//                }
//            }
            Test()
        }
    }
}

@Composable
private fun Test() {
    Scaffold(
        topBar = {
            TopAppBar(
                title =
                {
                    Text(text = "TopAppBar title")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Menu, contentDescription = "")
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigation() {
                BottomNavigationItem(
                    selected = true,
                    onClick = { },
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                    label = { Text(text = "Favorite") }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { },
                    icon = { Icon(Icons.Outlined.Edit, contentDescription = null) },
                    label = { Text(text = "Edit") }
                )
                BottomNavigationItem(
                    selected = false,
                    onClick = { },
                    icon = { Icon(Icons.Outlined.Delete, contentDescription = null) },
                    label = { Text(text = "Delete") }
                )
            }
        },
        drawerContent = {
            Text(text = "text 1")
            Text(text = "text 2")
            Text(text = "text 3")
        }
    ) {
        Text(
            modifier = Modifier.padding(it),
            text = "This is Scaffold content"
        )
    }
}
