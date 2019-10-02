package com.example.mvpmoviedb.model

import com.example.mvpmoviedb.presenter.MoviePresenter
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response



class MovieRepositoryImp(var moviePresenter: MoviePresenter): MovieRepository {
    override fun loadListMovies() {
        val api_key="e7ee21768709428287ee5a9431a98c1a"
        ApiService.create()
            .getTopRated(api_key)
            .enqueue(object : Callback<Movies> {
                override fun onFailure(call: Call<Movies>, t: Throwable){
                    moviePresenter.showErrorLoadMovies(t.message)
                }
                override fun onResponse(call: Call<Movies>,response: Response<Movies>){
                    if(response.isSuccessful)
                        moviePresenter.sendListMovies(response.body()?.results)
                }

            })
    }
}