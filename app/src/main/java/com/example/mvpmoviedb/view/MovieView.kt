package com.example.mvpmoviedb.view

import com.example.mvpmoviedb.model.Result

interface MovieView {

    fun showErrorLoadMovies(message: String?)
    fun showListMovies(results: List<Result>?)

}