package com.nour.imdbapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.mWebView
import kotlinx.android.synthetic.main.activity_movie_details.movie_big_image
import kotlinx.android.synthetic.main.activity_movie_details.movie_description_details
import kotlinx.android.synthetic.main.activity_movie_details.movie_rating_details
import kotlinx.android.synthetic.main.row_movie.movie_title

class movie_details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        val movieId = intent.extras!!.getString("movie_id")
        val movieVM = ViewModelProvider(this)[MoviesViewModel::class.java]
        movieVM.getMovieDetails(movieId!!)
        movieVM.movie.observe(this){movie ->
            movie_title.text = movie.title
            movie_description_details.text = movie.description
            movie_rating_details.text = movie.rating
            Picasso.get().load(movie.big_image).into(movie_big_image)
            mWebView.settings.javaScriptEnabled = true
            mWebView.loadUrl(movie.trailer_embed_link)
            mWebView.webChromeClient = WebChromeClient()
        }

    }
}