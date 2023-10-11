package com.example.ratinglibrary

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout

class RatingView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    private val starEmptyResId = R.drawable.ic_star_empty
    private val starFilledResId = R.drawable.ic_star_filled

    private val starImageViews: ArrayList<ImageView> = ArrayList()

    // Current rating
    private var rating: Int = 0
    private var onRatingChangeListener: OnRatingChangeListener? = null

    init {
        orientation = HORIZONTAL

        // Initialize the star image views and add them to the layout
        for (i in 0 until MAX_RATING) {
            val starImageView = ImageView(context)
            starImageView.setImageResource(starEmptyResId)
            starImageView.setOnClickListener { onStarClicked(i + 1) }
            starImageViews.add(starImageView)
            addView(starImageView)
        }
    }

    // Update the star rating based on user interaction
    private fun onStarClicked(clickedRating: Int) {
        rating = clickedRating
        updateStarImages()
        onRatingChangeListener?.onRatingChanged(rating)
    }

    // Update the star images to reflect the current rating
    private fun updateStarImages() {
        for (i in 0 until MAX_RATING) {
            if (i < rating) {
                starImageViews[i].setImageResource(starFilledResId)
            } else {
                starImageViews[i].setImageResource(starEmptyResId)
            }
        }
    }

    // Set the rating programmatically
    fun setRating(rating: Int) {
        this.rating = rating
        updateStarImages()
    }

    // Get the current rating
    fun getRating(): Int {
        return rating
    }

    // Define a listener interface for rating changes
    interface OnRatingChangeListener {
        fun onRatingChanged(rating: Int)
    }

    // Set the listener
    fun setOnRatingChangeListener(listener: OnRatingChangeListener) {
        this.onRatingChangeListener = listener
    }

    companion object {
        private const val MAX_RATING = 5
    }
}