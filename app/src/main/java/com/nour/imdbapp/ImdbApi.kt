package com.nour.imdbapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface ImdbApi {

    @Headers("x-rapidapi-host: imdb-top-100-movies.p.rapidapi.com",
        "x-rapidapi-key: d022b30f49mshd9eda29ff61cc00p1775f4jsn5ab387b16900",
        "Content-type: application/json"
    )
    @GET(".")
    suspend fun GetTopMovies():Response<ArrayList<Movie>>

    @Headers("x-rapidapi-host: imdb-top-100-movies.p.rapidapi.com",
        "x-rapidapi-key: d022b30f49mshd9eda29ff61cc00p1775f4jsn5ab387b16900",
        "Content-type: application/json"
    )
    @GET("/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") MovieID : String
    ): Response<Movie>

}