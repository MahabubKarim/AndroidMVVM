package com.example.androidapps2.core.utils

import java.text.SimpleDateFormat
import java.util.Locale

object DateUtils {
    public fun getFormattedDate(inputDate: String) : String {
        val inputDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val outputDateFormat = SimpleDateFormat("MM-dd-yyyy hh:ss", Locale.getDefault())

        val modifiedDate = inputDateFormat.parse(inputDate)

        return outputDateFormat.format(modifiedDate)
    }
}