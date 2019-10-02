package com.example.mvpmoviedb.presenter

import com.example.mvpmoviedb.model.MovieInteractor
import com.example.mvpmoviedb.model.MovieInteractorImpl
import com.example.mvpmoviedb.model.Result
import com.example.mvpmoviedb.view.MovieView

class MoviePresenterImp(var movieView: MovieView): MoviePresenter {
    override fun showErrorLoadMovies(message: String?) {
        movieView.showErrorLoadMovies(message)
    }

    override fun sendListMovies(results: List<Result>?) {
        movieView.showListMovies(results)    }

    private var movieInteractor: MovieInteractor = MovieInteractorImpl(this)
    override fun loadListMovies() {
        movieInteractor.loadListMovies()
    }

}