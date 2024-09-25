package com.nour.imdbapp

data class Movie (
    val id : String,
    val rank : Int,
    val title : String,
    val description : String,
    val image : String,
    val big_image : String,
    val genre : ArrayList<String>,
    val rating : String,
    val year : Int,
    val trailer_embed_link : String,
    val writers : ArrayList<String>,
)