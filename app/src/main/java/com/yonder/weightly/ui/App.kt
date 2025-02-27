package com.yonder.weightly.ui

import android.app.Application
import com.orhanobut.hawk.Hawk
import com.vanniktech.emoji.EmojiManager
import com.vanniktech.emoji.google.GoogleEmojiProvider
import com.yonder.weightly.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.*


@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setupTimber()
        setupHawk()
        setupEmojiManager()
    }

    private fun setupEmojiManager(){
        EmojiManager.install(GoogleEmojiProvider());
    }
    private fun setupHawk(){
        Hawk.init(this).build();
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

}