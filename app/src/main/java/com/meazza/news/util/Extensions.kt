package com.meazza.news.util

import android.widget.ImageView
import coil.Coil
import coil.load
import com.meazza.news.R

fun ImageView.loadUrl(url: String?) {
    load(url, Coil.imageLoader(context)) {
        crossfade(true)
        error(R.color.white)
        placeholder(R.color.white)
    }
}