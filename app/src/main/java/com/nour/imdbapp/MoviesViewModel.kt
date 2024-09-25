package com.nour.imdbapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {
    var movies = MutableLiveData<ArrayList<Movie>>()
    var movie = MutableLiveData<Movie>()
    fun getTopMovies() = CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = RetrofitInstance.movieApi.GetTopMovies()
            if (response.isSuccessful){
                CoroutineScope(Dispatchers.Main).launch {
                    movies.value = response.body()
                }
            }else{
                // display errors to the users
                val error = response.errorBody()
            }
        }catch (e:Exception){
            println(e.message)
        }
    }
    fun getMovieDetails(movieID : String) = CoroutineScope(Dispatchers.IO).launch {
        try{
            val response = RetrofitInstance.movieApi.getMovieDetails(movieID)
            if (response.isSuccessful){
                CoroutineScope(Dispatchers.Main).launch {
                    movie.value = response.body()
                }

            }else{
                // error managemenet ...
            }
        }catch (e :Exception){
            println(e.message)
        }
    }
}