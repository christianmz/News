package com.meazza.news.util

import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import coil.Coil
import coil.load
import com.meazza.news.R

fun ImageView.loadUrl(url: String?) {
    load(url, Coil.imageLoader(context)) {
        crossfade(600)
        error(R.color.white)
        placeholder(R.color.white)
    }
}

inline fun SearchView.onQueryTextSubmit(crossinline listener: (String) -> Unit) {
    this.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            listener(query.orEmpty())
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            return true
        }
    })
}