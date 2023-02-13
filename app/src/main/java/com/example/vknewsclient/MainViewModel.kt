package com.example.vknewsclient

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vknewsclient.domain.FeedPost
import com.example.vknewsclient.domain.StatisticItem
import com.example.vknewsclient.ui.theme.NavigationItem

class MainViewModel : ViewModel() {

    private val sourceList = mutableListOf<FeedPost>().apply {
        repeat(10) {
            add(
                FeedPost(id = it)
            )
        }
    }

    private val _feedPosts = MutableLiveData<List<FeedPost>>(sourceList)
    val feedPosts: LiveData<List<FeedPost>> = _feedPosts

    private val _selectedNavItem = MutableLiveData<NavigationItem>(NavigationItem.Home)
    val selectedNavItem: LiveData<NavigationItem> = _selectedNavItem

    fun selectNavItem(item: NavigationItem){
        _selectedNavItem.value = item
    }

    fun remove(feedPost: FeedPost) {
        val modifiedList = feedPosts.value?.toMutableList() ?: mutableListOf()
        modifiedList.remove(feedPost)
        _feedPosts.value = modifiedList
    }

    fun updateCount(item: StatisticItem, feedPost: FeedPost) {

        val modifiedList = feedPosts.value?.toMutableList() ?: mutableListOf()
        modifiedList.replaceAll {
            if (it == feedPost) {
                val oldStatistics = it.statistic
                val newStatistics = oldStatistics.toMutableList().apply {
                    replaceAll { oldItem ->
                        if (oldItem.type == item.type) {
                            oldItem.copy(count = oldItem.count + 1)
                        } else {
                            oldItem
                        }
                    }
                }
                it.copy(statistic = newStatistics)
            } else {
                it
            }
        }
        _feedPosts.value = modifiedList
    }
}