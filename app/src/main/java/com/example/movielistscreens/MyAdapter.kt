package com.example.movielistscreens

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movielistscreens.MainActivity.Movie
import com.example.movielistscreens.databinding.RvMovieItemsBinding


class MyAdapter(private var movies: List<Movie>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(val binding: RvMovieItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie){
            binding.title.text = movie.title
            binding.date.text = movie.date
            binding.image.setImageDrawable(ContextCompat.getDrawable(binding.root.context, movie.imageResId)
            )


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder (RvMovieItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int =movies.size

    fun updateList(newList:List<Movie>){
        val diffUtilCallback = MyDiffUtil(oldList = this.movies, newList = newList)
        val diffResult = DiffUtil.calculateDiff(diffUtilCallback)

        this.movies = newList
        diffResult.dispatchUpdatesTo(this)

    }

    }


