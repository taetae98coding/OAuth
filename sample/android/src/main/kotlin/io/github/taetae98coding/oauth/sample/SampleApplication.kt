package io.github.taetae98coding.oauth.sample

import android.app.Application
import io.github.taetae98coding.oauth.google.GoogleCredentialManager

class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        GoogleCredentialManager.init("117128592967-4pkr8cutjap1vrk5c0bf9u4d8obi0esu.apps.googleusercontent.com")
    }
}