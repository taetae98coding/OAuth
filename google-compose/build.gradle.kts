import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
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

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                api(project(":google"))
            }
        }

        androidMain {
            dependencies {
                implementation(compose.ui)
            }
        }

        iosMain {
            dependencies {
                implementation(compose.ui)
            }
        }
    }
}

android {
    namespace = "io.github.taetae98coding.oauth.google.compose"
}

mavenPublishing {
    coordinates(
        groupId = "io.github.taetae98coding",
        artifactId = "oauth-google-compose",
        version = Build.LIBRARY_VERSION
    )

    pom {
        name.set("OAuth-Google-Compose")
        description.set("Kotlin Google OAuth Compose Extension")
        inceptionYear.set("2024")
    }
}
