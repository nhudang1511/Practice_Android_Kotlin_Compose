package com.example.app30days.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Days(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val imgRes: Int
)
