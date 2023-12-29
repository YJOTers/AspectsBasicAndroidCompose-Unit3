package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val idTitle: Int,
    val numCourses: Int,
    @DrawableRes val idImage: Int
)