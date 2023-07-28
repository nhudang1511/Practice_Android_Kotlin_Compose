package com.example.app30days.data

import com.example.app30days.R
import com.example.app30days.model.Days

object DaysRepository {
    val days = listOf(
        Days(title = R.string.day1,
            description = R.string.description1,
            imgRes = R.drawable.day1_bryce_canyon
            ),
        Days(title = R.string.day2,
            description = R.string.description2,
            imgRes = R.drawable.day2_dark_light
        ),
        Days(title = R.string.day3,
            description = R.string.description3,
            imgRes = R.drawable.day3_flamingo
        ),
        Days(title = R.string.day4,
            description = R.string.description4,
            imgRes = R.drawable.day4_flying_in_the_light
        ),
        Days(title = R.string.day5,
            description = R.string.description5,
            imgRes = R.drawable.day5_hot_sand
        ),
        Days(title = R.string.day6,
            description = R.string.description6,
            imgRes = R.drawable.day6_light_to_sand
        ),
        Days(title = R.string.day7,
            description = R.string.description7,
            imgRes = R.drawable.day7_path_to_my_heart
        ),
        Days(title = R.string.day8,
            description = R.string.description8,
            imgRes = R.drawable.day8_reunion
        ),
        Days(title = R.string.day9,
            description = R.string.description9,
            imgRes = R.drawable.day9_rockaway_river_sunset
        ),
        Days(title = R.string.day10,
            description = R.string.description10,
            imgRes = R.drawable.day10_tunnel_of_light
        )
    )
}