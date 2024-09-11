import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension

plugins {
    id("com.android.application")
}

with(extensions.getByType<ApplicationExtension>()) {
    defaultConfig {
        compileSdk = Build.ANDROID_COMPILE_SDK
        minSdk = Build.ANDROID_MIN_SDK
        targetSdk = Build.ANDROID_TARGET_SDK
    }
}
