package com.meazza.news.ui.news

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.meazza.news.R
import com.meazza.news.databinding.FragmentNewsBinding
import com.meazza.news.ui.news.NewsViewModel.*
import com.meazza.news.ui.news.NewsViewModel.NewsEvents.*
import com.meazza.news.ui.news.adapter.ArticleAdapter
import com.meazza.news.util.onQueryTextSubmit
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class NewsFragment : Fragment(R.layout.fragment_news) {

    private val newsViewModel by viewModels<NewsViewModel>()
    private val mAdapter by lazy { ArticleAdapter }

    private var _binding: FragmentNewsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNewsBinding.bind(view).apply {
            lifecycleOwner = this@NewsFragment
            adapter = mAdapter
        }

        newsViewModel.getBreakingNews()

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            newsViewModel.run {
                events.collect { events ->
                    when (events) {
                        is Loading -> {
                        }
                        is Failure -> {
                        }
                        is Success -> {
                            mAdapter.submitList(events.articles)
                        }
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)

        val searchItem = menu.findItem(R.id.mn_search)
        val searchView = searchItem.actionView as SearchView

        searchView.onQueryTextSubmit {
            newsViewModel.searchQuery.value = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}