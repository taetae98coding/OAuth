plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
    id("oauth.android.application")
}

kotlin {
    jvmToolchain(17)
}

android {
    namespace = "io.github.taetae98coding.oauth.sample"

    signingConfigs {
        create("key") {
            keyAlias = "taetae98coding"
            keyPassword = "1a2s3d"
            storeFile = file("keystore/key.jks")
            storePassword = "1a2s3d"
        }
    }

    defaultConfig {
        applicationId = "io.github.taetae98coding.oauth.sample"

        versionCode = 1
        versionName = "1.0.0"
    }

    buildTypes {
        debug {
            signingConfig = signingConfigs.getByName("key")
        }

        release {
            signingConfig = signingConfigs.getByName("key")
        }
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":sample:common"))
    implementation(project(":google"))

    implementation(libs.androidx.activity.compose)
    implementation(compose.foundation)
}
