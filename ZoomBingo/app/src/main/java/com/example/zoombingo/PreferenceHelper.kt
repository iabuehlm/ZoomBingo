package com.example.zoombingo

class PreferenceHelper {

    companion object {
        fun getPreferenceValue(key: String): Int {
            return MainActivity.preferences!!.getInt(key, 0)
        }

        fun setPreferenceValue(key: String, value: Int) {
            MainActivity.preferences!!.edit().putInt(key, value).apply()
        }
    }
}