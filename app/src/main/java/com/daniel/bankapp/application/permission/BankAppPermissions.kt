package com.daniel.bankapp.application.permission

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import org.koin.core.KoinComponent
import org.koin.core.inject

class BankAppPermissions : KoinComponent {

    private val context: Context by inject()

    private fun getRequiredPermissions(): Array<String> {
        return listOf(
            Manifest.permission.GET_ACCOUNTS,
            Manifest.permission.INTERNET,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.ACCESS_WIFI_STATE
        ).toTypedArray()
    }

    fun checkPermissions(): Boolean {
        var result = false
        val permissions = getRequiredPermissions()
        loop@ for (permissionItem in permissions.indices) {
            when {
                context.checkCallingOrSelfPermission(permissions[permissionItem]) == PackageManager.PERMISSION_DENIED -> {
                    result = false
                    break@loop
                }
                context.checkCallingOrSelfPermission(permissions[permissionItem]) == PackageManager.PERMISSION_GRANTED && permissionItem == permissions.size - 1 -> {
                    result = true
                }
            }
        }
        return result
    }
}