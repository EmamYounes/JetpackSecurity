package com.example.jetpacksecurity

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class SharedPreferences(var context: Context, var fileName: String) {
    var sharedPrefsEditor: SharedPreferences

    private val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
    private val masterKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)

    init {
        sharedPrefsEditor = createSharedPref()
    }

    private fun createSharedPref(): SharedPreferences {
        return EncryptedSharedPreferences.create(
            fileName, masterKeyAlias, context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }
}