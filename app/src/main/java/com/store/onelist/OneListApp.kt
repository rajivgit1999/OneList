package com.store.onelist

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class OneListApp: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}