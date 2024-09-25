package com.nour.imdbapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.movies_list
import kotlinx.android.synthetic.main.activity_main.progressBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val MovieVm = ViewModelProvider(this)[MoviesViewModel::class.java]
        MovieVm.getTopMovies()
        MovieVm.movies.observe(this){ data ->
            movies_list.layoutManager = GridLayoutManager(this,3)
            movies_list.adapter = MovieAdapter(this,data)
            progressBar.visibility = View.GONE
        }
    }
}