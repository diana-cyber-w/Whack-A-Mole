package com.example.whac_a_mole.utils

interface SharedPreferenceManager {
    fun saveInt(key: String, value: Int)

    fun getInt(key: String): Int
}