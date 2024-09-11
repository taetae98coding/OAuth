import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.cocoapods)
    id("oauth.android.library")
    id("oauth.maven.publish")
}

kotlin {
    explicitApi()
    jvmToolchain(17)

    androidTarget()
    iosArm64()
    iosSimulatorArm64()
    jvm()
    applyDefaultHierarchyTemplate()

    cocoapods {
        noPodspec()

        ios.deploymentTarget = "12"

        pod("GoogleSignIn") {
            version = "8.0.0"
        }
    }

    sourceSets {
        androidMain {
            dependencies {
                implementation(libs.androidx.credentials)
                // Android 13 and below.
                implementation(libs.androidx.credentials.play)
                implementation(libs.google.id)
            }
        }

        iosMain {
            dependencies {
                implementation(libs.coroutines.core)
            }
        }
    }

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        freeCompilerArgs.add("-Xexpect-actual-classes")
    }
}

android {
    namespace = "io.github.taetae98coding.oauth.google"
}

mavenPublishing {
    coordinates(
        groupId = "io.github.taetae98coding",
        artifactId = "oauth-google",
        version = Build.LIBRARY_VERSION
    )

    pom {
        name.set("OAuth-Google")
        description.set("Kotlin Google OAuth")
        inceptionYear.set("2024")
    }
}
