package com.example.movielistscreens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielistscreens.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var movieAdapter: MyAdapter

    private val movieList = listOf(
        Movie("The Godfather", "March,10,1969",  R.drawable.the_godfather),
        Movie("The Dark Knight", "July 18, 2008", R.drawable.the_dark_knight),
        Movie("The Godfather Part II", "December 12, 1974", R.drawable.the_godfather_part_two)

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieAdapter = MyAdapter(movieList)
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = movieAdapter

        updateMovies()
    }
    data class Movie(
        val title: String,
        val date: String,
        val imageResId: Int
    )

    private fun updateMovies() {
        val newMovieList = listOf(
            Movie("12 angry men", "January 1, 1954", R.drawable.twelve_angry_men)
        )
//        movieAdapter.updateList(newMovieList) 
    }
}



