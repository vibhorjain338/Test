package com.rareprob.core_pulgin.core.base

import android.app.Application
import com.rareprob.core_pulgin.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class BaseCoreApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initFirebase()
//        if(BuildConfig.DEBUG || BuildConfig.LOGS_ENABLED) {
        if(BuildConfig.DEBUG) {
            //Timber.plant(Timber.DebugTree())
        }
    }

    private fun initFirebase(){
    //    FirebaseApp.initializeApp(this)
       // val mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
    }
}