package com.meazza.news.ui.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meazza.news.business.repository.NewsRepository
import com.meazza.news.business.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    private val eventChannel = Channel<NewsEvents>()
    val events = eventChannel.receiveAsFlow()

    fun getBreakingNews() {
        viewModelScope.launch(IO) {
            eventChannel.send(NewsEvents.Loading)

            when (val response = repository.getNews()) {
                is Resource.Error -> eventChannel.send(NewsEvents.Failure(response.message!!))
                is Resource.Success -> {
                    val news = response.data
                    if (news != null) {
                        eventChannel.send(NewsEvents.Success(news))
                    } else {
                        eventChannel.send(NewsEvents.Failure("Empty"))
                    }
                }
            }
        }
    }
}