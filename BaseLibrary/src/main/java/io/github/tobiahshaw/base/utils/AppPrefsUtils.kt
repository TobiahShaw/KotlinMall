package io.github.tobiahshaw.base.utils

import android.annotation.SuppressLint
import android.content.Context
import io.github.tobiahshaw.base.common.BaseConstant


@SuppressLint("ApplySharedPref")
object AppPrefsUtils {

    fun putBoolean(context: Context, key: String, value: Boolean) {
        val sp = context.getSharedPreferences(BaseConstant.TABLE_PREFS, Context.MODE_PRIVATE)
        val ed = sp.edit()
        ed.putBoolean(key, value)
        ed.commit()
    }

    fun getBoolean(context: Context, key: String): Boolean {
        val sp = context.getSharedPreferences(BaseConstant.TABLE_PREFS, Context.MODE_PRIVATE)
        return sp.getBoolean(key, false)
    }

    fun putString(context: Context, key: String, value: String) {
        val sp = context.getSharedPreferences(BaseConstant.TABLE_PREFS, Context.MODE_PRIVATE)
        val ed = sp.edit()
        ed.putString(key, value)
        ed.commit()
    }

    fun getString(context: Context, key: String): String {
        val sp = context.getSharedPreferences(BaseConstant.TABLE_PREFS, Context.MODE_PRIVATE)
        return sp.getString(key, "") as String
    }

    fun putInt(context: Context, key: String, value: Int) {
        val sp = context.getSharedPreferences(BaseConstant.TABLE_PREFS, Context.MODE_PRIVATE)
        val ed = sp.edit()
        ed.putInt(key, value)
        ed.commit()
    }

    fun getInt(context: Context, key: String): Int {
        val sp = context.getSharedPreferences(BaseConstant.TABLE_PREFS, Context.MODE_PRIVATE)
        return sp.getInt(key, 0)
    }

    fun putLong(context: Context, key: String, value: Long) {
        val sp = context.getSharedPreferences(BaseConstant.TABLE_PREFS, Context.MODE_PRIVATE)
        val ed = sp.edit()
        ed.putLong(key, value)
        ed.commit()
    }

    fun getLong(context: Context, key: String): Long {
        val sp = context.getSharedPreferences(BaseConstant.TABLE_PREFS, Context.MODE_PRIVATE)
        return sp.getLong(key, 0)
    }

    fun putStringSet(context: Context, key: String, set: Set<String>) {
        val sp = context.getSharedPreferences(BaseConstant.TABLE_PREFS, Context.MODE_PRIVATE)
        val ed = sp.edit()
        val localSet = getStringSet(context, key).toMutableSet()
        localSet.addAll(set)
        ed.putStringSet(key, localSet)
        ed.commit()
    }

    fun getStringSet(context: Context, key: String): Set<String> {
        val sp = context.getSharedPreferences(BaseConstant.TABLE_PREFS, Context.MODE_PRIVATE)
        val set = setOf<String>()
        return sp.getStringSet(key, set) as Set<String>
    }

    fun remove(context: Context, key: String) {
        val sp = context.getSharedPreferences(BaseConstant.TABLE_PREFS, Context.MODE_PRIVATE)
        val ed = sp.edit()
        ed.remove(key)
        ed.commit()
    }
}
