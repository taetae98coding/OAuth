import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.vanniktech.maven.publish")
}

with(extensions.getByType<MavenPublishBaseExtension>()) {
    pom {
        url.set("https://github.com/taetae98coding/OAuth")

        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }

        developers {
            developer {
                id.set("taetrae98coding")
                name.set("taetae98coding")
                email.set("taetae98coding@gmail.com")
                url.set("https://github.com/taetae98coding")
            }
        }

        scm {
            url.set("https://github.com/taetae98coding/OAuth")
            connection.set("scm:git:git://github.com/taetae98coding/OAuth.git")
            developerConnection.set("scm:git:ssh://git@github.com:taetae98coding/OAuth.git")
        }
    }

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
}
