package uz.gita.contactwitworker.data.source.local.shared

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Shared @Inject constructor(private val mPref: SharedPreferences) {

    fun isFirstTime(): Boolean {
        return mPref.getBoolean("first", true)
    }

    fun openFirstTime() = mPref.edit().putBoolean("first", false).apply()
}