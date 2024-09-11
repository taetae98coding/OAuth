# OAuth for Kotlin

[![GitHub license](https://img.shields.io/github/license/kotlin/kotlinx.collections.immutable)](LICENSE.txt) 
[![Maven Central](https://img.shields.io/maven-central/v/io.github.taetae98coding/oauth-google.svg?label=Maven%20Central)](https://central.sonatype.com/artifact/io.github.taetae98coding/oauth-google)

- Kotlin OAuth.
- Support Kotlin Multiplatform

## Gradle
Add Maven Central Repository.
```groovy
repositories {
    mavenCentral()
}
```
For Single Platform
```groovy
 dependencies {
    implementation("io.github.taetae98coding:oauth-google:latest-version")
    implementation("io.github.taetae98coding:oauth-google-compose:latest-version")
 }
```

For Multiplatform
```groovy
kotlin {
    sourceSets {
        commonMain {
             dependencies {
                 implementation("io.github.taetae98coding:oauth-google:latest-version")
                 implementation("io.github.taetae98coding:oauth-google-compose:latest-version")
             }
        }
    }
}
```
