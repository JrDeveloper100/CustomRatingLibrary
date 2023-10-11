package com.example.customratinglibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ratinglibrary.RatingView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ratingView = findViewById<RatingView>(R.id.ratingView)

        // Set the listener to handle rating changes
        ratingView.setOnRatingChangeListener(object : RatingView.OnRatingChangeListener {
            override fun onRatingChanged(rating: Int) {
                // You can use 'rating' as needed here.
                ratingView.setRating(rating)
            }
        })

    }
}