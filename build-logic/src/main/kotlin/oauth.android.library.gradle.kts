import com.android.build.api.dsl.LibraryExtension

plugins {
    id("com.android.library")
}

with(extensions.getByType<LibraryExtension>()) {
    defaultConfig {
        compileSdk = Build.ANDROID_COMPILE_SDK
        minSdk = Build.ANDROID_MIN_SDK
    }
}
