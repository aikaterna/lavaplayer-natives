plugins {
    id("java")
    id("maven-publish")
}

group = "com.github.aikaterna"
version = "2.0.0"

repositories {
    mavenCentral()
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

publishing {
    publications {
        register("mavenJava", MavenPublication::class) {
            from(components["java"])
            artifact(sourcesJar.get())
        }
    }
}