package com.example.mvpmoviedb.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpmoviedb.R
import com.example.mvpmoviedb.model.Result
import com.example.mvpmoviedb.presenter.MoviePresenter
import com.example.mvpmoviedb.presenter.MoviePresenterImp
import kotlinx.android.synthetic.main.fragment_movies.view.*

//private var moviePresenter: ?MoviePresenter= null

class MoviesFragment : Fragment(),MovieView {
    private lateinit var root:View

    private var moviePresenter: MoviePresenter?=null  //esta e sla interfaz
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_movies, container, false)

        moviePresenter=MoviePresenterImp(this)

       // moviePresenter?.loadListMovies()
        getMovies()
        return root
    }
    override fun showErrorLoadMovies(message: String?) {
        Toast.makeText(activity?.applicationContext,"Error",Toast.LENGTH_LONG)

    }

    override fun showListMovies(results: List<Result>?) {
        root.recycler_view.layoutManager = LinearLayoutManager(activity?.applicationContext,
            RecyclerView.VERTICAL,
            false)
        val movieAdapter = MoviesAdapter(results as ArrayList<Result>)
        root.recycler_view.adapter=movieAdapter

    }
    private fun getMovies(){
        moviePresenter?.loadListMovies()
    }
}