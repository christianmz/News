package com.meazza.news.ui.news

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.meazza.news.R

class NewsFragment : Fragment(R.layout.fragment_news) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.nav_bookmarks -> {
                findNavController().navigate(R.id.action_bookmarks)
                true
            }
            R.id.mn_dark_theme -> {
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}