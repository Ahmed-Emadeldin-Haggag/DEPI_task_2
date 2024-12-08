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
        Movie("The Godfather Part II", "December 12, 1974", R.drawable.the_godfather_part_two),
        Movie("The Shawshank Redemption", "September 22, 1994", R.drawable.shawshank_redemption),
        Movie("The Godfather Part III", "December 25, 1990", R.drawable.the_godfather_part_three),
        Movie("The Matrix", "March 31, 1999", R.drawable.the_matrix),
        Movie("Inception", "July 16, 2010", R.drawable.inception),
        Movie("The Lord of the Rings: The Return of the King", "December 17, 2003", R.drawable.lotr_return_of_the_king),
        Movie("Forrest Gump", "July 6, 1994", R.drawable.forrest_gump),
        Movie("Schindler's List", "December 15, 1993", R.drawable.schindlers_list),
        Movie("Fight Club", "October 15, 1999", R.drawable.fight_club)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieAdapter = MyAdapter(movieList)
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.rvMovies.adapter = movieAdapter

        val user_name = intent.getStringExtra("username") ?: "Guest"

        binding.greet.text = "Welcome, $user_name"



        updateMovies()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
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



