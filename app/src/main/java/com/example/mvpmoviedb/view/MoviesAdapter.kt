package com.example.mvpmoviedb.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpmoviedb.R
import com.example.mvpmoviedb.model.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.activity_detail.view.tv_releaseDate
import kotlinx.android.synthetic.main.activity_detail.view.tv_title
import kotlinx.android.synthetic.main.movie_list_item.view.*
import kotlinx.android.synthetic.main.movie_list_item.view.iv_picture as iv_picture1


class MoviesAdapter(movieList:ArrayList<Result>):
RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>(){

    private var movieList = ArrayList<Result>()
    init{
        this.movieList = movieList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemView=
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item,parent,false)
        return MoviesViewHolder(itemView)
    }

    override fun getItemCount(): Int=movieList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movieList[position]
        holder.setMovie(movie)
    }

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {


        init{
            itemView.setOnClickListener(this)
        }
       fun setMovie(movie: Result){
           val url_img = "https://image.tmdb.org/t/p/w500"
           itemView.tv_title.text = movie.title
           itemView.tv_releaseDate.text = movie.releaseDate
           itemView.tv_voteAverage.text = movie.voteAverage.toString()
           Picasso.get().load(url_img+movie.posterPath).into(itemView.iv_picture)

       }
        override fun onClick(v: View?) {

        }
    }
}