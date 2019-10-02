package com.example.mvpmoviedb.presenter
import com.example.mvpmoviedb.model.Result


interface MoviePresenter {
    fun loadListMovies()
    fun showErrorLoadMovies(message: String?)

    fun sendListMovies(results: List<Result>?)

}