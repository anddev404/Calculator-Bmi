package com.anddev404.calculatorbmi.data

import android.content.Context
import com.anddev404.calculatorbmi.data.local.LocalDataSource
import com.anddev404.calculatorbmi.data.local.SharedPreferences

/**
 * Klasa zawiera dostęp do zapisywanych danych na urządzeniu.
 * W tym przypadku dostęp do SharedPreferences jest wystarczający.
 */
class Repository(private val context: Context) {

    fun getLocalDataSource(): LocalDataSource {
        return SharedPreferences(context)
    }
}