package com.example.vknewsclient.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vknewsclient.MainViewModel

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    paddingValues: PaddingValues
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {

        val feedPosts = viewModel.feedPosts.observeAsState(listOf())
        val lazyListState = rememberLazyListState()

        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            state = lazyListState,
            contentPadding = PaddingValues(
                top = 16.dp,
                start = 8.dp,
                end = 8.dp,
                bottom = 72.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = feedPosts.value,
                key = { it.id }
            ) { feedPost ->

                val dismissState = rememberDismissState()

                if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                    viewModel.remove(feedPost)
                }

                SwipeToDismiss(
                    modifier = Modifier.animateItemPlacement(),
                    state = dismissState,
                    directions = setOf(DismissDirection.EndToStart),
                    background = {
                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxSize()
                                .background(color = Color.Red.copy(alpha = 0.5f)),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Text(
                                modifier = Modifier.padding(16.dp),
                                text = "Delete item",
                                color = Color.White,
                                fontSize = 24.sp
                            )
                        }
                    }
                ) {

                    PostCard(
                        feedPost = feedPost,
                        onViewsClickListener = { item, feedPost ->
                            viewModel.updateCount(
                                item,
                                feedPost
                            )
                        },
                        onCommentClickListener = { item, feedPost ->
                            viewModel.updateCount(
                                item,
                                feedPost
                            )
                        },
                        onLikeClickListener = { item, feedPost ->
                            viewModel.updateCount(
                                item,
                                feedPost
                            )
                        },
                        onShareClickListener = { item, feedPost ->
                            viewModel.updateCount(
                                item,
                                feedPost
                            )
                        }
                    )
                }
            }
        }
    }
}