package com.example.mvpmoviedb.model

import com.example.mvpmoviedb.presenter.MoviePresenter

class MovieInteractorImpl(var moviePresenter: MoviePresenter):MovieInteractor {


    private var movieRepository: MovieRepository = MovieRepositoryImp(moviePresenter)
    override fun loadListMovies(){
        movieRepository.loadListMovies()
    }
}