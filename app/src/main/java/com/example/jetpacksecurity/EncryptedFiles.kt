package com.example.jetpacksecurity

import android.content.Context
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.MasterKeys
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class EncryptedFiles(context: Context, fileName: String) {

    var encryptedOutputStream: FileOutputStream

    var encryptedInputStream: FileInputStream

    init {
        val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
        val masterKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)
        val encryptedFile = EncryptedFile.Builder(
            File(context.filesDir, fileName),
            context, masterKeyAlias, EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
        ).build()
        encryptedOutputStream = encryptedFile.openFileOutput()

        encryptedInputStream = encryptedFile.openFileInput()
    }

}