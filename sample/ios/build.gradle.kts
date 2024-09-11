import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.Family

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    jvmToolchain(17)

    iosArm64()
    iosSimulatorArm64()
    applyDefaultHierarchyTemplate()

    targets.filterIsInstance<KotlinNativeTarget>()
        .filter { it.konanTarget.family == Family.IOS }
        .forEach { target ->
            target.binaries.framework {
                isStatic = true
                baseName = "IosAppKotlin"
            }
        }

    sourceSets {
        iosMain {
            dependencies {
                implementation(project(":sample:common"))
                implementation(compose.foundation)
            }
        }
    }
}
