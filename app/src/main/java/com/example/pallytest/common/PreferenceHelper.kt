package com.example.pallytest.common

import android.content.Context
import android.content.SharedPreferences
import com.example.pallytest.common.AppConstants.APP_SHARED_PREFERENCE
import com.example.pallytest.common.AppConstants.IS_LOGGED
import com.example.pallytest.common.AppConstants.TOKEN
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PreferenceHelper @Inject constructor(context: Context) {

    private val pref: SharedPreferences =
        context.getSharedPreferences(APP_SHARED_PREFERENCE, Context.MODE_PRIVATE)

    private val editor = pref.edit()

    var isLoggedIn: Boolean
        get() = pref.getBoolean(IS_LOGGED, false)
        set(value) {
            editor.putBoolean(IS_LOGGED, value).apply()
        }

    var token: String?
        get() = pref.getString(TOKEN, null)
        set(value) {
            editor.putString(TOKEN, value).apply()
        }

    private fun clearKeys(keys: List<String>) {
        for (key: String in keys) {
            editor.remove(key)
        }
        editor.apply()
    }

    fun clearSharedPreferences() {
        val keys = listOf(
            IS_LOGGED,
            TOKEN
        )
        clearKeys(keys)
    }
}