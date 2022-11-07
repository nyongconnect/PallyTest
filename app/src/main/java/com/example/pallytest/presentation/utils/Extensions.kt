package com.example.pallytest.presentation.utils

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.pallytest.R

fun TextView.setTextDiff(wordOne: String, spanIndex: Int) {
    val word = SpannableString(wordOne.slice(0 until spanIndex))
    val secondWord = SpannableString(wordOne.substring(spanIndex until wordOne.length))
    word.setSpan(
        ForegroundColorSpan(ContextCompat.getColor(context, R.color.white)), 0, word.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    secondWord.setSpan(
        ForegroundColorSpan(ContextCompat.getColor(context, R.color.grey)),
        0,
        secondWord.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    text = word
    append(secondWord)
}