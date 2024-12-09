package io.github.atharvamahamuni.gridapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic (
    @StringRes val topicNameId: Int,
    val numberOfChapters: Int, // or a drawable resource
    @DrawableRes val imageResourceId: Int
)