package com.example.whac_a_mole.utils

import android.content.Context

class SharedPreferenceManagerImpl(context: Context) : SharedPreferenceManager {

    private val prefs by lazy { context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE) }

    override fun saveInt(key: String, value: Int) {
        prefs.edit()
            .putInt(key, value)
            .apply()
    }

    override fun getInt(key: String): Int {
        return prefs.getInt(key, DEFAULT_INT_VALUE)
    }

    companion object {
        private const val PREFS_NAME = "SHARED_PREFS_NAME"
        private const val DEFAULT_INT_VALUE = 0
    }
}