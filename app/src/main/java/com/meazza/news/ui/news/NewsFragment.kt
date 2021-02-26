package com.meazza.news.ui.news

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.meazza.news.R
import com.meazza.news.databinding.FragmentNewsBinding
import com.meazza.news.ui.adapters.ArticleAdapter
import com.meazza.news.ui.news.NewsEvents.*
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
            newsViewModel.events.collect { events ->
                when (events) {
                    is Loading -> {
                    }
                    is Failure -> {
                        Toast.makeText(requireContext(), events.errorText, Toast.LENGTH_SHORT)
                            .show()
                    }
                    is Success -> {
                        mAdapter.submitList(events.articles)
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mn_bookmarks -> {
                findNavController().navigate(R.id.action_bookmarks)
                true
            }
            R.id.mn_dark_theme -> {
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}